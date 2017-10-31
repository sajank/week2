package com.pal.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@RestController
public class WelcomeController {

    static Logger log = LoggerFactory.getLogger(WelcomeController.class.getName());

    @PostMapping("/")
    public Response sayHello(@RequestBody MyName myname) {
        Response response = new Response();
        response.setName(myname.getFirstName() + " " + myname.getLastName());
        response.setAge(22.0);

        LocalDateTime currentTime = LocalDateTime.now();
        response.setDob(currentTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return response;
    }

    @GetMapping("/myname")
    public MyName myName() {
        log.info("This is a info level log statement");
        log.error("This is new error message");
        log.debug("*************881");
        log.debug("*************882");
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