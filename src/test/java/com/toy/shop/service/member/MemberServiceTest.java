package com.toy.shop.service.member;

import com.toy.shop.domain.Address;
import com.toy.shop.domain.member.Grade;
import com.toy.shop.domain.member.Member;
import com.toy.shop.dto.member.MemberDto;
import com.toy.shop.dto.member.MemberSave;
import com.toy.shop.dto.member.MemberUpdate;
import com.toy.shop.repository.member.MemberRepository;
import com.toy.shop.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock
    MemberRepository memberRepository;

    @InjectMocks
    MemberService memberService;

    PasswordEncoder passwordEncoder;

    Member member;

    @BeforeEach
    void init() {
        passwordEncoder = new BCryptPasswordEncoder();

        member = Member.newMember()
                .email("test@test.com")
                .password("1234")
                .name("user")
                .phoneNum("010-1234-5678")
                .address(new Address("12345",
                        "대구 달서구 상인동",
                        "1층"))
                .grade(Grade.BASIC)
                .passwordEncoder(passwordEncoder)
                .build();
    }

    @Test
    public void passwordEncodingTest() {
        //given
        MemberSave dto = new MemberSave();
        dto.setEmail("test@test.com");
        dto.setPassword("12345");
        dto.setName("user");
        dto.setPhoneNum("010-1234-5678");
        dto.setGrade("BASIC");

        //when
        Member member = dto.newMember(passwordEncoder);

        //then
        assertTrue(passwordEncoder.matches(dto.getPassword(), member.getPassword()));
    }

    @Test
    public void findById() {
        //given
        given(memberRepository.findById(anyLong())).willReturn(Optional.ofNullable(member));

        //when
        MemberDto findMember = memberService.findById(anyLong());

        //then
        MemberDto memberDto = new MemberDto(member);
        assertThat(memberDto).usingRecursiveComparison()
                .isEqualTo(findMember);
    }

    @Test
    public void update() {
        //given
        MemberUpdate dto = new MemberUpdate();
        dto.setName("gold user");
        dto.setPhoneNum("010-9876-5432");
        dto.setZipCode("98765");
        dto.setCity("서울 송파구");
        dto.setStreet("2층");
        dto.setGrade("GOLD");

        given(memberRepository.findById(1L)).willReturn(Optional.ofNullable(member));

        //when
        memberService.update(1L, dto);

        //then
        assertEquals(member.getName(), dto.getName());
        assertEquals(member.getPhoneNum(), dto.getPhoneNum());
        assertEquals(member.getAddress().getZipCode(), dto.getZipCode());
        assertEquals(member.getAddress().getCity(), dto.getCity());
        assertEquals(member.getAddress().getStreet(), dto.getStreet());
        assertEquals(member.getGrade().toString(), dto.getGrade());
    }

    @Test
    public void delete() {
        //given
        given(memberRepository.findById(1L)).willReturn(Optional.ofNullable(member));

        //when
        memberService.delete(1L);

        //then
        assertTrue(member.isDeleted());
    }
}
