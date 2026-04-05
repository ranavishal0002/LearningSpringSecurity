package com.example.SpringSecurity.repository;

//import com.example.demo4.SecurityApp.entities.User;
import com.example.SpringSecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email); // jpql will take care of findByEmail it will generate the sql query by its own for this

}