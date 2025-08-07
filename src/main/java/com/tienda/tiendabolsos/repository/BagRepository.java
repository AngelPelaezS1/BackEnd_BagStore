package com.tienda.tiendabolsos.repository;

import com.tienda.tiendabolsos.model.Bag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BagRepository extends JpaRepository<Bag, Long> {

}
