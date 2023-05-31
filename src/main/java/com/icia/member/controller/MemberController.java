package com.icia.member.controller;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor

@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    @GetMapping("/save")
    public String saveForm() {
        return "memberPages/memberSave";

    }

    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO){
        memberService.save(memberDTO);
        return "memberPages/memberLogin";
    }

    @GetMapping("/")
    public String findAll(Model model) {
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList",memberDTOList);
        return "memberPages/memberList";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "memberPages/memberLogin";

    }

    @PostMapping("/login")
    public String login() {
        return "memberPages/memberMain";
    }
    
}