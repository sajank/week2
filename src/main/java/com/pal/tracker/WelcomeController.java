package com.pal.tracker;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import org.json.*;

@RestController
public class WelcomeController {

    @PostMapping("/")
    public Response sayHello(@RequestBody MyName myname) {
        return new Response("Hello Mr. " +myname.getFirstName() + " " + myname.getLastName());
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