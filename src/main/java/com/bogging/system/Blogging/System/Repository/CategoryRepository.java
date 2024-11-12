package com.bogging.system.Blogging.System.Repository;

import com.bogging.system.Blogging.System.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

