package com.pal.tracker;

import java.time.LocalDate;

public class Response {
    private String name;
    private Double age;
    private LocalDate dob;

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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
