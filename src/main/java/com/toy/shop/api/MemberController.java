package com.toy.shop.api;

import com.toy.shop.dto.SearchParam;
import com.toy.shop.dto.member.MemberDto;
import com.toy.shop.dto.member.MemberSave;
import com.toy.shop.dto.member.MemberUpdate;
import com.toy.shop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public ResponseEntity findAll(@RequestBody SearchParam searchParam, Pageable pageable) {
        Page<MemberDto> members = memberService.findAll(searchParam, pageable);
        return ResponseEntity.ok(members);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        MemberDto member = memberService.findById(id);
        return ResponseEntity.ok(member);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody MemberSave memberSave) {
        Long savedId = memberService.save(memberSave);
        return ResponseEntity.ok(savedId);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, MemberUpdate memberUpdate) {
        memberService.update(id, memberUpdate);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        memberService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
