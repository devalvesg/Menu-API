package com.alvesdev.Cardapio.Repository;

import com.alvesdev.Cardapio.Entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
