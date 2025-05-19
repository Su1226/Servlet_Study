package com.korit.springboot.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
    HttpServletRequest 객체란?
    외부에서 Tomcat 웹 서버로 요청 시 생성되는 요청 정보 객체이다.
 */

@RestController
public class HttpServiceRequestController {


    @GetMapping("/api/myname")
    public String getMyName(@RequestParam(required = false) String str,
                            @RequestParam(required = false) int num) {
        System.out.println(str);
        System.out.println(num);
        System.out.println(num + 10);
        return "이수원";
        // value 값을 받기 때문에
        // 파라미터에 꼭 value값을 넣지 않고 생략해도 된다.
        // 단 value가 없을 경우에는 반드시 변수명을 넣어서 자료를 보내야 한다.

        // @RequestParam은 자동으로 형 변환도 가능하다.
    }
}
