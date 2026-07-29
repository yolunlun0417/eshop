package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * 使用者控制器（Controller）
 * 職責：處理 HTTP 請求，呼叫 Service 層取得資料，並回傳給前端
 */
@RestController //標記為 REST Controller 元件
@RequestMapping("/api/users") //統一路徑前綴
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
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        // 201 Created：資源成功建立
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    /**
     * 查詢所有使用者
     * GET /api/users
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);  // 200 OK
    }

    /**
     * 查詢特定使用者
     * GET /api/users/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        User user = userService.getUserById(id);
        if (user == null) {
            // 404 Not Found：資源不存在
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        // 200 OK：找到資源
        return ResponseEntity.ok(user);
    }

    /**
     * 刪除特定使用者
     * DELETE /api/users/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        // 檢查資源是否存在
        User existingUser = userService.getUserById(id);
        if (existingUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // 404
        }
        
        userService.deleteUserById(id);
        // 204 No Content：成功刪除，無需回傳內容
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * 更新特定使用者
     * PUT /api/users/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable String id, 
            @RequestBody User userDetails) {
        // 檢查資源是否存在
        User existingUser = userService.getUserById(id);
        if (existingUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // 404
        }
        // 將前端傳入的資料覆蓋到既有物件
        existingUser.setName(userDetails.getName());
        existingUser.setEmail(userDetails.getEmail());
        // 儲存更新後的資料
        User updatedUser = userService.saveUser(existingUser);
        return ResponseEntity.ok(updatedUser);  // 200 OK
    }

}