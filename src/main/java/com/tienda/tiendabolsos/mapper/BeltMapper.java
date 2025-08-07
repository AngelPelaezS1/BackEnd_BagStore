package com.tienda.tiendabolsos.mapper;

import com.tienda.tiendabolsos.dto.BeltDetailDto;
import com.tienda.tiendabolsos.dto.BeltSummaryDto;
import com.tienda.tiendabolsos.dto.CreateBeltRequest;
import com.tienda.tiendabolsos.enums.AvailabilityStatus;
import com.tienda.tiendabolsos.enums.Condition;
import com.tienda.tiendabolsos.model.Belt;
import com.tienda.tiendabolsos.model.BeltImage;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class BeltMapper {

    public static BeltSummaryDto toSummaryDto(Belt belt) {
        boolean showSoldBadge = belt.getAvailabilityStatus() == AvailabilityStatus.SOLD
                && belt.getSoldAt() != null
                && belt.getSoldAt().isAfter(LocalDateTime.now().minusDays(5));

        return new BeltSummaryDto(
                belt.getId(),
                belt.getBrand(),
                belt.getModel(),
                belt.getImageUrl(),
                belt.getListedPrice(),
                belt.getDiscountedPrice(),
                showSoldBadge
        );
    }

    public static BeltDetailDto toDetailDto(Belt belt) {
        List<String> extraImages = belt.getImages().stream()
                .map(BeltImage::getImageUrl)
                .collect(Collectors.toList());

        return new BeltDetailDto(
                belt.getId(),
                belt.getBrand(),
                belt.getModel(),
                belt.getColor(),
                belt.getMaterial(),
                belt.getLengthCm(),
                belt.getWidthCm(),

                belt.getCondition() != null ? belt.getCondition().name() : null,
                belt.getHasDustbag(),
                belt.getHasBox(),

                belt.getListedPrice(),
                belt.getDiscountedPrice(),
                belt.getOfficialPrice(),

                belt.getDescription(),
                belt.getImageUrl(),
                extraImages,

                belt.getAvailabilityStatus() != null ? belt.getAvailabilityStatus().name() : null
        );
    }

    public static Belt fromCreateRequest(CreateBeltRequest dto) {
        Belt belt = new Belt();

        belt.setBrand(dto.getBrand());
        belt.setModel(dto.getModel());
        belt.setColor(dto.getColor());
        belt.setMaterial(dto.getMaterial());
        belt.setLengthCm(dto.getLengthCm());
        belt.setWidthCm(dto.getWidthCm());

        // Enums desde strings
        belt.setCondition(
                dto.getCondition() != null ? Condition.valueOf(dto.getCondition()) : null
        );

        belt.setHasDustbag(dto.getHasDustbag());
        belt.setHasBox(dto.getHasBox());
        belt.setListedPrice(dto.getListedPrice());
        belt.setOfficialPrice(dto.getOfficialPrice());
        belt.setDescription(dto.getDescription());

        return belt;
    }
}
