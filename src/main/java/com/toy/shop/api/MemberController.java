package com.toy.shop.api;

import com.toy.shop.domain.member.Member;
import com.toy.shop.dto.SearchParam;
import com.toy.shop.dto.member.MemberDto;
import com.toy.shop.dto.member.MemberSave;
import com.toy.shop.dto.member.MemberUpdate;
import com.toy.shop.service.member.MemberService;
import com.toy.shop.utils.ConvertUtils;
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
        return memberService.findAll(searchParam, pageable);
    }

    @PostMapping("/add")
    public Long save(@RequestBody MemberSave memberSave) {
        return memberService.save(memberSave);
    }

    @PutMapping("/{id}/update")
    public Long update(@PathVariable Long id, MemberUpdate memberUpdate) {
        memberService.update(id, memberUpdate);
        return id;
    }
}
