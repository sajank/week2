package com.pal.tracker;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import org.json.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
public class WelcomeController {

    @PostMapping("/")
    public Response sayHello(@RequestBody MyName myname) {
        Response response = new Response();
        response.setName(myname.getFirstName() + " " + myname.getLastName());
        response.setAge(22.0);

        LocalDateTime currentTime = LocalDateTime.now();
        LocalDate date = currentTime.toLocalDate();
        response.setDob(date);
        return response;
    }

    @GetMapping("/myname")
    public MyName myName() {
        MyName myName = new MyName();
        myName.setFirstName("Mayur");
        myName.setLastName("Santani");
        return myName;
    }

    @GetMapping("/xing/myhi")
    public MyName sayHi() {
        MyName xingName = new MyName();
        xingName.setFirstName("Xing");
        xingName.setLastName("Liu");
        return xingName;
    }
}