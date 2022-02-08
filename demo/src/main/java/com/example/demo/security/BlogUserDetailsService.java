package com.example.demo.security;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;

@Service(value = "UserDetailsService")
public class BlogUserDetailsService implements UserDetailsService, Serializable {
    private static final long serialVersionUID = 3313761034601237777L;

    @Resource(name = "UserRepository")
    private UserRepository userRepository;

    @Override
    @Transactional
    public BlogUser loadUserByUsername(String id) throws UsernameNotFoundException {

        // 로그인 시도하려는 유저정보 조회
        User user = userRepository.getUser(id);

        // 유저정보 null 체크
        if(user == null) {
            throw new UsernameNotFoundException(id);
        }
        System.out.println("user: "+user);
        // 조회한 정보를 blogUser에 담는다.
        // 만약 파라미터를 추가해야한다면 blogUser을 먼저 수정한다.
        BlogUser blogUser = new BlogUser(user);

        return blogUser;
    }
}
