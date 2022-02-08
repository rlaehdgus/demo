package com.example.demo.blog.user.service;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
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
//        System.out.println("user: "+ user);
        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.userInsert(user);
    }

    @Override
    public void userUpdate(User user) {
        //비밀번호 입력 여부 확인
        if(user.getPassword() != null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

//        userRepository.userUpdate(user);
    }

    @Override
    public void userDelete(String id) {
//        userRepository.userDelete(id);
    }
}
