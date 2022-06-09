package com.toy.shop.service.member;

import com.toy.shop.dto.SearchParam;
import com.toy.shop.dto.member.MemberDto;
import com.toy.shop.repository.member.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock
    MemberRepository memberRepository;

    @InjectMocks
    MemberService memberService;

    SearchParam searchParam;
    Pageable pageable;
    List<MemberDto> content;

    @BeforeEach
    public void init() {
        searchParam = new SearchParam();
        pageable = PageRequest.of(0, 10);
        content = Arrays.asList(
            new MemberDto(1L, "test1@test.com", "이름1"),
            new MemberDto(2L, "test2@test.com", "이름2"),
            new MemberDto(3L, "test3@test.com", "이름3"),
            new MemberDto(4L, "test4@test.com", "이름4"),
            new MemberDto(5L, "test5@test.com", "이름5"),
            new MemberDto(6L, "test6@test.com", "이름6"),
            new MemberDto(7L, "test7@test.com", "이름7"),
            new MemberDto(8L, "test8@test.com", "이름8"),
            new MemberDto(9L, "test9@test.com", "이름9"),
            new MemberDto(10L, "test10@test.com", "이름10"),
            new MemberDto(11L, "test11@test.com", "이름11"),
            new MemberDto(12L, "test12@test.com", "이름12"),
            new MemberDto(13L, "test13@test.com", "이름13"),
            new MemberDto(14L, "test14@test.com", "이름14"),
            new MemberDto(15L, "test15@test.com", "이름15"),
            new MemberDto(16L, "test16@test.com", "이름16"),
            new MemberDto(17L, "test17@test.com", "이름17"),
            new MemberDto(18L, "test18@test.com", "이름18"),
            new MemberDto(19L, "test19@test.com", "이름19"),
            new MemberDto(20L, "test20@test.com", "이름20")
        );
    }

    @Test
    void findAll() {
        when(memberRepository.findAll(searchParam, pageable))
                .thenReturn(new PageImpl<>(content.subList(0, 10), pageable, content.size()));

        Page<MemberDto> result = memberService.findAll(searchParam, pageable);
        verify(memberRepository, times(1)).findAll(searchParam, pageable);

        assertEquals(result.getContent().size(), 10);
        isEqualsMembers(result.getContent().get(2), content.get(2));
        isEqualsMembers(result.getContent().get(5), content.get(5));
        isEqualsMembers(result.getContent().get(8), content.get(8));
    }

    private void isEqualsMembers(MemberDto compare1, MemberDto compare2) {
        assertEquals(compare1.getId(), compare2.getId());
        assertEquals(compare1.getEmail(), compare2.getEmail());
        assertEquals(compare1.getMemberNm(), compare2.getMemberNm());
    }
}
