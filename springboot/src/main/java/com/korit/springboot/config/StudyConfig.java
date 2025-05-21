package com.korit.springboot.config;

import com.korit.springboot.ioc.BeanStudy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.interfaces.PBEKey;

/*
    @Configuration은
    주로 config라는 파일에 등록되며,

    설정 파일들을 담는다.

    만약 아래 처럼 Bean을 생성하지 않으면,
    앞서 작성한 코드처럼 @Component를 붙이면 되는 것.

    주로 이렇게 config 파일을 만들어서 직접 bean을 생성해주는 경우는
    다른 외부 라이브러리를 참조할 때 컴포넌트를 등록하게 된다.
    (주로 데이터베이스 설정이나 서버를 설정할 때 사용)

    또한 해당 파일은 서버를 실행하면 무조건 한 번 실행이 된다.

    @Bean은 여러 개의 빈을 등록할 수 있다.
 */

@Configuration
public class StudyConfig {
// @Configuration은
// 하나의 Component이지만, 설정 객체이기 때문에 프로그램 실행 시 무조건 한 번 실행된다.
// 그렇기 때문에 여러 개의 빈을 생성하고 등록할 수 있다.

    @Bean
    public BeanStudy beanStudy() {
        System.out.println("bean 생성");
        return new BeanStudy();
    }

    //
//    @Bean
//    public Criteria criteria() {
//        return new Criteria();
//    }
}
