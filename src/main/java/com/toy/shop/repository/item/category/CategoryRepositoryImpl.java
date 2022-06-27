package com.toy.shop.repository.item.category;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepositoryQueryDsl {

    private final JPAQueryFactory queryFactory;
}
