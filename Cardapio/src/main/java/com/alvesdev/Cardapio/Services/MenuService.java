package com.alvesdev.Cardapio.Services;

import com.alvesdev.Cardapio.DTO.MenuUpdateDTO;
import com.alvesdev.Cardapio.Entities.Menu;
import com.alvesdev.Cardapio.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getAll(){
        List<Menu> cardapio = menuRepository.findAll();
        return cardapio;
    }

    public void newProduct(Menu product) {
        menuRepository.save(product);
    }

    public void updateProduct(MenuUpdateDTO body) {
        Optional<Menu> menuToUpdate = menuRepository.findById(body.getNumber());
        Menu updateMenu = menuToUpdate.get();

        updateMenu.setDescription(body.getDescription());
        updateMenu.setPrice(body.getPrice());

        menuRepository.save(updateMenu);
    }
}
