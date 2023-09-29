package com.alvesdev.Cardapio.Repository.AuthRepository;

import com.alvesdev.Cardapio.Entities.AuthUsers.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByLogin(String login);

    @Query(nativeQuery = true, value = """
		SELECT * FROM users
		WHERE login = :login
			""")
    User findByLoginUser(String login);


}
