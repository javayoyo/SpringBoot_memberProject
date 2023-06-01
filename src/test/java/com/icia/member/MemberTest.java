package com.icia.member;

import com.icia.member.dto.MemberDTO;
import com.icia.member.repository.MemberRepository;
import com.icia.member.service.MemberService;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class MemberTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("repository method 테스트")
    public void repositoryTest() {
        memberRepository.findByMemberEmail("aaa");
        memberRepository.findByMemberEmailAndMemberPassword("aaa","1234");
    }


    private MemberDTO newMember(int i) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberEmail("testemail" + i);
        memberDTO.setMemberPassword("testpass" + i);
        memberDTO.setMemberName("testname" + i);
        memberDTO.setMemberBirth("2000-01-01");
        memberDTO.setMemberMobile("010-1111-1111");
        return memberDTO;
    }

    @Test
    public void testData() {
        for (int i=1 ;i<=20; i++) {
            memberService.save(newMember(i));

        }
    }

    // 회원가입 테스트
    @Test
    @Transactional
    @Rollback
    @DisplayName("회원가입테스트")
//    ㄴ   import static org.assertj.core.api.Assertions.*; /해당 import 입력 필요
    public void memberSaveTest() {
        MemberDTO memberDTO = newMember(999);
        Long savedId = memberService.save(memberDTO);
        MemberDTO dto = memberService.findById(savedId);
        assertThat(memberDTO.getMemberEmail()).isEqualTo(dto.getMemberEmail());


    }


}
