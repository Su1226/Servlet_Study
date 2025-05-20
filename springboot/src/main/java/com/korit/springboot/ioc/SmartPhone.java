package com.korit.springboot.ioc;

import org.springframework.beans.factory.annotation.Autowired;
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

@Component
public class SmartPhone {

    @Autowired      // 자동으로 객체를 주입하도록 하는 기능
    private Battery battery;

    public SmartPhone(Battery battery) {
        this.battery = battery;
    }

    public void powerOn() {
        battery.powerSupply();
        System.out.println("베터리로부터 전류를 공급받아 전원을 켭니다.");
    }
}
