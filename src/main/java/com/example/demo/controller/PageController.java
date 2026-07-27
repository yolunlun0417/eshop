package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


/**
* 頁面導向控制器（使用 @Controller）
* 負責處理網頁請求，回傳 HTML 頁面
*/
@Controller
public class PageController {

    /**
     * 歡迎頁面(首頁)
     * URL: GET /welcome
     */
    @GetMapping("/welcome")
    public String welcomePage(Model model) {
        // 使用 Model 的 addAttribute() 方法，以「鍵(key)－值(value)」方式將資料傳遞給 Thymeleaf 模板
        model.addAttribute("title", "Spring Boot與 Thymeleaf 整合");
        model.addAttribute("message","歡迎來到Day 4 前端整合應用");
        model.addAttribute("currentTime",java.time.LocalDateTime.now().toString());

        // 回傳模板名稱
        // Spring Boot 會自動尋找 src/main/resources/templates/ 尋找 welcome.html 模板
        return "welcome";
    }

    /**
     * 顯示使用者註冊表單
     * URL: GET /user/form
     */
    @GetMapping("/user/form")
    public String showForm(Model model) {
        // 傳遞一個空的 User 物件給前端，用於表單欄位與 Model 的資料綁定
        model.addAttribute("user", new User());
        return "user-form";  // 導向 user-form.html
    }

    /**
     * 處理使用者註冊表單提交
     * URL: POST /user/save
     */ 
    @PostMapping("/user/save")
    public String saveUser(
        @ModelAttribute("user") User user,
        Model model) {
        // 自動將表單參數綁定為 User 物件
        // 接收到的使用者資料已自動綁定完成
        // 可以在此處進行資料庫儲存
        // userService.saveUser(user);  // 可整合Service

        // 將使用者資料傳遞給結果頁面顯示
        model.addAttribute("savedUser", user);
        
        // 渲染結果頁面
        return "user-result";  // 導向 user-result.html
    }

}
