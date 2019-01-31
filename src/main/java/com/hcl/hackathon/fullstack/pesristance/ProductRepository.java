package com.hcl.hackathon.fullstack.pesristance;

import com.hcl.hackathon.fullstack.pesristance.entities.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select distinct pe from Product pe " +
        "inner join pe.categories cat " +
        "where (LOWER(pe.name) LIKE LOWER('%' || :searchText || '%')) " +
        "OR (LOWER(pe.description) LIKE LOWER('%' || :searchText || '%')) " +
        "OR (LOWER(cat.name) LIKE LOWER('%' || :searchText || '%'))  ")
    List<Product> findByGivenSearch(String searchText);
}
