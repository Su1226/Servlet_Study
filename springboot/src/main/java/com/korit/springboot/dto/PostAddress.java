package com.korit.springboot.dto;

import lombok.Data;

import java.util.List;

@Data
public  class PostAddress {
    private String address_si;
    private String address_gu;
    private String address_ro;
    private List<String> address_doro;
}
