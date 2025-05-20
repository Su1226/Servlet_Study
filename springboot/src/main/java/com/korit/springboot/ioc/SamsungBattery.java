package com.korit.springboot.ioc;

import org.springframework.stereotype.Component;

@Component
public class SamsungBattery implements Battery{

    @Override
    public void powerSupply() {
        System.out.println("삼성 베터리에 전력을 공급합니다.");
    }

    @Override
    public void charge() {
        System.out.println("삼성 베터리를 충전합니다.");
    }
}
