package com.korit.springboot.controller;

/*
    요청 URL : /api/age
    응답 데이터 : {name : 김준일, 나이 : 32}

    요청 URL : /api/names
    응답 데이터 : ["김준일", "김준이", "김준삼"]

    요청 URL : /api/students
    응답 데이터 : [{name : 김준일, age : 32}, {name : 김준이, age : 33}]

    요청 UPL : /api/students2
    응답 데이터 : [
                    {
                        name : 김준일,
                        age : 32,
                        hobby: [축구, 농구]
                    },
                    {
                        name : 김준이,
                        age : 32,
                        hobby: [골프, 낙시]
                    }
                ]
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HttpStudyController2 {

    @GetMapping("/age")
    public Map<String, Object> getInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("name", "김준일");
        info.put("age", 32);
        return info;

        // return Map.of("name", "김준일", "age", 32);로 한 줄 코딩 가능 -> 정적으로 이미 고정된 값.
        // 단, 수정이나 삭제, 추가 등의 동작을 할 경우에는
        // 직접 선언해서 하나씩 넣어줘야 함.
    }

    @GetMapping("/names")
    public List<String> getName() {
        List<String> studentNames = List.of("김준일", "김준이", "김준삼");   // 불변 리스트
        return studentNames.stream().toList();

        // return List.of("김준일", "김준이", "김준삼");로 한 줄 코딩 가능 -> 정적으로 이미 고정된 값.
        // 단, 수정이나 삭제, 추가 등의 동작을 할 경우에는
        // 직접 선언해서 하나씩 넣어줘야 함.

        // 또는 String[] 배열을 사용해도 된다.
        // String[] names = ["김준일", "김준이", "김준삼"];
        // return names;
    }

    @GetMapping("/students")
    public List<Map<String, Object>> getStudent() {
        List<Map<String, Object>> studentList = new ArrayList<>();
        Map<String, Object> student1 = new HashMap<>();
        Map<String, Object> student2 = new HashMap<>();

        student1.put("name", "김준일");
        student1.put("age", 32);

        student2.put("name", "김준이");
        student2.put("age", 33);

        studentList.add(student1);
        studentList.add(student2);

        return studentList.stream().toList();
    }

    @GetMapping("/students2")
    public List<Map<String, Object>> getStudent2() {
        Map<String, Object> student1 = new HashMap<>();
        Map<String, Object> student2 = new HashMap<>();

        List<String> student1Hobby = List.of("축구", "농구");
        List<String> student2Hobby = List.of("골프", "낚시");

        List<Map<String, Object>> students = new ArrayList<>();

        student1.put("name", "김준일");
        student1.put("age", 32);
        student1.put("hobby", student1Hobby);

        student2.put("name", "김준이");
        student2.put("age", 33);
        student2.put("hobby", student2Hobby);

        students.add(student1);
        students.add(student2);

        return students;



    }

}


