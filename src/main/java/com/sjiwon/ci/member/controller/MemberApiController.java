package com.sjiwon.ci.member.controller;

import com.sjiwon.ci.member.service.MemberService;
import com.sjiwon.ci.member.service.dto.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<List<MemberResponse>> findMembers() {
        return ResponseEntity.ok(memberService.findAll());
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponse> findMember(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.findById(memberId));
    }
}
