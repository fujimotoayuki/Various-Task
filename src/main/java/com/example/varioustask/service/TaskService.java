package com.example.varioustask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.varioustask.form.InsertUser;
import com.example.varioustask.model.Teams;
import com.example.varioustask.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //アカウント作成
    public void insertUser(InsertUser insertuser){
        try{
            String hashedPassword = passwordEncoder.encode(insertuser.getPassword());
            taskRepository.insertUser(insertuser.getUsername(),insertuser.getEmail(), hashedPassword);
        }catch(DuplicateKeyException e){
            throw new IllegalArgumentException("このユーザー名またはメールアドレスはすでに使用されています。");
        }
    }

    //チーム作成
    public void createTeam(Teams team){
        try{
            String hashedPassword = passwordEncoder.encode(team.getTeamPassword());
            taskRepository.createTeam(team.getTeamName(),hashedPassword);
        }catch(DuplicateKeyException e){
            throw new IllegalArgumentException("このチーム名はすでに使用されています。");
        }
    }

    //チーム参加
    public void joinTeam(int userid,String teamname,String password){
        try{
            String teampassword = taskRepository.passwordByTeamname(teamname);
            boolean passwordMatch = passwordEncoder.matches(password, teampassword);
            if (!passwordMatch) {
                throw new IllegalArgumentException("パスワードが一致しません。");
            }
            int teamid = taskRepository.idByTeamname(teamname);
            taskRepository.joinTeam(teamid,userid,2);
        }catch(EmptyResultDataAccessException e){
            throw new IllegalArgumentException("このチーム名が存在しません。");
        }
    }
}
