package com.sjiwon.ci;

import com.sjiwon.ci.member.domain.Member;
import com.sjiwon.ci.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InitData {
    private final MemberRepository memberRepository;

    @Transactional
    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        memberRepository.save(Member.createMember("memberA", 20));
        memberRepository.save(Member.createMember("memberB", 20));
        memberRepository.save(Member.createMember("memberC", 20));
        memberRepository.save(Member.createMember("memberD", 20));
        memberRepository.save(Member.createMember("memberE", 20));
    }
}
