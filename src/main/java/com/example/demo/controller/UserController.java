package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 使用者控制器（Controller）
 * 職責：處理 HTTP 請求，呼叫 Service 層取得資料，並回傳給前端
 */
@RestController // 1. 標記為 REST Controller 元件
@RequestMapping("/api/users") // 2. 設定基礎路徑
public class UserController {
    
    // 2.自動注入Service層
    private final UserService userService;
    UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 新增使用者
     * POST /api/users
     * Body: { "id": "U004", "name": "王大明", "email": "damin@example.com" }
     */
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    /**
     * 查詢所有使用者
     * GET /api/users
     * Spring Boot 會自動將 User 物件轉換成 JSON 格式回傳
     */
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * 查詢特定使用者
     * GET /api/users/{id}
     */
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    /**
     * 刪除特定使用者
     * DELETE /api/users/{id}
     */
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "User with ID " + id + " has been deleted.";
    }
}