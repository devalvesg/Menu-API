package com.alvesdev.Cardapio.DTO.AuthDTO;

import com.alvesdev.Cardapio.Entities.AuthUsers.User;
import com.alvesdev.Cardapio.Entities.AuthUsers.UserRole;

public class LoginResponseDTO {
    private String token;
    private UserRole role;
    public LoginResponseDTO(){

    }

    public LoginResponseDTO(String token, UserRole role){
        this.token = token;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public UserRole getRole() {
        return role;
    }
}
