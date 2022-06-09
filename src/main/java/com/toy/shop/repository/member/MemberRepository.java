package com.toy.shop.repository.member;

import com.toy.shop.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryQueryDsl {
}
