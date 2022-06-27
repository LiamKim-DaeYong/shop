package com.toy.shop.repository.item;

import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import static com.toy.shop.domain.item.QItem.item;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ItemConditions {

    public static BooleanExpression containsName(String searchKeyword) {
        return StringUtils.hasLength(searchKeyword) ? item.itemNm.contains(searchKeyword) : null;
    }

    public static BooleanExpression containsCode(String searchKeyword) {
        return StringUtils.hasLength(searchKeyword) ? item.itemCd.contains(searchKeyword) : null;
    }

    public static BooleanExpression onSale() {
        return item.onSale.isTrue();
    }

    public static BooleanExpression onDisplay() {
        return item.onDisplay.isTrue();
    }

    public static BooleanExpression isNotDeleted() {
        return item.deleted.isFalse();
    }
}
