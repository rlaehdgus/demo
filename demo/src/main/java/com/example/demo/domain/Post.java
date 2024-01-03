package com.example.demo.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Post {
	private Long postNo;
	private String postContent;
	private int postHitsCnt;
	private LocalDateTime regDt;
	private Long regUserNo;
    private LocalDateTime updDt;
    private Long updUserNo;
}
