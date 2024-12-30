package com.example.varioustask.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class TaskRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //アカウントを追加
    public void insertUser(String username,String email,String password){
        String sql = "insert into users(username,email,password_hash) values(?,?,?)";
        jdbcTemplate.update(sql,username,email,password);
    }

    //チーム作成
    public void createTeam(String teamname,String password){
        String sql = "insert into teams(team_name,team_password) values(?,?)";
        jdbcTemplate.update(sql,teamname,password);
    }

    //チーム名からパスワードを取得する
    public String passwordByTeamname(String name){
        String sql = "select team_password from teams where team_name = ?";
        return jdbcTemplate.queryForObject(sql,String.class, name);
    }
    
    //チーム名からIdを取得する
    public Integer idByTeamname(String name){
        String sql = "select team_id from teams where team_name = ?";
        return jdbcTemplate.queryForObject(sql,Integer.class,name);
    }

    //チームに参加
    public void joinTeam(int teamid,int userid,int role){
        String sql = "insert into team_members(team_id,user_id,role) values(?,?,?)";
        jdbcTemplate.update(sql,teamid,userid,role);
    }
}
