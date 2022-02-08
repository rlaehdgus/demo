package com.example.demo.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {
    private Long m_seq;
    private String name;
    private String id;
    private String password;
    private String address;
    private String gender;
    private String phone;
    private String auth_type;
    private String del_yn;
    private LocalDateTime cre_dt;
    private LocalDateTime upd_dt;
    private LocalDateTime del_dt;
}
