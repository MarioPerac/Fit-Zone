package org.unibl.etf.ip.fitzone.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.fitzone.base.CrudController;
import org.unibl.etf.ip.fitzone.models.dto.Category;
import org.unibl.etf.ip.fitzone.models.requests.CategoryRequest;
import org.unibl.etf.ip.fitzone.services.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController extends CrudController<Integer, CategoryRequest, Category> {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        super(categoryService, Category.class);
        this.categoryService = categoryService;
    }
}
