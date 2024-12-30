package com.example.varioustask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.varioustask.form.InsertUser;
import com.example.varioustask.model.Teams;
import com.example.varioustask.service.TaskService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class TaskUserController {
    
    @Autowired
    private TaskService taskService;

     @GetMapping
    public String showAccountPage() {
        //cookieを確認？
        return "userpage";
    }

    //アカウント作成ページの表示
    @GetMapping("/createaccount")
    public String insertUserPage(){
        return "insertuser";
    }

    //アカウント作成
    @PostMapping("/createaccount")
    public String insertUser(@ModelAttribute InsertUser insertUser,Model model,HttpSession session){
        try{
            taskService.insertUser(insertUser);
            model.addAttribute("clear", "登録しました");
        }catch(IllegalArgumentException e){
            model.addAttribute("error",e.getMessage());
        }
        return "insertuser";
    }

    //チーム作成ページを表示
    @GetMapping("/createteam")
    public String createAccountPage(){
        return "createteam";
    }

    //チーム作成
    @PostMapping("/createteam")
    public String createTeam(@ModelAttribute Teams team,Model model,HttpSession session){
        try{
            taskService.createTeam(team);
            model.addAttribute("clear", "登録しました");
        }catch(IllegalArgumentException e){
            model.addAttribute("error",e.getMessage());
        }
        return "createteam";
    }
    
    //チーム参加ページ
    @GetMapping("/jointeam")
    public String joinTeamPage(){
        return "jointeam";
    }
    
    //チーム参加
    @PostMapping("/jointeam")
    public String joinTeam(@RequestParam String teamname,@RequestParam String password,HttpSession session,Model model){
        try{
             int userid=2;
            taskService.joinTeam(userid, teamname, password);
        }catch(EmptyResultDataAccessException e){
            model.addAttribute("error",e.getMessage());
        }catch(IllegalArgumentException e){
            model.addAttribute("error",e.getMessage());
        }
        return "jointeam";
    }
}

