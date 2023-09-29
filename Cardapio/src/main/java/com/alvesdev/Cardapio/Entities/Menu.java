package com.alvesdev.Cardapio.Entities;

import com.alvesdev.Cardapio.DTO.MenuRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity(name = "products")
public class Menu {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;
    private String name;
    private String description;
    private Double price;


    public Menu(){

    }

    public Menu(Long number, String name, String description, Double price) {
        this.number = number;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Menu(MenuRequestDTO body) {
        this.name = body.getName();
        this.description = body.getDescription();
        this.price = body.getPrice();
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(number, menu.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
