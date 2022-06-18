package com.toy.shop.service.member;

import com.toy.shop.domain.member.Member;
import com.toy.shop.dto.SearchParam;
import com.toy.shop.dto.member.MemberUpdate;
import com.toy.shop.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public Page<Member> findAll(SearchParam searchParam, Pageable pageable) {
        return memberRepository.findAll(searchParam, pageable);
    }

    public Member findById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public Long save(Member member) {
        memberRepository.save(member);
        return member.getId();
    }

    @Transactional
    public void update(Long id, MemberUpdate memberUpdate) {
        Member member = findById(id);
        member.update(memberUpdate);
    }
}
