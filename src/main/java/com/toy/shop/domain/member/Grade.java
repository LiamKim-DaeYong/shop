package com.toy.shop.domain.member;

import lombok.Getter;

@Getter
public enum Grade {
    BASIC("일반회원"), SILVER("실버회원"), GOLD("골드회원");

    private final String desc;

    Grade(String desc) {
        this.desc = desc;
    }
}
