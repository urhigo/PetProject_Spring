package com.example.petproject.servises;

import com.example.petproject.models.UserModel;
import com.example.petproject.repositorys.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class UserServise {

    public void saveNewUser(String username, String password, String name,
                            String surname, Integer age, Integer number, PasswordEncoder passwordEncoder,
                            UserRep userRep) {
        UserModel newUser = new UserModel();

        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password));
        newUser.setName(name);
        newUser.setSurname(surname);
        newUser.setAge(age);
        newUser.setNumber(number);
        newUser.setRole("User");
        userRep.save(newUser);
    }

    public void sendInfAboutUser(Model model, UserModel user){
        model.addAttribute("item", user);
    }
}
