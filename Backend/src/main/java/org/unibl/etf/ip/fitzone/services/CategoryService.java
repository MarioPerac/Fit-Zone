package org.unibl.etf.ip.fitzone.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.fitzone.base.CrudJpaService;
import org.unibl.etf.ip.fitzone.models.entites.CategoryEntity;
import org.unibl.etf.ip.fitzone.repositories.CategoryRepository;

@Service
public class CategoryService extends CrudJpaService<CategoryEntity, Integer> {

    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper){
        super(categoryRepository, CategoryEntity.class, modelMapper);
    }
}
