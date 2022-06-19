package com.toy.shop.dto.member;

import com.toy.shop.domain.Address;
import com.toy.shop.domain.member.Grade;
import com.toy.shop.domain.member.Member;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    public Member newMember(PasswordEncoder passwordEncoder) {
        return Member.newMember()
                .email(email)
                .password(passwordEncoder.encode(password))
                .name(name)
                .phoneNum(phoneNum)
                .address(new Address(zipCode, city, street))
                .grade(Grade.valueOf(grade.toUpperCase()))
                .build();
    }
}
