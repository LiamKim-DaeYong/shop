package com.toy.shop.domain.member;

import com.toy.shop.domain.Address;
import com.toy.shop.domain.BaseEntity;
import com.toy.shop.dto.member.MemberUpdate;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import static com.toy.shop.code.DBLength.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(length = EMAIL_LENGTH, nullable = false)
    @Comment("이메일")
    private String email;

    @Column(length = PASSWORD_LENGTH, nullable = false)
    @Comment("패스워드")
    private String password;

    @Column(name = "member_nm", length = NAME_LENGTH, nullable = false)
    @Comment("이름")
    private String name;

    @Column(length = PHONE_LENGTH, nullable = false)
    @Comment("휴대폰 번호")
    private String phoneNum;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    @Column(length = CODE_LENGTH, nullable = false)
    @Comment("등급")
    private Grade grade;

    @Type(type = "yes_no")
    @Column(length = 1, nullable = false)
    @Comment("삭제 여부")
    private boolean deleted;

    //==================  비즈니스 로직  ==================//
    public void update(MemberUpdate memberUpdate) {
        this.name = memberUpdate.getName();
        this.phoneNum = memberUpdate.getPhoneNum();
        this.address = new Address(memberUpdate.getZipCode(),
                            memberUpdate.getCity(),
                            memberUpdate.getStreet());
        this.grade = Grade.valueOf(memberUpdate.getGrade());
    }
}
