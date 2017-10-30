package com.pal.tracker;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public String sayHello() {
        return "mayur";
    }

    @GetMapping("/myname")
    public MyName myName() {
        MyName myName = new MyName();
        myName.setFirstName("Mayur");
        myName.setLastName("Santani");
        return myName;
    }
}