package com.example.ex3_2_back.service;

/**
 * @author hyxzjbnb
 * @create 2024-06-03-15:32
 */
import com.example.ex3_2_back.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.ex3_2_back.entity.User;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    private UserRepository userRepository;
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 查询所有用户
    public List<User> findAllUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve all users: " + e.getMessage(), e);
        }
    }

    // 根据名字查询单个用户
    public User findUserByName(String name) {
        try {
            Optional<User> user = userRepository.findByUserName(name);
            if (user.isPresent()) {
                return user.get();
            } else {
                throw new RuntimeException("User not found with name: " + name);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve user by name: " + e.getMessage(), e);
        }
    }

    // 创建用户
    @Transactional
    public void createUser(User user) {
        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create user: " + e.getMessage(), e);
        }
    }

    // 根据名字删除用户
    @Transactional
    public void deleteUserByName(String name) {
        if (!userRepository.existsByUserName(name)) {
            throw new RuntimeException("No user found with name: " + name);
        }
        try {
            userRepository.deleteByUserName(name);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete user by name: " + e.getMessage(), e);
        }
    }

    public User findUserById(Long id) {
        try {
            Optional<User> user = userRepository.findById(id);
            if (user.isPresent()) {
                return user.get();
            } else {
                throw new RuntimeException("User not found with id: " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve user by id: " + e.getMessage(), e);
        }
    }
}

