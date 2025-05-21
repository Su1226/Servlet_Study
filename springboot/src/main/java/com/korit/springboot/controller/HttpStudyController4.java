package com.korit.springboot.controller;

/*
    REST(REpresentational State Transfer) API
    → 리소스(데이터)를 "URL"로 표현하고, HTTP 메서드(GET, POST 등)로 상태를 주고받는 아키텍처 스타일
    → 웹 상의 자원을 이름으로 구분하고 해당 자원의 상태를 주고 받는 모든 것을 의미한다.
    → REST는 클라이언트와 서버 간의 상호작용을 규정하며, 여러 가지 원칙과 제약 조건들을 가지고 있다.
    → 해당 REST 원칙을 따르는 웹 API를 말한다.

    그렇다면 RESTful API는?
    → REST 아키텍처 스타일을 따르는 웹 API이다.
    → 즉, REST 원칙을 잘 지키며 설계된 가이드 라인을 실제로 적용한 API를 RESTful API라고 말한다.

    요청과 응답

    참고 자료 : https://m.blog.naver.com/codingbarbie/223233477242
    참고 자료 : https://hahahoho5915.tistory.com/54
 */

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HttpStudyController4 {

    // 이전의 방식
    @GetMapping("/api/study/http/get")
    public ResponseEntity<Map<String, Object>> get() {
        // return new ResponseEntity<>(Map.of("name", "이수원", "age", 25), HttpStatus.BAD_REQUEST);

        // 위 코드처럼 생성이 귀찮아 아래와 같이 변함.
        // 아래 코드는 Body인지 확실한 판단이 가능하다.
        // 아래 처럼 짜는 방법을 Static 방식이라고 한다. -> 생성하지 않고 호출해서 사용하겠다는 의미.
        return ResponseEntity.badRequest().body(Map.of("name", "이수원", "age", 25));
    }
}
