package com.twoCube.members.repository;

import com.twoCube.couple.domain.Couple;
import com.twoCube.members.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MemberRepository extends JpaRepository<Member, UUID> {
    Optional<Member> findBySocialId(String socialId);

    Optional<Member> findBySocialIdAndDeleted(String socialId, boolean deleted);
    long countByCouple(Couple couple);
    List<Member> findByCouple(Couple couple);
}
