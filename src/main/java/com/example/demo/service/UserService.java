package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 使用者業務邏輯層（Service）
 * 職責：處理商業邏輯，呼叫 Repository 存取資料
 */
@Service  //標記為 Service 元件
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 新增或更新使用者
     * 使用內建的 save() 方法
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * 查詢所有使用者
     * 使用內建的 findAll() 方法
     */
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    /**
     * 根據 ID 查詢單筆使用者
     * 使用 findById()，它回傳 Optional
     * .orElse(null) 代表找不到則回傳 null
     */
    public User getUserById(String id){
        return userRepository.findById(id).orElse(null);
    }
    
    /**
     * 4. 根據 ID 刪除使用者
     * 使用內建的 deleteById() 方法
     */
    public void deleteUserById(String id){
        userRepository.deleteById(id);
    }
}