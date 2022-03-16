package com.MeYok.controller;


import com.MeYok.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Rest模式
@RestController
@RequestMapping("/books")
public class BookController {

    //读取yaml数据中的单一数据
    @Value("${country}")
    private String country;

    @Value("${users.name}")
    private String name;

    @Value("${list[1]}")
    private String list1;

    @Value("${tempDir}")
    private String tempDir;

    @Value("${tempDir1}")
    private String tempDir1;

    //使用自动装配将所有的数据封装到一个对象Environment中
    @Autowired
    private Environment env;

    @Autowired
    private MyDataSource myDataSource;


    @GetMapping
    public String getById(){
        System.out.println("springboot is running.");
        System.out.println("country====>"+country);
        System.out.println("name====>"+name);
        System.out.println("list1====>"+list1);
        System.out.println("tempDir====>"+tempDir);
        System.out.println("tempDir1====>"+tempDir1);
        System.out.println("---------");
        System.out.println(env.getProperty("server.port"));
        System.out.println(env.getProperty("country"));
        System.out.println("---------");
        System.out.println(myDataSource);
        return "springboot is running.";
    }

}
