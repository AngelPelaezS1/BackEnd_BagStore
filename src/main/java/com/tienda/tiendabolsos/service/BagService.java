package com.tienda.tiendabolsos.service;

import com.tienda.tiendabolsos.dto.CreateBagRequest;
import com.tienda.tiendabolsos.enums.AvailabilityStatus;
import com.tienda.tiendabolsos.mapper.BagMapper;
import com.tienda.tiendabolsos.model.Bag;
import com.tienda.tiendabolsos.model.BagImage;
import com.tienda.tiendabolsos.model.User;
import com.tienda.tiendabolsos.repository.BagRepository;
import org.springframework.web.multipart.MultipartFile;

public class BagService {

    private final ImageStorageService imageStorageService;
    private final BagRepository bagRepository;
    private final AuthService authService;

    public BagService(ImageStorageService imageStorageService, BagRepository bagRepository, AuthService authService) {
        this.imageStorageService = imageStorageService;
        this.bagRepository = bagRepository;
        this.authService = authService;
    }


    public void createBag(CreateBagRequest dto, MultipartFile mainImage, MultipartFile[] extraImages) {
        // 1. Mapear DTO a entidad
        Bag bag = BagMapper.fromCreateRequest(dto);

        // 2. Guardar imagen principal y añadirla al Bag
        String mainImageUrl = imageStorageService.saveImage(mainImage);
        bag.setImageUrl(mainImageUrl);

        // 3. Guardar imágenes secundarias si existen
        if (extraImages != null) {
            for (MultipartFile image : extraImages) {
                String url = imageStorageService.saveImage(image);
                bag.getImages().add(new BagImage(url, bag)); // relación bidireccional
            }
        }

        // 4. Establecer el propietario actual (admin logueado)
        User currentUser = authService.getCurrentUser(); // método que tú debes tener
        bag.setOwner(currentUser);

        // 5. Estado inicial
        bag.setAvailabilityStatus(AvailabilityStatus.AVAILABLE);
        bag.setAvailable(true);

        // 6. Guardar en la base de datos
        bagRepository.save(bag);
    }
}
