package com.twoCube.members.repository;

import com.twoCube.gifts.domain.Gift;
import com.twoCube.members.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MemberRepository extends JpaRepository<Member, UUID> {
    Optional<Member> findBySocialId(String socialId);
}
