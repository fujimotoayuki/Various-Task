package com.example.varioustask.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class User {
    private int userId;             // ユーザーID
    private String username;        // ユーザー名
    private String email;           // メールアドレス
    private String password;        // パスワード
    private LocalDateTime createdAt;// 作成日時
    private LocalDateTime updatedAt;// 更新日時
}
