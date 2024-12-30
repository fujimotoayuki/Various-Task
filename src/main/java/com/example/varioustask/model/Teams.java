package com.example.varioustask.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Teams {
    private int teamId;             // チームID
    private String teamName;        // チーム名
    private String teamPassword;    // チームパスワード
    private LocalDateTime createdAt;// 作成日時
    private LocalDateTime updatedAt;// 更新日時
}
