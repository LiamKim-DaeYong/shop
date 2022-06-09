package com.toy.shop.repository.member;

import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import static com.toy.shop.domain.member.QMember.member;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MemberConditions {

    public static BooleanExpression containsEmail(String searchKeyword) {
        return StringUtils.hasLength(searchKeyword) ? member.email.contains(searchKeyword) : null;
    }

    public static BooleanExpression containsName(String searchKeyword) {
        return StringUtils.hasLength(searchKeyword) ? member.name.contains(searchKeyword) : null;
    }
}
