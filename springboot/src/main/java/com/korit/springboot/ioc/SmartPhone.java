package com.korit.springboot.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
    @Component를 쓰는 순간 '부품'으로 IoC 컨테이너에
    해당 컴포넌트들이 들어가게 되며,

    해당 부품들을 자동 조립해주는 기능을 한다.

    또한 SamrtPhone에 Battery가 필요하기 때문에
    Batery도 자동으로 @Component가 된다.

    @Component는 스프링이 자동으로 객체를 생성하고 컨테이너에 등록해주는 애노테이션이다.

    즉, 개발자가 아닌 프레임워크가 직접 객체의 생성과 관리 권한을 한다. (스프링 컨테이너)
 */

/*
    IoC가 주로 어디에서 사용이 되는가?
    같은 기능을 하는 객체들을 생성하지 않고 기능을 담고 있는 것을 컴포넌트로 지정하여
    메모리 낭비를 방지하고 코드를 간결화 한다.
    -> SingleTon 디자인 패턴과도 연관이 있다.
 */

/*
    @Autowired은 필요한 의존성을 자동으로 주입한다.
    즉, "해당 필드에 객체를 자동으로 넣어줘"라는 의미로, 의존성 주입(DI)와 연관된 애노테이션이다.
    스피링이 필요한 객체를 자동으로 찾아서 주입함.
 */

/*
    Component의 종류
    1. @Component : 특정 기능이 정해져 있지 않은 객채(나머지 객체) (filter, converter, exception)
    2. @Controller : HTTP 요청 및 응답을 처리하는 객체
    3. @Service : 비즈니스 로직 또는 메인 로직을 정의하고 처리하는 객체
    4. @Repository : Database와 관련된 로직을 정의하고 처리하는 객체
    5. @Configuration : 설정 로직을 정의하고 처리하는 객체 또는 직접 생성 후 IoC 등록을 필요로 하는 Bean 설정

    해당 Component를 사용하지 못하는 경우가 있다.
    1. 컴포넌트 스캔 범위 밖에 있는 경우(해당 클래스가 다른 패키지에 있을 때)
    2. 빈으로는 등록되는 클래스이지만, 애노테이션을 안 썼을 경우
    3. 인터페이스만 있고 구현체가 없을 때
    4. 조건부 등록 조건을 만족하지 못한 경우(@Conditional, @Profile 등)
    5. 컴파일 오류나 순환 참조의 문제가 생기는 경우
        ㄴ 예를 들어, A가 B를 주입받고, B도 A를 주입받는 경우
        ㄴ @Autowired에서 순환 참조 오류 발생이 가능하다. (특히 생성자 주입 때)
    6. XML 기반으로만 설정하고 있을 때

    @Component가 붙은 각 각의 컨테이너 이름은 클래스명이 된다.
    만약 카멜표기법으로 클래스명을 작성하게 되면, 앞의 대문자가 소문자로 바뀌어 저장된다.
 */

@Component
public class SmartPhone {

    // @Autowired      // 자동으로 객체를 주입하도록 하는 기능
//    @Qualifier(value = "samsungBattery")    // 여러 베터리를 받는 경우, 해당 애노테이션을 사용하여 베터리를 지정해줄 수 있다.
//    private Battery battery;

    /*
        항상 @Qualifier를 쓰지 않고도 바로 사용할 수 있도록
        SmartPhone이 받는 파라미터에 애초에 넣어준다.
     */

    private Battery battery;

    public SmartPhone(SamsungBattery battery) {
        this.battery = battery;
    }

    public void powerOn() {
        battery.powerSupply();
        System.out.println("베터리로부터 전류를 공급받아 전원을 켭니다.");
    }
}
