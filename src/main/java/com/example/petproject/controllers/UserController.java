package com.example.petproject.controllers;

import com.example.petproject.models.UserModel;
import com.example.petproject.repositorys.UserRep;
import com.example.petproject.servises.UserServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRep userRep;

    @GetMapping
    public String UserInformation(Authentication authentication, Model model){
        UserModel userAuth = userRep.findByUsername(authentication.getName());
        new UserServise().sendInfAboutUser(model, userAuth);
        return "UserInformation";
    }
}
