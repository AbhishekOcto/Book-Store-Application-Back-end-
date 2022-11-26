package com.bridgelabz.UserBookStore.controller;

import com.bridgelabz.UserBookStore.dto.ResponseDTO;
import com.bridgelabz.UserBookStore.dto.UserDTO;
import com.bridgelabz.UserBookStore.entity.User;
import com.bridgelabz.UserBookStore.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService service;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> insertUser(@RequestBody UserDTO userDTO){
        User response = service.saveData(userDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data saved successfully", response);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO> getAllUser(){
        List<User> response = service.getAllData();
        ResponseDTO responseDTO = new ResponseDTO("List of all users: ", response);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getUserById(@PathVariable long id){
        Optional<User> response = service.getById(id);
        ResponseDTO responseDTO = new ResponseDTO("Following user is", response);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteUserData(@PathVariable long id){
        service.deleteUserData(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", "Deleted id: " +id);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
