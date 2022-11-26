package com.bridgelabz.UserBookStore.entity;

import com.bridgelabz.UserBookStore.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private LocalDate registeredDate;
    private LocalDate updatedDate;
    private String emailId;
    private String password;

    public User(UserDTO userDTO) {
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.dob = userDTO.getDob();
        this.registeredDate = userDTO.getRegisteredDate();
        this.updatedDate = userDTO.getUpdatedDate();
        this.emailId = userDTO.getEmailId();
        this.password = userDTO.getPassword();
    }

}
