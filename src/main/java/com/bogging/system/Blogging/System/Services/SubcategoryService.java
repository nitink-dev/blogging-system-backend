package com.bogging.system.Blogging.System.Services;

import com.bogging.system.Blogging.System.Entity.Category;
import com.bogging.system.Blogging.System.Entity.Subcategory;
import com.bogging.system.Blogging.System.ExceptionHandling.ResourceNotFoundException;
import com.bogging.system.Blogging.System.Repository.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubcategoryService {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Autowired
    private CategoryService categoryService;

    public Subcategory createSubcategory(Long categoryId, Subcategory subcategory) {
        Category category = categoryService.getById(categoryId);
        subcategory.setCategory(category);
        return subcategoryRepository.save(subcategory);
    }

    public List<Subcategory> getAllSubcategories() {
        return subcategoryRepository.findAll();
    }

    public Subcategory getSubcategoryById(Long id) {
        return subcategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subcategory not found"));
    }

    public Subcategory updateSubcategory(Long id, Subcategory subcategoryDetails) {
        Subcategory subcategory = getSubcategoryById(id);
        subcategory.setName(subcategoryDetails.getName());
        return subcategoryRepository.save(subcategory);
    }

    public void deleteSubcategory(Long id) {
        Subcategory subcategory = getSubcategoryById(id);
        subcategoryRepository.delete(subcategory);
    }

}

