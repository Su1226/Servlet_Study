package com.korit.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
    SpringBoot의 경우에는 하나의 클래스에서 여러 개의 클래스를 만들어
    가독성 있고, 편리하게 작성이 가능하다.
 */

@RestController     // @RestController로 하는 경우, 아래 @ResponseBody를 생략할 수 있다.
@RequestMapping("/api")     // 주소 매핑
public class HttpStudyController {

    @GetMapping("/http")    // 주소 매핑
    public String get() {
        return "test";
    }

    @GetMapping("/name")
//    @ResponseBody     // 데이터를 응답하겠다는 의미.
    // @ResponseBody가 없을 경우, ViewResolver까지 찾아가서 뷰를 찾는다. -> 아닌 경우 생략 후, 바로 View를 찾음.
    public String getName() {
        return "이수원";
    }
}
