package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserName(String name);

    Optional<User> findByUserNameAndPassword(String name, String password);


    boolean existsByUserName(String name);

    Optional<User> findById(Long id);

    boolean existsByUserNameAndPassword(String name, String password);

    void deleteByUserName(String name);
}
