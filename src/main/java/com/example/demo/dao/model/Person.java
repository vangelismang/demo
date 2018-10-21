package com.example.demo.dao.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Person {

    private String name;

    private String occupation;

    private String lastName;

    private String race;

    private String nationality;

    private String fax;

    private String tel;

    private String email;

    private String address;

    private String middleName;

    private String mobile;

    private String sex;

    private Integer age;

    private String maritalStatus;
}
