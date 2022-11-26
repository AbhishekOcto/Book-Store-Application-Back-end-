package com.bridgelabz.UserBookStore.service;

import com.bridgelabz.UserBookStore.dto.UserDTO;
import com.bridgelabz.UserBookStore.entity.User;
import com.bridgelabz.UserBookStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public User saveData(UserDTO userDTO) {
        User user = new User(userDTO);
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getAllData() {
        List<User> result = userRepository.findAll();
        return result;
    }

    @Override
    public Optional<User> getById(long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    @Override
    public void deleteUserData(long id) {

        userRepository.deleteById(id);
    }
}
