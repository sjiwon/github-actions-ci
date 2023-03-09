package com.sjiwon.ci.member.service;

import com.sjiwon.ci.member.domain.MemberRepository;
import com.sjiwon.ci.member.service.dto.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public List<MemberResponse> findAll() {
        return memberRepository.findAll()
                .stream()
                .map(MemberResponse::new)
                .toList();
    }

    public MemberResponse findById(Long memberId) {
        return new MemberResponse(
                memberRepository.findById(memberId)
                        .orElseThrow(RuntimeException::new)
        );
    }
}
