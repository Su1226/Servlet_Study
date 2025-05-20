package com.korit.springboot.controller;

import com.korit.springboot.dto.Students;
import com.korit.springboot.dto.param.SearchStudentDto;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class StudentController {

     /*
        1. Class Student 필요 -> name과 age 변수 필요

        GET 요청
        /api/students
        응답 : [{Student 객체1}, {Student 객체2}, {Student 객체3}]

        POST 요청
        /api/students
        응답 : {status : "성공", data={Student 객체}}
     */

    @GetMapping("/study/students")
    public List<Students> getStudent(@RequestParam(required = false) String searchValue) {
        List<Students> students = new ArrayList<>();

        Students students1 = new Students("이수원", 25);
        Students students2 = new Students("김다혜", 25);
        Students students3 = new Students("정유지", 25);

        students.add(students1);
        students.add(students2);
        students.add(students3);

        System.out.println(searchValue);

        return students;
        // 한 줄 코딩
        // return List.of(new Students("이수원", 25), new Students("김다혜", 25), new Students("정유지", 25));
    }

    @PostMapping("/study/students")
    public Map<String, Object> postStudent(@RequestBody Students s) {
        Map<String, Object> statuse = new HashMap<>();
        statuse.put("status", "성공");
        statuse.put("data", s);

        return statuse;

        // 한 줄 코드
        // return Map.of("status", "성공", "data", s);
    }


    // 리스트에 학생이 있는지 없는지를 검색하는 기능을 구현해보자.
    @GetMapping("/study/studentsFind")
    public List<Students> getStudentFind(@RequestParam(required = false) String searchValue) {
        List<Students> students = List.of(
                new Students("김준일", 32),
                new Students("김명규", 28),
                new Students("정선유", 26),
                new Students("염진우", 30),
                new Students("이수원", 25)
        );

        if(searchValue != null && !searchValue.isBlank()) {      // isBlank()는 띄어쓰기는 글자로 취급하지 않고, isEmpty는 띄어쓰기도 글자 취급을 한다.
            return students.stream().filter(s -> s.getName().contains(searchValue)).collect(Collectors.toList());
        }

        return students;
    }

    // 이름을 랜덤으로 생성하기
    @GetMapping("/study/studentRandom")
    public List<Students> getStudentRandom(@RequestParam(required = false) String searchValue) {
        List<Students> students = new ArrayList<>();
        Random random = new Random();
        int startCOde = 0xAC00;     // 유니코드 한글의 '가'
        int endCode = 0xD7A3;       // 유니코드 한글의 '힇'

        for(int i = 0; i < 50; i++) {
            StringBuilder builder = new StringBuilder();    // StringBuilder는 문자를 합칠 때 사용하는 객체 자료형.
            builder.append((char) (startCOde + random.nextInt(endCode - startCOde + 1)));
            builder.append((char) (startCOde + random.nextInt(endCode - startCOde + 1)));
            builder.append((char) (startCOde + random.nextInt(endCode - startCOde + 1)));

            students.add(new Students(builder.toString(), random.nextInt(100) + 1));
        }

        if(searchValue != null && !searchValue.isBlank()) {      // isBlank()는 띄어쓰기는 글자로 취급하지 않고, isEmpty는 띄어쓰기도 글자 취급을 한다.
            return students.stream().filter(s -> s.getName().contains(searchValue)).collect(Collectors.toList());
        }

        return students;
    }

    // 검색된 내용들이 많을 경우 다음 페이지를 넘기는 기능
    @GetMapping("/study/studentPage")
            public List<Students> getStudentPage(SearchStudentDto searchStudentDto) {
//    public List<Students> getStudentPage(@RequestParam(required = false) String searchValue,
//                                         @RequestParam(required = false, defaultValue = "1") Integer page,
//                                         @RequestParam(required = false, defaultValue = "10") Integer count) {
        // 계속해서 파라미터가 길어지면 코드를 읽기 힘들기 때문에, 파라미터만 모아둔 폴더를 만들어 안에 넣는다.
        // 이렇게 쓰는 경우, @RequestBody를 사용할 수 없다.

        List<Students> students = new ArrayList<>();
        Random random = new Random();
        int startCOde = 0xAC00;     // 유니코드 한글의 '가'
        int endCode = 0xD7A3;       // 유니코드 한글의 '힇'

        for(int i = 0; i < 1000; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append((char) (startCOde + random.nextInt(endCode - startCOde + 1)));
            builder.append((char) (startCOde + random.nextInt(endCode - startCOde + 1)));
            builder.append((char) (startCOde + random.nextInt(endCode - startCOde + 1)));

            students.add(new Students(builder.toString(), random.nextInt(100) + 1));
        }

        if(searchStudentDto.getPage() < 1) {
            searchStudentDto.setPage(1);
        }

//        if(page == null && page < 1) {
//            page = 1;
//        } // 파라미터에 defaultValue = "1"을 사용하면 필요없는 내용

//        if(page < 1) {
//            page = 1;
//        }

        /*
            page = 1이라면? 0부터 시작
            page = 2라면? 10부터 시작
            page = 3이라면? 20부터 시작

            즉, page에 10개 단위로 값을 넣으며, 페이지를 넘겨 다음 값을 보는 개념.

            페이지와 검색 중 누가 먼저인가?
            검색이 먼저 되어야지 페이지에 나눌 수 있기 때문에
            검색을 우선 한 뒤, 페이지를 나눠야 한다.
         */


        List<Students> foundStudent = students;
        /*if(searchValue != null && !searchValue.isBlank()) {
            foundStudent = students.stream().filter(s -> s.getName().contains(searchValue)).collect(Collectors.toList());
        }*/     // 다음과 같은 코드들이 아래와 같이 변경된다. (해당 제외 나머지는 코드로 바로 바꿨음을 안내함.)

        if(searchStudentDto.getSearchValue() != null && !searchStudentDto.getSearchValue().isBlank()) {
            foundStudent = students.stream().filter(s -> s.getName().contains(searchStudentDto.getSearchValue())).collect(Collectors.toList());
        }

        int startIndex = (searchStudentDto.getPage() - 1) * searchStudentDto.getCount();
        List<Students> newStudent = new ArrayList<>();

//        if(foundStudent.size() < startIndex) {
//            startIndex = 0;
//        }     // 이러한 예외 상황들을 계속 해서 조건문을 만들어야 한다. -> 이를 방지하고자 try-catch로 예외를 묶어버리자.

        for(int i = 0; i < ((foundStudent.size() < searchStudentDto.getCount()) ? foundStudent.size() : searchStudentDto.getCount()); i++) {
            try {   // get 실행하는데, 없는 경우
                newStudent.add(foundStudent.get(startIndex + i));
            } catch (Exception e) {
                break;
            }
        }

        return newStudent;
    }
}

