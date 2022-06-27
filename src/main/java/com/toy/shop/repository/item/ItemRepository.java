package com.toy.shop.repository.item;

import com.toy.shop.domain.item.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Category, Long>, ItemRepositoryQueryDsl {
}
