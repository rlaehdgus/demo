package com.example.demo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity(name = "bbs_info")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 게시글 고유번호
    private Long b_seq;
    // 게시판 종류
    private String board_id;
    // 제목
    private String subject;
    // 내용
    private String content;
    // 조회수
    private int hit;
    // 댓글사용여부
    private String cmt_use_yn;
    // 사용여부
    private String use_yn;
    // 삭제여부
    private String del_yn;
    // 공지여부
    private String top_yn;
    // 생성일
    private String cre_dt;
    // 생성자
    private String cre_id;
    // 수정일
    private String upd_dt;
    // 수정자
    private String upd_id;

    @Builder
    public Blog(String subject, String content, int hit, String cmt_use_yn, String use_yn, String del_yn, String top_yn, String cre_id, String upd_id) {
        this.subject = subject;
        this.content = content;
        this.hit = hit;
        this.cmt_use_yn = cmt_use_yn;
        this.use_yn = use_yn;
        this.del_yn = del_yn;
        this.top_yn = top_yn;
        this.cre_id = cre_id;
        this.upd_id = upd_id;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "b_seq=" + b_seq +
                ", board_id='" + board_id + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", hit=" + hit +
                ", cmt_use_yn='" + cmt_use_yn + '\'' +
                ", use_yn='" + use_yn + '\'' +
                ", del_yn='" + del_yn + '\'' +
                ", top_yn='" + top_yn + '\'' +
                ", cre_dt='" + cre_dt + '\'' +
                ", cre_id='" + cre_id + '\'' +
                ", upd_dt='" + upd_dt + '\'' +
                ", upd_id='" + upd_id + '\'' +
                '}';
    }
}
