package com.alvesdev.Cardapio.DTO.AuthDTO;

import com.alvesdev.Cardapio.Entities.AuthUsers.User;
import com.alvesdev.Cardapio.Entities.AuthUsers.UserRole;

public class RegisterDTO {
    private String login;
    private String password;

    private UserRole role;

    public RegisterDTO(){
    }

    public RegisterDTO(User user){
        login = user.getLogin();
        password = user.getPassword();
        role = user.getRole();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }
}
