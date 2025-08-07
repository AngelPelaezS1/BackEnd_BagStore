package com.tienda.tiendabolsos.mapper;


import com.tienda.tiendabolsos.dto.BagDetailDto;
import com.tienda.tiendabolsos.dto.BagSummaryDto;
import com.tienda.tiendabolsos.dto.CreateBagRequest;
import com.tienda.tiendabolsos.enums.Category;
import com.tienda.tiendabolsos.enums.Condition;
import com.tienda.tiendabolsos.model.Bag;
import com.tienda.tiendabolsos.enums.AvailabilityStatus;
import com.tienda.tiendabolsos.model.BagImage;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class BagMapper {

    public static BagSummaryDto toSummaryDto(Bag bag) {
        boolean showSoldBadge = bag.getAvailabilityStatus() == AvailabilityStatus.SOLD
                && bag.getSoldAt() != null
                && bag.getSoldAt().isAfter(LocalDateTime.now().minusDays(5));

        return new BagSummaryDto(
                bag.getId(),
                bag.getBrand(),
                bag.getModel(),
                bag.getImageUrl(),
                bag.getListedPrice(),
                bag.getDiscountedPrice(),
                showSoldBadge
        );
    }

    public static BagDetailDto toDetailDto(Bag bag) {
        List<String> extraImages = bag.getImages().stream()
                .map(BagImage::getImageUrl)
                .collect(Collectors.toList());

        return new BagDetailDto(
                bag.getId(),
                bag.getBrand(),
                bag.getModel(),
                bag.getColor(),
                bag.getMaterial(),
                bag.getWidthCm(),
                bag.getHeightCm(),

                bag.getCondition() != null ? bag.getCondition().name() : null,
                bag.getCategory() != null ? bag.getCategory().name() : null,
                bag.getHasDustbag(),

                bag.getListedPrice(),
                bag.getDiscountedPrice(),
                bag.getOfficialPrice(),

                bag.getDescription(),
                bag.getImageUrl(),
                extraImages,

                bag.getAvailabilityStatus() != null ? bag.getAvailabilityStatus().name() : null
        );
    }

    public static Bag fromCreateRequest(CreateBagRequest dto) {
        Bag bag = new Bag();

        bag.setBrand(dto.getBrand());
        bag.setModel(dto.getModel());
        bag.setColor(dto.getColor());
        bag.setMaterial(dto.getMaterial());
        bag.setWidthCm(dto.getWidthCm());
        bag.setHeightCm(dto.getHeightCm());

        // Enums desde strings
        bag.setCondition(
                dto.getCondition() != null ? Condition.valueOf(dto.getCondition()) : null
        );
        bag.setCategory(
                dto.getCategory() != null ? Category.valueOf(dto.getCategory()) : null
        );

        bag.setHasDustbag(dto.getHasDustbag());
        bag.setListedPrice(dto.getListedPrice());
        bag.setOfficialPrice(dto.getOfficialPrice());
        bag.setDescription(dto.getDescription());

        // Otros campos como imageUrl, images y owner los añadirás en el servicio

        return bag;
    }

}