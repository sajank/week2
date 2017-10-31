package com.pal.tracker;

import java.time.LocalDateTime;

public class Response {
    private String name;
    private Double age;
    private String dob;

    public Response() {}

    public Response(String response) {
        this.name = response;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
