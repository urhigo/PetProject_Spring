package com.example.petproject.controllers;

import com.example.petproject.models.UserModel;
import com.example.petproject.repositorys.UserRep;
import com.example.petproject.servises.UserServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    UserRep userRep;
    @Autowired
    PasswordEncoder passwordEncoder;


    @GetMapping
    public String registrationPage(){
        return "RegistrationPage";
    }

    @GetMapping("/Successful")
    public String registrationSuccessfulPage(){
        return "RegistrationSuccessful";
    }

    @PostMapping
    public RedirectView saveNewUser(
            @RequestParam String username, @RequestParam String password,
            @RequestParam String name, @RequestParam String surname,
            @RequestParam Integer age, @RequestParam Integer number
    ){
        UserModel user = userRep.findByUsername(username);
        if (user == null) {
            new UserServise().saveNewUser(username,password, name, surname, age, number, passwordEncoder, userRep);
            return new RedirectView("/registration/Successful");
        } else {
            return new RedirectView("/registration");
        }

    }
}
