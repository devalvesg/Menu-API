package com.alvesdev.Cardapio.DTO.AuthDTO;

import com.alvesdev.Cardapio.Entities.AuthUsers.User;

public class AuthenticationDTO {
    private String login;
    private String password;

    public AuthenticationDTO(){
    }

    public AuthenticationDTO(User user){
        login = user.getLogin();
        password = user.getPassword();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
