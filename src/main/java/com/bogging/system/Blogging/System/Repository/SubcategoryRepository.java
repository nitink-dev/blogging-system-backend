package com.bogging.system.Blogging.System.Repository;

import com.bogging.system.Blogging.System.Entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    List<Subcategory> findByCategoryId(Long categoryId);
    List<Subcategory> findByCategoryNameStartingWith(String categoryname);
}

