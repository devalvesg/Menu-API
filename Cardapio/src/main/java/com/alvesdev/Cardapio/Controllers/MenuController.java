package com.alvesdev.Cardapio.Controllers;

import com.alvesdev.Cardapio.DTO.MenuRequestDTO;
import com.alvesdev.Cardapio.DTO.MenuUpdateDTO;
import com.alvesdev.Cardapio.Entities.Menu;
import com.alvesdev.Cardapio.Services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping
    public ResponseEntity getAll(){
        List<Menu> cardapio = menuService.getAll();
        return ResponseEntity.ok(cardapio);
    }

    @PostMapping
    public ResponseEntity newProduct(@RequestBody MenuRequestDTO body) {
    Menu product = new Menu(body);
    menuService.newProduct(product);
    return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity updateProduct(@RequestBody MenuUpdateDTO body){
        menuService.updateProduct(body);
        return ResponseEntity.ok().build();
    }
}
