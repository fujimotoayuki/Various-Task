package com.example.varioustask.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Task {
    private int taskId;             // タスクID
    private String taskName;        // タスク名
    private String description;     // 詳細説明
    private int assignedTo;         // 割り当て先のユーザーID
    private int createdBy;          // タスク作成者のユーザーID
    private int status;             // 状態 (1: 未着手, 2: 進行中, 3: 完了)
    private int priority;           // 優先度 (1: 低, 2: 中, 3: 高)
    private LocalDateTime dueDate;  // 締切日
    private LocalDateTime createdAt;// 作成日時
    private LocalDateTime updatedAt;// 更新日時
}