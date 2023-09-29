package com.alvesdev.Cardapio.Controllers.AuthController;

import com.alvesdev.Cardapio.DTO.AuthDTO.AuthenticationDTO;
import com.alvesdev.Cardapio.DTO.AuthDTO.LoginResponseDTO;
import com.alvesdev.Cardapio.DTO.AuthDTO.RegisterDTO;
import com.alvesdev.Cardapio.Entities.AuthUsers.User;
import com.alvesdev.Cardapio.Entities.AuthUsers.UserRole;
import com.alvesdev.Cardapio.Infra.Security.TokenService;
import com.alvesdev.Cardapio.Repository.AuthRepository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("menu")
public class AuthenticationController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TokenService tokenService;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var userNamePassword = new UsernamePasswordAuthenticationToken(data.getLogin(), data.getPassword());
        var auth = authenticationManager.authenticate(userNamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        var roleUser = userRepository.findByLoginUser(data.getLogin());

        LoginResponseDTO loginResponse = new LoginResponseDTO(token, roleUser.getRole());
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(userRepository.findByLogin(data.getLogin()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
        UserRole userRole = data.getRole();
        if(data.getRole() == null){
            userRole = userRole.USER;
        }

        User newUser = new User(data.getLogin(), encryptedPassword, userRole);

        userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
