package com.bogging.system.Blogging.System.Services;

import com.bogging.system.Blogging.System.Entity.Category;
import com.bogging.system.Blogging.System.ExceptionHandling.ResourceNotFoundException;
import com.bogging.system.Blogging.System.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category getById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found "+ id));
    }

    public Category update(Long id, Category categoryDetails) {
        Category category = getById(id);
        category.setName(categoryDetails.getName());
        return categoryRepository.save(category);
    }

    public void delete(Long id) {
        Category category = getById(id);
        categoryRepository.delete(category);
    }

}

