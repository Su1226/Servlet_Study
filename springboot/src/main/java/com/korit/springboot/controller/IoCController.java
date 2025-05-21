package com.korit.springboot.controller;

import com.korit.springboot.ioc.Battery;
import com.korit.springboot.ioc.SamsungBattery;
import com.korit.springboot.ioc.SmartPhone;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class IoCController {

    // @Component가 있기 때문에,
    // 자동으로 조립이 된다. → IoC 개념.

    @Autowired
    private SmartPhone phone;

    @GetMapping("/ioc")
    public String get() {
        phone.powerOn();
        return null;
    }

    @GetMapping("/ioc2")
    public String get2() {
        phone.powerOn();
        return null;
    }
}
