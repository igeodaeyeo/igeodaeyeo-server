package com.igdy.igeodaeyeo.domain.category.repository;

import com.igdy.igeodaeyeo.domain.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
