package com.bogging.system.Blogging.System.Services;

import com.bogging.system.Blogging.System.Entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    public Category createCategory(Category category);

    public List<Category> getAllCategories();

    public Category getCategoryById(Long id) ;

    public Category updateCategory(Long id, Category categoryDetails) ;

    public void deleteCategory(Long id) ;
}

