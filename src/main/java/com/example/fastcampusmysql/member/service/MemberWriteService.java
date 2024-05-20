package com.example.fastcampusmysql.member.service;

import com.example.fastcampusmysql.member.dto.RegisterMemberCommand;
import com.example.fastcampusmysql.member.entity.Member;
import com.example.fastcampusmysql.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberWriteService {

    private final MemberRepository memberRepository;

    public Member create(RegisterMemberCommand command) {
        /*
            목표 - 회원정보 등록(이메일, 닉네임, 생년월일)
         */
        Member member = Member.builder()
                .nickname(command.nickname())
                .email(command.email())
                .birthDay(command.birthDate())
                .build();

        return memberRepository.save(member);
    }
}
