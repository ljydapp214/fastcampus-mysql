package com.example.fastcampusmysql.member.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class Member {

    private final Long id;

    private String nickname;

    private final String email;

    private final LocalDate birthDay;

    private final LocalDateTime createdAt;

    private static final Long NAME_MAX_LENGTH = 10L;

    @Builder
    public Member(Long id, String nickname, String email, LocalDate birthDay, LocalDateTime createdAt) {
        validateNickName(nickname);
        this.id = id;
        this.nickname = Objects.requireNonNull(nickname);
        this.email = Objects.requireNonNull(email);
        this.birthDay = Objects.requireNonNull(birthDay);
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
    }

    void validateNickName(String nickname) {
        if (nickname.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("닉네임은 10자 이하로 입력해주세요.");
        }
    }
}
