package org.ypecommercesample.enocabackendchallenge.repository;

import org.ypecommercesample.enocabackendchallenge.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Stok miktarı belirtilen değerden az olan ürünleri bulur
    List<Product> findByStockQuantityLessThan(int quantity);

    // Aktif ürünleri listeler
    List<Product> findByIsActiveTrue();
}
