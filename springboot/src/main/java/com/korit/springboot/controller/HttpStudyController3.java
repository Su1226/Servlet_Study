package com.korit.springboot.controller;

import com.korit.springboot.dto.PostAddress;
import com.korit.springboot.dto.PostData;
import com.korit.springboot.dto.Students;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HttpStudyController3 {

    /*
        GET 요청은
        주소에 값을 입력한다.

        해당 주소에 넣는 값을 '파라미터(Parameter)'라고 하며,
        파라미터란? 주소의 `?` 뒤에 따라오는 `key=value` 값을 의미한다.
        EX) http://localhost8080:/api/names?name="이수원"

        파라미터(여러 개의 데이터를 요청할 시, `&`로 구분한다.)
        EX) http://localhost8080:/api/names?name="이수원"&age=25

        GET의 경우에는 파라미터로만 데이터를 받아야 하기 때문에,
        @RequestParam을 사용해야 한다.
     */
    @GetMapping("/study/get")
    public String get(@RequestParam String name,
                      @RequestParam Integer age) {
        return "GET 요청입니다.";
    }

    /*
        POST 요청은
        가능한 JSON으로 값을 입력한다.
        "{
            "key1" : "value1",
            "key2" : "value2",
            "key3" : {
                key4 : value4
                key5 : ["a", "b", "c", "d"]
                }
            }
        }"
        → JSON 형식이기에, MAP으로 받는다.

        POST의 경우에는 BODY를 통해 데이터를 전달한다.
        또한 데이터를 받기 위해서는 매개변수 앞에 @RequestBody가 필요하다.
        (@RequestBody가 데이터를 JSON으로 변환하고 가져오는 기능을 한다.)

        데이터로는 객체가 들어가도 된다.
     */
    @PostMapping("/study/post")     // 지정된 형식이 없으므로, 다운 캐스팅 필요.
    public String post(@RequestBody Map<String, Object> data) {
        System.out.println(data);

        // 특정 키 값만 뽑아 낼 수도 있음.
        System.out.println(data.get("age"));

        // 맵 안에 든 맵도 뽑아 낼 수 있으나,
        // 다운 캐스팅을 진행한 후에, 원하는 key 값을 넣어야 한다.
        System.out.println(((Map<String, Object>) data.get("address")).get("address_doro"));
        /*
            위의 코드를 풀어 쓰면,
            Object dataObj1 = map.get("address");
            Map<String, Object> dataMap = (Map<String, Object>) dataObj1;
            Object dataObj2 = map.get("address_doro");
            List<String> dataList = (List<String>) dataObj2;
         */
        return "POST 요청입니다.";
    }

    @PostMapping("/study/post2")    // 지정된 형식이 있는 데이터 틀(data transfer object)이므로, 다운 캐스팅이 불필요.
    public String post2(@RequestBody PostData postData) {
        System.out.println(postData);
        System.out.println(postData.getAddress());

        // post에서는 하나씩 정의하면서 가져왔다면,
        // post2에서는 클래스로 정의하여 미리 값을 정의해 가져올 수 있다.
        // 즉, 다운 캐스팅을 할 필요가 없다.

        PostAddress address = postData.getAddress();
        System.out.println(address.getAddress_doro());
        return "POST2 요청입니다.";
    }

    /*
        PUT 요청은
        JSON으로 값을 입력한다.

        POST와 동일하게 동작을 한다.
        수정 기능을 하는 요청.
     */
    @PutMapping("/study/put")
    public String put() {
        return "PUT 요청입니다.";
    }

    /*
        DELETE 요청은
        경로에 값을 입력한다.
        EX) /api/study/delete/10
        EX) /api/study/delete/book/10       // 2개의 파라미터도 가능하다.

        가능한 명확한 키 값을 주어야 삭제할 때 정확하게 삭제하고자 하는 값을 삭제할 수 있다.
        (하나의 데이터를 명확하게 짚어서 삭제할 것.)
     */
    @DeleteMapping("/study/delete/{category}/{id}")
    public String delete(@PathVariable String category, @PathVariable Long id) {
        return "DELETE 요청입니다.";
    }

    /*
        스웨거는 Open API로,
        문서화를 하는 작업을 한다.
        (설명서를 만드는 기능.)
        → 백엔드에서 필수.

        백엔드에서는 API 명세서가 필요.
        프렌드엔드는 '피그마'와 같은 툴을 이용해서 화면을 만들어야 한다.
     */
}
