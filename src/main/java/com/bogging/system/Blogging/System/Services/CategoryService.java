package com.bogging.system.Blogging.System.Services;

import com.bogging.system.Blogging.System.Entity.Category;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CategoryService {

    public Category create(Category category);

    public List<Category> getAll();

    public Category getById(Long id) ;

    public Category update(Long id, Category categoryDetails) ;

    public void delete(Long id) ;
}

