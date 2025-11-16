package com.example.sweetShop.repositories;

import com.example.sweetShop.entities.Sweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SweetRepository extends JpaRepository<Sweet, Long> {
    boolean existsByName(String name);

    @Query("select s from Sweet s where " +
            "(:name is null or lower(s.name) like lower(concat('%', :name, '%'))) and " +
            "(:category is null or lower(s.category) = lower(:category)) and " +
            "(:minPrice is null or s.price >= :minPrice) and " +
            "(:maxPrice is null or s.price <= :maxPrice)")
    List<Sweet> search(@Param("name") String name,
                       @Param("category") String category,
                       @Param("minPrice") Double minPrice,
                       @Param("maxPrice") Double maxPrice);
}

