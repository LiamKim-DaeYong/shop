package com.toy.shop.repository.item.category;

import com.toy.shop.domain.item.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, CategoryRepositoryQueryDsl {
}
