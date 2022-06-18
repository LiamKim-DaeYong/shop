package com.toy.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import static com.toy.shop.code.DBLength.ADDRESS_LENGTH;
import static com.toy.shop.code.DBLength.ZIPCODE_LENGTH;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Column(length = ZIPCODE_LENGTH, nullable = false)
    @Comment("우편번호")
    private String zipCode;

    @Column(length = ADDRESS_LENGTH, nullable = false)
    @Comment("주소")
    private String city;

    @Column(length = ADDRESS_LENGTH, nullable = false)
    @Comment("상세주소")
    private String street;
}
