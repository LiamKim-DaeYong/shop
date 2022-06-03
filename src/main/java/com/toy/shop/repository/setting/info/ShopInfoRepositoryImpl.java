package com.toy.shop.repository.setting.info;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.toy.shop.domain.setting.ShopInfo;
import lombok.RequiredArgsConstructor;

import java.util.Map;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.toy.shop.domain.setting.QShopInfo.shopInfo;

@RequiredArgsConstructor
public class ShopInfoRepositoryImpl implements ShopInfoRepositoryQueryDsl {

    private final JPAQueryFactory queryFactory;

    @Override
    public Map<String, String> findAllAsMap() {
        return queryFactory
                .selectFrom(shopInfo)
                .transform(groupBy(shopInfo.code).as(shopInfo.value));
    }

    @Override
    public Map<String, ShopInfo> findAllAsEntityMap() {
        return queryFactory
                .selectFrom(shopInfo)
                .transform(groupBy(shopInfo.code).as(shopInfo));
    }
}
