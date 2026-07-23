package com.example.demo.model;

/**
 * 使用者資料模型（Model）
 * 對應資料庫中的使用者表格（暫時用記憶體模擬）
 */
public class User{
    private String id;
    private String name;
    private String email;

    // 建構子（Constructor）
    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // ==========================================
    // Getters 和 Setters（使用 IDEA 可 Alt+Insert 快速生成）
    // ==========================================
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}



