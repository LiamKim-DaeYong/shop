package com.toy.shop.api;

import com.toy.shop.dto.SearchParam;
import com.toy.shop.dto.member.MemberDto;
import com.toy.shop.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public Page<MemberDto> findAll(@RequestBody SearchParam searchParam, Pageable pageable) {
        return memberService.findAll(searchParam, pageable);
    }
}