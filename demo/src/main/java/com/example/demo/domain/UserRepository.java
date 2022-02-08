package com.example.demo.domain;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository(value = "UserRepository")
@Mapper
public interface UserRepository {

    /* 회원 정보 조회 */
    User getUser(String id);

    /* 회원 정보 저장 */
    void userInsert(User user);

    /* 회원 정보 수정 */
//    void userUpdate(User user);

    /* 회원 정보 삭제 */
//    void userDelete(String id);
}


