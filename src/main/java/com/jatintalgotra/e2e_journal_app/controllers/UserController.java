package com.jatintalgotra.e2e_journal_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jatintalgotra.e2e_journal_app.dto.UserDTO;
import com.jatintalgotra.e2e_journal_app.models.User;
import com.jatintalgotra.e2e_journal_app.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService uService;

    @GetMapping   // 200 ok by default.
    public List<UserDTO> getAll(){
        return uService.getAllUsers();
    }

    // another one for email
    @GetMapping("/{userName}")
    public UserDTO getByUsername(@PathVariable String userName){
        return uService.getUserDTOByUsername(userName);
    }
    
    @PostMapping   // code 201 - created. spring automatically handles 400 bad request.
    public ResponseEntity<UserDTO> postNewEntry(@RequestBody User newUser) {
        return new ResponseEntity<>(uService.addUser(newUser), HttpStatus.CREATED);
    }

    @PutMapping("/{userName}")  // code 200 by default. 404 handled by exceptions
    public UserDTO putEntry(@PathVariable String userName, @RequestBody User newUser) {
        return uService.updateUser(userName, newUser);
    }

    @DeleteMapping("/{userName}")  // 204 no content. 404 handled by exception
    public ResponseEntity<?> deleteByUsername(@PathVariable String userName){
        
        uService.deleteUser(userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
