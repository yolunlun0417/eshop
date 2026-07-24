package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public String sayHello(
        @RequestParam(value = "name", defaultValue = "World") 
        String name
    ){
        return String.format("Hello %s!歡迎來到Spring Boot的世界", name);
    }

    @GetMapping("/api/bmi")
    public String calculateBMI(
        @RequestParam("weight") double weight,
        @RequestParam("height") double height
    ) {
        double bmi = weight / (height/100 * height/100);
        return String.format("您的身高為: %.2fcm, 體重為: %.2fkg, 您的BMI值為: %.2f", height, weight, bmi);
    }
    

    @GetMapping("/api/user/{id}/profile")
    public String getUserProfile(
        @PathVariable("id") String userId
    ) {
        return String.format("正在查詢使用者 ID 為:" + userId + " 的詳細檔案");
    }

    @GetMapping("/api/time")
    public String getCurrentTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        return String.format("目前的時間是: %s", currentTime.toString());
    }
}

