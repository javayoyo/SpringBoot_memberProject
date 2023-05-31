package com.icia.member.repository;

import com.icia.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 인터페이스 > '추상 메서드' 만 정의할 수 있음

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    /*
        select => findBy
        select * from member_table where member_email=?
     */

    Optional<MemberEntity> findByMemberEmail(String memberEmail);

    //   select * from member_table where member_email=? and member_password=?
    Optional<MemberEntity> findByMemberEmailAndMemberPassword(String memberEmail, String memberPassword);
}
