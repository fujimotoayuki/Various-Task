package com.example.varioustask.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TaskComment {
    private int commentId;          // コメントID
    private int taskId;             // タスクID
    private int commentedBy;        // コメントしたユーザーID
    private String comment;         // コメント内容
    private LocalDateTime createdAt;// 作成日時
}
