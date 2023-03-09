package com.sjiwon.ci.member.service.dto.response;

import com.sjiwon.ci.member.domain.Member;

public record MemberResponse(Long id, String name, int age) {
    public MemberResponse(Member member) {
        this(member.getId(), member.getName(), member.getAge());
    }
}
