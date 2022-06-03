package com.toy.shop.repository.setting.info;

import com.toy.shop.domain.setting.ShopInfo;

import java.util.Map;

public interface ShopInfoRepositoryQueryDsl {

    Map<String, String> findAllAsMap();

    Map<String, ShopInfo> findAllAsEntityMap();
}
