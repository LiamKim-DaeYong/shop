package com.toy.shop.service.member;

import com.toy.shop.domain.Address;
import com.toy.shop.domain.member.Grade;
import com.toy.shop.domain.member.Member;
import com.toy.shop.dto.SearchParam;
import com.toy.shop.dto.member.MemberDto;
import com.toy.shop.dto.member.MemberSave;
import com.toy.shop.dto.member.MemberUpdate;
import com.toy.shop.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Page<MemberDto> findAll(SearchParam searchParam, Pageable pageable) {
        Page<Member> members = memberRepository.findAll(searchParam, pageable);

        return new PageImpl<>(members.stream().map(MemberDto::new)
                .collect(Collectors.toList()), pageable, members.getTotalElements());
    }

    public Member findById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public Long save(MemberSave dto) {
        Member member = dto.newMember(passwordEncoder);
        memberRepository.save(member);

        return member.getId();
    }

    @Transactional
    public void update(Long id, MemberUpdate dto) {
        Member member = findById(id);

        Address address = new Address(dto.getZipCode(),
                dto.getCity(), dto.getStreet());

        Grade grade = Grade.valueOf(dto.getGrade().toUpperCase());

        member.update(dto.getName(), dto.getPhoneNum(), address, grade);
    }
}
