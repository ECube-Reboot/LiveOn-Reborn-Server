package com.twoCube.members.repository;

import com.twoCube.members.domain.WithdrawlMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WithdrawlMemberRepository extends
        JpaRepository<WithdrawlMember, Long> {
}
