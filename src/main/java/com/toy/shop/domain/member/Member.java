package com.toy.shop.domain.member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 200, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "member_nm", length = 20, nullable = false)
    private String name;

    //================== 연관 관계 메서드 ==================//

    //==================   생성 메서드   ==================//
    public static Member createMember(Long id, String email, String name) {
        Member member = new Member();
        member.id = id;
        member.password = "test";
        member.email = email;
        member.name = name;

        return member;
    }

    //==================  비즈니스 로직  ==================//

    //==================   조회 메서드   ==================//
}
