package com.meyok.controller;

import com.meyok.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


//@Controller
//@ResponseBody
@RestController //include controller and responseBody
@RequestMapping("/users")
public class UserController {

    //增加User
    @PostMapping //equal to @RequestMapping(method = RequestMethod.POST)
    public String save(@RequestBody User user){
        System.out.println("user save...");
        System.out.println(user);
        return "{\"module\": \"user save\"}";
    }

    //根据id删除user
    @DeleteMapping("/{id}") //equal to @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteByUserId(@PathVariable(name = "id") Integer id){
        System.out.println("user delete..." + id);
        return "{\"module\": \"user delete\"}";
    }

    //删除所有user
    @DeleteMapping
    public String deleteAllUser(){
        System.out.println("allUser delete...");
        return "{\"module\": \"allUser delete\"}";
    }

    //根据id查询某个user
    @GetMapping("/{id}")
    public String getByUserId(@PathVariable(name = "id") Integer id){
        System.out.println("user get..." + id);
        return "{\"module\": \"user get\"}";
    }

    //查询所有user
    @GetMapping
    public String getAllUser(){
        System.out.println("allUser get...");
        return "{\"module\": \"allUser get\"}";
    }

    //修改user
    @PutMapping
    public String update(@RequestBody User user){
        System.out.println("user update..." + user);
        System.out.println(user);
        return "{\"module\": \"user update\"}";
    }


}
