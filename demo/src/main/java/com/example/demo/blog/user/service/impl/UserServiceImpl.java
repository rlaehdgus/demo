package com.example.demo.blog.user.service.impl;

import com.example.demo.domain.User;
import com.example.demo.blog.user.service.UserService;
import com.example.demo.blog.user.service.impl.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Override
    public User getUser(String id) {
        return userRepository.getUser(id);
    }

    @Override
    public void joinUser(User user) {
        //System.out.println("user: "+ user);
        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setUserPwd(passwordEncoder.encode(user.getUserPwd()));

        userRepository.userInsert(user);
    }

    @Override
    public void userUpdate(User user) {
        //비밀번호 입력 여부 확인
        if(user.getUserPwd() != null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            user.setUserPwd(passwordEncoder.encode(user.getUserPwd()));
        }

//        userRepository.userUpdate(user);
    }

    @Override
    public void userDelete(String id) {
//        userRepository.userDelete(id);
    }
}
