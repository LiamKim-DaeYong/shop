package com.toy.shop.repository.member;

import com.toy.shop.dto.SearchParam;
import com.toy.shop.dto.member.MemberDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberRepositoryQueryDsl {

    Page<MemberDto> findAll(SearchParam searchParam, Pageable pageable);
}
