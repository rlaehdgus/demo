package com.example.demo.member.service;

import com.example.demo.domain.Member;
import org.springframework.security.core.userdetails.UserDetails;

public interface MemberService {
    public void joinUser(Member member);
}
