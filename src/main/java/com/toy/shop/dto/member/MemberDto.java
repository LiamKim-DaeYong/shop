package com.toy.shop.dto.member;

import com.toy.shop.domain.member.Grade;
import com.toy.shop.domain.member.Member;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberDto {

    private Long id;

    private String email;

    private String name;

    private String phoneNum;

    private String zipCode;

    private String city;

    private String street;

    private Grade grade;

    public MemberDto(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.name = member.getName();
        this.phoneNum = member.getPhoneNum();
        this.zipCode = member.getAddress().getZipCode();
        this.city = member.getAddress().getCity();
        this.street = member.getAddress().getStreet();
        this.grade = member.getGrade();
    }
}
