package com.meyok.controller;


import com.meyok.service.IMsgService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/msg")
public class MsgController {

    @Resource
    private IMsgService msgService;

    @GetMapping("/{tele}")
    public String get(@PathVariable String tele) {
        return msgService.get(tele);
    }

    @PostMapping
    public boolean check(String tele, String code) {
        return msgService.check(tele, code);
    }



}
