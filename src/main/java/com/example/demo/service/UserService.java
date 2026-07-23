package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * 使用者業務邏輯層（Service）
 * 職責：處理商業邏輯，呼叫 Repository 存取資料
 */
@Service  // 1. 標記為 Service 元件
public class UserService {

    private final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 獲取使用者詳細資料
     * @param userId 使用者 ID
     * @return 使用者物件
     */
    public User getUserDetail(String userId) {
        // ==========================================
        // 商業邏輯：ID 格式化處理
        // ==========================================
        // 1. 去除前後空白
        // 2. 強制轉成大寫（確保與資料庫 KEY 一致）
        String formattedId = userId.trim().toUpperCase();
        
        // ==========================================
        // 呼叫 Repository 層取得資料
        // ==========================================
        User user = userRepository.findById(formattedId);
        
        // ==========================================
        // 商業邏輯：找不到時的特殊處理（可擴充）
        // ==========================================
        // 如果找不到人，可以在這裡記錄日誌或拋出例外
        
        return user;
    }
}