package com.alvesdev.Cardapio.DTO;

import com.alvesdev.Cardapio.Entities.Menu;

public class MenuUpdateDTO {
    private Long number;
    private String description;
    private Double price;

    public MenuUpdateDTO(){

    }
    public MenuUpdateDTO(Menu menu) {
        number = menu.getNumber();
        description = menu.getDescription();
        price = menu.getPrice();
    }

    public Long getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }
}
