package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用者資料存取層（Repository）
 * 職責：負責與資料來源溝通
 */
@Repository  // 1. 告訴 Spring，請把這個類別實例化為一個 Bean 放入容器中
public class UserRepository {
    
    // 模擬記憶體資料庫（使用 Map 儲存）
    private static final Map<String, User> userDatabase = new HashMap<>();

    // 使用靜態區塊初始化假資料
    static {
        userDatabase.put("U001", new User("U001", "張小明", "ming@example.com"));
        userDatabase.put("U002", new User("U002", "李四", "four@example.com"));
        userDatabase.put("U003", new User("U003", "王美美", "meimei@example.com"));
    }

    /**
     * 依據 ID 查詢使用者
     * @param id 使用者編號
     * @return 找到的使用者物件，找不到回傳 null
     */
    public User findById(String id) {
        return userDatabase.get(id);
    }
}