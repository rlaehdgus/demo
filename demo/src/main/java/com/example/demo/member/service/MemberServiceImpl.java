package com.example.demo.member.service;

import com.example.demo.domain.Member;
import com.example.demo.domain.MemberRepository;
import com.example.demo.domain.Role;
import com.example.demo.domain.entity.MemberEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements UserDetailsService {

    private MemberRepository memberRepository;

    @Transactional
    public void joinUser(Member member) {
        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setPassword(passwordEncoder.encode(member.getPassword()));

        memberRepository.save(member.toEntity());
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Optional<MemberEntity> userEntityWrapper = memberRepository.findById(id);
        MemberEntity userEntity = userEntityWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        // 계정으로 권한 구분
        if (("admindhkim").equals(id)){
           authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else if(("develdhkim").equals(id)) {
            authorities.add(new SimpleGrantedAuthority(Role.DEVELOPER.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }

        return new User(userEntity.getName(), userEntity.getPassword(), authorities);
    }
}
