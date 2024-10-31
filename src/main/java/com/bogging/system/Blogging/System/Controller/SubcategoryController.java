package com.bogging.system.Blogging.System.Controller;

import com.bogging.system.Blogging.System.Entity.Subcategory;
import com.bogging.system.Blogging.System.Services.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subcategories")
public class SubcategoryController {

    @Autowired
    private SubcategoryService subcategoryService;

    @PostMapping("/category/{categoryId}")
    public Subcategory createSubcategory(@PathVariable Long categoryId, @RequestBody Subcategory subcategory) {
        return subcategoryService.createSubcategory(categoryId, subcategory);
    }

    @GetMapping
    public List<Subcategory> getAllSubcategories() {
        return subcategoryService.getAllSubcategories();
    }

    @GetMapping("/{id}")
    public Subcategory getSubcategoryById(@PathVariable Long id) {
        return subcategoryService.getSubcategoryById(id);
    }

    /*@PutMapping("/{id}")
    public Subcategory updateSubcategory(@PathVariable Long id, @RequestBody Subcategory subcategory) {
        return subcategoryService.updateSubcategory(id, subcategory);
    }*/

    @DeleteMapping("/{id}")
    public void deleteSubcategory(@PathVariable Long id) {
        subcategoryService.deleteSubcategory(id);
    }
}

