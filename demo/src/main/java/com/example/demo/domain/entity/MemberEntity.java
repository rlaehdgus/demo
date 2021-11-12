package com.example.demo.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mSeq;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String id;

    @Column(length = 150, nullable = false)
    private String password;

    @Column(length = 300, nullable = false)
    private String address;

    @Column(length = 1, nullable = false)
    private String gender;

    @Column(length = 11, nullable = false)
    private String phone;

    @Temporal(TemporalType.TIMESTAMP)
    private Date cre_dt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date upd_dt;

    @Builder
    public MemberEntity(Long mSeq, String name, String id, String password, String address, String gender, String phone, Date cre_dt, Date upd_dt) {
        this.mSeq = mSeq;
        this.name = name;
        this.id = id;
        this.password = password;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
        this.cre_dt = cre_dt;
    }
}
