package com.jatintalgotra.e2e_journal_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jatintalgotra.e2e_journal_app.exceptions.UserNotFound;
import com.jatintalgotra.e2e_journal_app.models.User;
import com.jatintalgotra.e2e_journal_app.repositories.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo uRepo;

     // get all method
    public List<User> getAllUsers(){
        return uRepo.findAll();
    }

    // // get one by id
    // public User getUserById(Long id){
    //     User existing = uRepo.findById(id)
    //                             .orElseThrow(() -> new UserNotFound("no such user found"));
    //     return existing;
    // }

    // get by userName
    public User getUserByUsername(String userName){
        User existing = uRepo.findByUsername(userName)
                                .orElseThrow(()-> new UserNotFound("no such user"));
        return existing;
    }

    // creating method (post)
    public User addUser(User entry){
        return uRepo.save(entry);
    }

    // update (put mapping)
    public User updateUser(String userName, User newUser){
        User existing = uRepo.findByUsername(userName)
                                .orElseThrow(() -> new UserNotFound("no such user"));
        // existing.setDisplayName(newUser.getDisplayName());
        existing.setEmail(newUser.getEmail());
        existing.setUsername(newUser.getUsername());
        existing.setPassword(newUser.getPassword());
        return uRepo.save(existing);
    }
    
    // deleting method
    public void deleteId(Long id){
        if(uRepo.existsById(id)){
            uRepo.deleteById(id);;
        }
        else throw new UserNotFound("no such user found");
    }
}
