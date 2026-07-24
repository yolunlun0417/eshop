package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 使用者業務邏輯層（Service）
 * 職責：處理商業邏輯，呼叫 Repository 存取資料
 */
@Service  // 1. 標記為 Service 元件
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }
    
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}