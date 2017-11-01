package com.pal.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Response {
    static Logger log = LoggerFactory.getLogger(Response.class.getName());
    private String name;
    private Double age;
    private String dob;

    public Response() {
        log.debug("Response(): age set to Double value.");
    }

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
