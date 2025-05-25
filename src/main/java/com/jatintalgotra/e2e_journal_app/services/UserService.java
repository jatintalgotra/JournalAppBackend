package com.jatintalgotra.e2e_journal_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jatintalgotra.e2e_journal_app.dto.UserDTO;
import com.jatintalgotra.e2e_journal_app.exceptions.UserNotFound;
import com.jatintalgotra.e2e_journal_app.models.User;
import com.jatintalgotra.e2e_journal_app.repositories.UserRepo;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepo uRepo;

     // get all method
    public List<UserDTO> getAllUsers(){
        return UserDTO.mapList(uRepo.findAll());
    }
    
    // get by userName
    // USER OBJECT  - INTERNAL USE
    public User getUserByUsername(String userName){
        User existing = uRepo.findByUsername(userName)
                                .orElseThrow(()-> new UserNotFound("no such user"));
        return existing;
    }
    // DTO FOR API REQUEST
    public UserDTO getUserDTOByUsername(String userName){
        User existing = uRepo.findByUsername(userName)
                                .orElseThrow(()-> new UserNotFound("no such user"));
        return new UserDTO(existing);
    }


    // creating method (post)
    @Transactional
    public UserDTO addUser(User entry){
        return new UserDTO(uRepo.save(entry));
    }


    // update (put mapping)
    @Transactional //need to add @EnableTransactionManagement in main class
    public UserDTO updateUser(String userName, User newUser){
        User existing = uRepo.findByUsername(userName)
                                .orElseThrow(() -> new UserNotFound("no such user"));
        // existing.setDisplayName(newUser.getDisplayName());
        existing.setEmail(newUser.getEmail());
        existing.setPassword(newUser.getPassword());
        return new UserDTO(uRepo.save(existing));
    }
    
    
    // deleting method
    public void deleteUser(String userName){
        User existing = uRepo.findByUsername(userName)
                                .orElseThrow(() -> new UserNotFound("no such user"));
        uRepo.delete(existing);
    }
}
