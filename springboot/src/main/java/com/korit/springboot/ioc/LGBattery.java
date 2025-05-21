package com.korit.springboot.ioc;

/*
    만약 SmartPhone 객체에 Battery 객체를 넣어야 하는데,
    이때, LGBettery에도 @Component가 붙으면,

    Samsung과 LG 어느 쪽을 택해야 하는지 모르게 되어버리며,
    오류가 발생하게 된다.

    두개의 객체를 찾았기 때문에, IoC에서 어떤걸로 조립해야 하는지 알 수 없어서 오류가 발생하게 되는 것이다.
    이러한 문제를 해결하기 위해 SmartPhone이 객체 생성될 때, 무조건 SamsungBattery를 생성자에 넣어줘야 한다.
    (SmartPhone 클래스의 생성자에서 명시 해준다.)
 */

public class LGBattery implements Battery {
    @Override
    public void powerSupply() {
        System.out.println("LG 베터리에 전력을 공급합니다.");
    }

    @Override
    public void charge() {
        System.out.println("LG 베터리를 충전합니다.");
    }
}
