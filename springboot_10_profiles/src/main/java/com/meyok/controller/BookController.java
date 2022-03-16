package com.meyok.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j //需要lombok
@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public String getById(){
        System.out.println("springboot is running");

        log.debug("debug....");
        log.info("info....");
        log.warn("warn....");
        log.error("error....");



        return "springboot is running";
    }


}
