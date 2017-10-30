package com.pal.tracker;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public String sayHello() {
        return "hello Xing";
    }

    @GetMapping("/xing/myhi")
    public MyName sayHi() {
        MyName xingName = new MyName();
        xingName.setFirstName("Xing");
        xingName.setLastName("Liu");
        return xingName;
    }
}