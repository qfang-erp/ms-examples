package com.qfang.examples.ms.product.core.service;

import com.qfang.examples.ms.product.api.model.User;
import com.qfang.examples.ms.product.core.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author: liaozhicheng.cn@163.com
 * @date: 2018-04-28
 * @since: 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listUser() {
        return userRepository.findAll();
    }

    public User findById(long id) {
        return this.userRepository.getOne(id);
    }

    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Transactional
    public boolean saveUser(User user) {
        this.userRepository.save(user);
        return true;
    }

    @Transactional
    public void updateUser(User user) {
        this.userRepository.save(user);
    }

    @Transactional
    public boolean deleteUser(long id) {
        this.userRepository.deleteById(id);
        return true;
    }

}
