package com.toy.shop.service.setting;

import com.toy.shop.domain.setting.ShopInfo;
import com.toy.shop.dto.setting.ShopInfoDto;
import com.toy.shop.repository.setting.info.ShopInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShopInfoService {

    private final ShopInfoRepository shopInfoRepository;

    public Map<String, String> findAllAsMap() {
        return shopInfoRepository.findAllAsMap();
    }

    @Transactional
    public void update(List<ShopInfoDto> updateList) {
        Map<String, ShopInfo> savedMap = shopInfoRepository.findAllAsEntityMap();

        updateList.forEach(data -> {
            ShopInfo shopInfo = savedMap.get(data.getCode());
            shopInfo.updateValue(data.getValue());
        });
    }
}
