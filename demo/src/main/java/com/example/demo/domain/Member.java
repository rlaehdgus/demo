package com.example.demo.domain;

import com.example.demo.domain.entity.MemberEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Member {
    @Column(name = "mSeq")
    private Long mSeq;
    private String name;
    private String id;
    private String password;
    private String address;
    private String gender;
    private String phone;
    private Date cre_dt;
    private Date upd_dt;

    public MemberEntity toEntity() {
        return MemberEntity.builder()
                .id(id)
                .name(name)
                .password(password)
                .address(address)
                .gender(gender)
                .phone(phone)
                .cre_dt(cre_dt)
                .build();
    }

    @Builder
    public Member(Long mSeq, String name, String id, String password, String address, String gender, String phone) {
        this.mSeq = mSeq;
        this.name = name;
        this.id = id;
        this.password = password;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
    }
}
