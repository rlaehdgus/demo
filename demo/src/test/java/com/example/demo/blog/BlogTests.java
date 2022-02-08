package com.example.demo.blog;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import com.example.demo.blog.user.service.UserService;
import com.example.demo.domain.Blog;
import com.example.demo.domain.BlogRepository;
import com.example.demo.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class BlogTests {

//    @Autowired
//    private BlogRepository blogRepository;

    @Autowired
    private UserService userService;

    @Test
    void save() {
        // 게시글 파라미터 생성
        Blog params = Blog.builder()
                .subject("게시글 제목")
                .content("게시글 내용")
                .cmt_use_yn("Y")
                .hit(0)
                .use_yn("Y")
                .del_yn("N")
                .top_yn("Y")
                .cre_id("홍길동")
                .upd_id("홍길동1")
                .build();

        // 게시글 저장
//        blogRepository.save(params);

        // 게시글 정보 조회
//        Blog entity = blogRepository.findById((long) 4).get();
//        assertThat(entity.getSubject()).isEqualTo("게시글 제목");
//        assertThat(entity.getContent()).isEqualTo("게시글 내용");
//        assertThat(entity.getCmt_use_yn()).isEqualTo("Y");
//        assertThat(entity.getHit()).isEqualTo(0);
//        assertThat(entity.getUse_yn()).isEqualTo("Y");
//        assertThat(entity.getDel_yn()).isEqualTo("N");
//        assertThat(entity.getTop_yn()).isEqualTo("Y");
//        assertThat(entity.getCre_id()).isEqualTo("홍길동");
//        assertThat(entity.getUpd_id()).isEqualTo("홍길동1");
    }

    @Test
    void findAll() {
        // 전제 게시글 수 조회
//        long blogsCount = blogRepository.count();

        // 전체 게시글 리스트 조회
//        List<Blog> blogs = blogRepository.findAll();
    }

    @Test
    void openView() {
        // 상세 페이지 조회 및 결과값 로그 출력
//        Optional<Blog> blog = Optional.of(blogRepository.findById((long) 2).get());
//        System.out.println("blog view: "+ blog.toString());

        // 상세 페이지 조회 시 hit 값 증가
//        blog.ifPresent(selectBlog -> {
//            selectBlog.setHit(blog.get().getHit()+1);
//            selectBlog.setUpd_id("김동현");
//            selectBlog.setUpd_dt("2021-10-06");
//            Blog newBlog = blogRepository.save(selectBlog);
//            System.out.println("blog: "+ newBlog.toString());
//        });
    }

    @Test
    void delete() {
        // 게시글 조회
//        Blog entity = blogRepository.findById((long) 3).get();

        // 게시글 삭제
//        blogRepository.delete(entity);
    }

    @Test
    void equalsTest() {
        String nullVal = null;
        String val = Optional.ofNullable(nullVal).orElse("test");
        assertEquals("test", val);
    }

    @Test
    void memberInfo() {
        String id = "kimdh";

        User user = userService.getUser(id);

        System.out.println("user: "+ user);
    }
}
