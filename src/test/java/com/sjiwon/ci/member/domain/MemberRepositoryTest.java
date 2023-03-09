package com.sjiwon.ci.member.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void setUp() {
        memberRepository.save(Member.createMember("memberA", 20));
        memberRepository.save(Member.createMember("memberB", 20));
        memberRepository.save(Member.createMember("memberC", 20));
    }

    @AfterEach
    void after() {
        memberRepository.deleteAll();
    }

    @Test
    @DisplayName("전체 멤버를 조회한다")
    void findAllMember() {
        // when
        List<Member> members = memberRepository.findAll();

        // then
        assertAll(
                () -> assertThat(members.size()).isEqualTo(3),
                () -> assertThat(members)
                        .extracting("name")
                        .contains("memberA", "memberB", "memberC")
        );
    }

    @Test
    @DisplayName("특정 멤버를 조회한다 (고의 실패 테스트)")
    void findSpecificMember() {
        // when
        Member member = memberRepository.findByName("memberA").orElseThrow(RuntimeException::new);

        // then
        assertThat(member.getName()).isEqualTo("memberA");
    }
}