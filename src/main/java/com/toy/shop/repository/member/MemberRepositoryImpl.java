package com.toy.shop.repository.member;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.toy.shop.domain.member.Member;
import com.toy.shop.dto.SearchParam;
import com.toy.shop.dto.member.MemberDto;
import com.toy.shop.utils.PagingUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static com.toy.shop.domain.member.QMember.member;
import static com.toy.shop.repository.member.MemberConditions.containsEmail;
import static com.toy.shop.repository.member.MemberConditions.containsName;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryQueryDsl {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<MemberDto> findAll(SearchParam searchParam, Pageable pageable) {
        String searchKeyword = searchParam.getSearchKeyword();

        JPAQuery<Member> query = queryFactory
                .selectFrom(member)
                .where(containsEmail(searchKeyword),
                        containsName(searchKeyword));

        Page<Member> page = PagingUtil.getPage(query, pageable);
        return null;
    }
}
