package com.example.varioustask.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TaskMemo {
    private int memoId;             // メモID
    private int teamId;             // チームID
    private int createdBy;          // 作成者のユーザーID
    private int visibility;         // 表示設定 (1: 全員, 2: 自分のみ)
    private String memo;            // メモ内容
    private LocalDateTime createdAt;// 作成日時
}