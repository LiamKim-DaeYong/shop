package com.toy.shop.repository.item;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.toy.shop.domain.item.Item;
import com.toy.shop.dto.SearchParam;
import com.toy.shop.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static com.toy.shop.domain.item.QItem.item;
import static com.toy.shop.repository.item.ItemConditions.*;

@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepositoryQueryDsl {

    private final JPAQueryFactory queryFactory;

    Page<Item> findAll(SearchParam searchParam, Pageable pageable) {
        String searchKeyword = searchParam.getSearchKeyword();

        JPAQuery<Item> query = queryFactory
                .selectFrom(item)
                .where(containsCode(searchKeyword),
                        containsName(searchKeyword),
                        isNotDeleted());

        return PagingUtils.getPage(query, pageable);
    }
}
