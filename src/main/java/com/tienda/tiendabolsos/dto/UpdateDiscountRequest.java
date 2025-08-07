package com.tienda.tiendabolsos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDiscountRequest {
    private BigDecimal discountedPrice;
}

/*@PreAuthorize("hasRole('ADMIN')")
@PatchMapping("/api/bags/{id}/discount")
public ResponseEntity<?> applyDiscount(@PathVariable Long id, @RequestBody UpdateDiscountRequest request) {
    bagService.updateDiscount(id, request.getDiscountedPrice());
    return ResponseEntity.ok().build();
}

public void updateDiscount(Long bagId, BigDecimal discountedPrice) {
    Bag bag = bagRepository.findById(bagId)
        .orElseThrow(() -> new ResourceNotFoundException("Bolso no encontrado"));

    if (discountedPrice == null || discountedPrice.compareTo(bag.getListedPrice()) >= 0) {
        throw new IllegalArgumentException("El precio rebajado debe ser menor que el listado.");
    }

    bag.setDiscountedPrice(discountedPrice);
    bagRepository.save(bag);
}
 */

