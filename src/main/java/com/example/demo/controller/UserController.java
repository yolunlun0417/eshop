package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用者控制器（Controller）
 * 職責：處理 HTTP 請求，呼叫 Service 層取得資料，並回傳給前端
 */
@RestController // 1. 標記為 REST Controller 元件
public class UserController {
    
    // 2.自動注入Service層
    @Autowired
    private UserService userService;

    /**
     * 查詢使用者API
     * URL範例: GET /api/user/U001
     * 
     * Spring Boot 會自動將 User 物件轉換成 JSON 格式回傳
     */
    @GetMapping("/api/user/{id}")
    public User getUser(@PathVariable("id") String userId) {
        // 呼叫 Service 層取得使用者詳細資料
        // spring Boot 會自動利用內建的 Jackson 將 User 物件轉換成 JSON 格式回傳
        return userService.getUserDetail(userId);
    }
}
