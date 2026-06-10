package com.store.videogames.modules.sale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.store.videogames.modules.sale.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, String> {
}