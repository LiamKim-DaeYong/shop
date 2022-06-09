package com.toy.shop.service.setting;

import com.toy.shop.domain.setting.ShopInfo;
import com.toy.shop.dto.setting.ShopInfoDto;
import com.toy.shop.repository.setting.info.ShopInfoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.toy.shop.domain.setting.ShopInfo.createShopInfo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ShopInfoServiceTest {

    @Mock
    ShopInfoRepository shopInfoRepository;

    @InjectMocks
    ShopInfoService shopInfoService;

    @Test
    void findAllAsMap() {
        when(shopInfoRepository.findAllAsMap()).thenReturn(new HashMap<String, String>() {
            {
                put("SHOP_NM", "Shop");
                put("CMP_NM", "Toy Company");
                put("CEO", "Liam");
                put("EMAIL", "liamkim1018@gmail.com");
                put("TEL", "01012345678");
            }
        });

        Map<String, String> result = shopInfoService.findAllAsMap();
        verify(shopInfoRepository, times(1)).findAllAsMap();
        assertEquals(result.size(), 5);
        assertEquals(result.get("SHOP_NM"), "Shop");
        assertEquals(result.get("TEL"), "01012345678");
    }

    @Test
    void update() {
        Map<String, ShopInfo> savedData = new HashMap<>() {
            {
                put("SHOP_NM", createShopInfo("SHOP_NM", "Shop"));
                put("CMP_NM", createShopInfo("CMP_NM", "Toy Company"));
                put("CEO", createShopInfo("CEO", "Liam"));
                put("EMAIL", createShopInfo("EMAIL", "liamkim1018@gmail.com"));
                put("TEL", createShopInfo("TEL", "01012345678"));
            }
        };

        when(shopInfoRepository.findAllAsEntityMap()).thenReturn(savedData);

        List<ShopInfoDto> updateList = Arrays.asList(
            new ShopInfoDto("SHOP_NM", "Shop Update"),
            new ShopInfoDto("CMP_NM", "Update Company"),
            new ShopInfoDto("CEO", "Toy"),
            new ShopInfoDto("EMAIL", "update@gmail.com"),
            new ShopInfoDto("TEL", "87654321010")
        );

        shopInfoService.update(updateList);
        verify(shopInfoRepository, times(1)).findAllAsEntityMap();
        assertEquals(savedData.get("SHOP_NM").getValue(), "Shop Update");
        assertEquals(savedData.get("CMP_NM").getValue(), "Update Company");
        assertEquals(savedData.get("CEO").getValue(), "Toy");
        assertEquals(savedData.get("EMAIL").getValue(), "update@gmail.com");
        assertEquals(savedData.get("TEL").getValue(), "87654321010");
    }
}
