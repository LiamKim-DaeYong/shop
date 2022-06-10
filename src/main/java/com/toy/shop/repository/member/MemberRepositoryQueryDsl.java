package com.toy.shop.repository.member;

import com.toy.shop.domain.member.Member;
import com.toy.shop.dto.SearchParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberRepositoryQueryDsl {

    Page<Member> findAll(SearchParam searchParam, Pageable pageable);
}
