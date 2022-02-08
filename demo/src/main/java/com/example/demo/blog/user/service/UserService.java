package com.example.demo.blog.user.service;

import com.example.demo.domain.User;

public interface UserService {

    /* 회원 정보 조회 */
    User getUser(String id);

    /* 회원 정보 저장 */
    void joinUser(User user);

    /* 회원 정보 수정 */
    void userUpdate(User user);

    /* 회원 정보 삭제 */
    void userDelete(String id);

}
