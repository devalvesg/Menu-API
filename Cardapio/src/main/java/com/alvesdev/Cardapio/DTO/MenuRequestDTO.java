package com.alvesdev.Cardapio.DTO;

import com.alvesdev.Cardapio.Entities.Menu;

public class MenuRequestDTO {
    private String name;
    private String description;
    private Double price;

    public MenuRequestDTO(){

    }

    public MenuRequestDTO(Menu menu) {
        name = menu.getName();
        description = menu.getDescription();
        price = menu.getPrice();
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
