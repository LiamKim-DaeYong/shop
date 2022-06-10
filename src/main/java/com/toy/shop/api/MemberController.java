package com.toy.shop.api;

import com.toy.shop.domain.member.Member;
import com.toy.shop.dto.SearchParam;
import com.toy.shop.dto.member.MemberDto;
import com.toy.shop.dto.member.MemberRequest;
import com.toy.shop.service.member.MemberService;
import com.toy.shop.utils.CovertUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public Page<MemberDto> findAll(@RequestBody SearchParam searchParam, Pageable pageable) {
        Page<Member> members = memberService.findAll(searchParam, pageable);
        return CovertUtils.convertToPage(members, MemberDto.class);
    }

    @PostMapping("/add")
    public Long save(@RequestBody MemberRequest memberRequest) {
        Member member = CovertUtils.convert(memberRequest, Member.class);
        return memberService.save(member);
    }
}
