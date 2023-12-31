package com.example.demo.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {
    private Long userNo;
    private String userName;
    private String userId;
    private String userPwd;
    private String userEmail;
    private String userPhone;
    private String userAddr;
    private String userGender;
    private LocalDateTime lastLoginDt;
    private LocalDateTime updBeforePwdDt;
    private String updBeforePwd;
    private String useYn;
    private String lockYn;
    private LocalDateTime regDt;
    private LocalDateTime updDt;
}
