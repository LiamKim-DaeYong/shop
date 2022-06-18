package com.toy.shop.dto.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberSave {

    private String email;

    private String password;

    private String name;

    private String phoneNum;

    private String zipCode;

    private String city;

    private String street;

    private String grade;

    private boolean deleted = false;
}
