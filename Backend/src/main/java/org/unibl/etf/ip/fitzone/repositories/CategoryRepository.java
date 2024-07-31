package org.unibl.etf.ip.fitzone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ip.fitzone.models.entites.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}
