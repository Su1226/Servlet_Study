package com.korit.springboot.dto;

import lombok.Data;

@Data
public class PostData {

    private String name;
    private Integer age;
    private PostAddress address;

}

// JSON을 값으로 받아오기 위해, Setter가 필요하다.
// Getter는 받아 온 후, return 하기 위해서 필요하다.
// ToString의 경우, 값을 출력하기 위해서 필요하다. -> 없을 경우, 주소 값이 출력된다.
// 위 3개를 합친 것이 @Data이다.