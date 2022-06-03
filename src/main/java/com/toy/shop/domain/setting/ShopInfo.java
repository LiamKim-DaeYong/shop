package com.toy.shop.domain.setting;

import com.toy.shop.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShopInfo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "info_id")
    private Long id;

    @Column(name = "info_code", length = 100, unique = true, nullable = false)
    private String code;

    @Column(name = "info_value")
    private String value;

    @Column(name = "info_desc")
    private String desc;

    //================== 연관 관계 메서드 ==================//

    //==================   생성 메서드   ==================//
    public static ShopInfo createShopInfo(String code, String value) {
        ShopInfo shopInfo = new ShopInfo();
        shopInfo.code = code;
        shopInfo.value = value;

        return shopInfo;
    }

    //==================  비즈니스 로직  ==================//
    public void updateValue(String value) {
        this.value = value;
    }

    //==================   조회 메서드   ==================//
}
