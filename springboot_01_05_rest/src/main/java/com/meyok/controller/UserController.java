package com.meyok.controller;

import com.meyok.domain.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@Controller
public class UserController {

    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String save(){
        System.out.println("user save...");
        return "{\"module\": \"user save\"}";
    }

    @ResponseBody
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(name = "id") Integer id){
        System.out.println("user delete..." + id);
        return "{\"module\": \"user delete\"}";
    }

    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public String update(@RequestBody User user){
        System.out.println("user update..." + user);
        return "{\"module\": \"user update\"}";
    }


}
