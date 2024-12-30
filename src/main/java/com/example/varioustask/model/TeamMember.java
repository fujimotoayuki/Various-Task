package com.example.varioustask.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TeamMember {
    private int teamId;             // チームID
    private int userId;             // ユーザーID
    private int role;               // 役割 (1: 管理者, 2: メンバー)
    private boolean approval;       // 承認済みかどうか
    private LocalDateTime createdAt;// 作成日時
}