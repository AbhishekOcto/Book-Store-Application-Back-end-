package com.bridgelabz.UserBookStore.service;

import com.bridgelabz.UserBookStore.dto.UserDTO;
import com.bridgelabz.UserBookStore.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User saveData(UserDTO userDTO);

    List<User> getAllData();

    Optional<User> getById(long id);

    void deleteUserData(long id);

}
