package com.example.ex3_2_back.service;

/**
 * @author hyxzjbnb
 * @create 2024-06-03-15:32
 */
import com.example.ex3_2_back.domain.user.UserSearchDomain;
import com.example.ex3_2_back.entity.User;
import com.example.ex3_2_back.entity.User;
import com.example.ex3_2_back.exception.ResourceNotExistException;
import com.example.ex3_2_back.repository.UserRepository;
import com.example.ex3_2_back.utils.UpdateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.ex3_2_back.entity.User;

import java.util.ArrayList;
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

//    // 查询所有用户
//    public List<User> findAllUsers() {
//        try {
//            return userRepository.findAll();
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to retrieve all users: " + e.getMessage(), e);
//        }
//    }
//
//    // 根据名字查询单个用户
//    public User findUserByName(String name) {
//        try {
//            Optional<User> user = userRepository.findByUserName(name);
//            if (user.isPresent()) {
//                return user.get();
//            } else {
//                throw new RuntimeException("User not found with name: " + name);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to retrieve user by name: " + e.getMessage(), e);
//        }
//    }

    /**
     * 查询所有用户
     */
    public Page<User> getAllUser(Pageable pageable) {
        return userRepository.findByRemoveIsFalse(pageable);
    }

    /**
     * 根据用户姓名模糊查询
     */
    public Page<User> getUserByUsername(String username, Pageable pageable) {
        return userRepository.findByUserNameLike("%" + username + "%", pageable);
    }

    /**
     * 根据id查询用户信息
     */
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    /**
     * 添加用户信息,并返回id
     */
    public Integer addUser(User user) {
        Optional<User> userByUserName = userRepository.findByUserName(user.getUserName());
        if (userByUserName.isPresent()) {
            throw new ResourceNotExistException("用户名已存在");
        }
        User user1 = userRepository.save(user);
        return user1.getId();
    }

//    // 创建用户
//    @Transactional
//    public void createUser(User user) {
//        try {
//            userRepository.save(user);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to create user: " + e.getMessage(), e);
//        }
//    }

//    // 根据名字删除用户
//    @Transactional
//    public void deleteUserByName(String name) {
//        if (!userRepository.existsByUserName(name)) {
//            throw new RuntimeException("No user found with name: " + name);
//        }
//        try {
//            userRepository.deleteByUserName(name);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to delete user by name: " + e.getMessage(), e);
//        }
//    }

    public User findUserById(Integer id) {
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

    /**
     * 删除用户信息
     */
    public void deleteUser(Integer id) {
        Optional<User> userBefore = userRepository.findById(id);
        if (userBefore.isPresent()) {
            User user = userBefore.get();
            user.setRemove(true);
            userRepository.save(user);
        } else {
            throw new ResourceNotExistException("用户不存在");
        }
    }

    /**
     * 根据username查询用户
     */
    public Optional<User> findUserByName(String name) {
        Optional<User> user = userRepository.findByUserName(name);
//        user = user.orElse(null);
//        if(user.isEmpty()) {
//            throw new ResourceNotExistException("用户不存在");
//        }
        return user;
    }

    /**
     * 修改志愿者信息
     */
    public void updateUser(User user) {
        Optional<User> userBefore = userRepository.findById(user.getId());
        if (userBefore.isPresent()) {
            User user1 = userBefore.get();
            UpdateUtil.copyNotNullProperties(user, user1);
            userRepository.save(user1);
        } else{
            throw new ResourceNotExistException("用户不存在");
        }
    }

    /**
     * 根据条件动态查询用户信息
     */
    public Page<User> searchUserDynamic(UserSearchDomain userSearchDomain, Pageable pageable) {
        Specification<User> queryCondition = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (userSearchDomain.getUserName() != null && !userSearchDomain.getUserName().isEmpty()) {
                    predicateList.add(criteriaBuilder.like(root.get("userName"), "%" + userSearchDomain.getUserName() + "%"));
                }
                if (userSearchDomain.getSex() != null && !userSearchDomain.getSex().isEmpty()) {
                    predicateList.add(criteriaBuilder.equal(root.get("sex"), userSearchDomain.getSex()));
                }
                if(userSearchDomain.getIsActive() != null) {
                    predicateList.add(criteriaBuilder.equal(root.get("isActive"), userSearchDomain.getIsActive()));
                }
                if(userSearchDomain.getRealName() != null && !userSearchDomain.getRealName().isEmpty()) {
                    predicateList.add(criteriaBuilder.like(root.get("realName"), "%" + userSearchDomain.getRealName() + "%"));
                }
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };

        return userRepository.findAll(queryCondition, pageable);
    }
}

