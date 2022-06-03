package com.toy.shop.repository.setting.info;

import com.toy.shop.domain.setting.ShopInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopInfoRepository extends JpaRepository<ShopInfo, Long>, ShopInfoRepositoryQueryDsl {
}
