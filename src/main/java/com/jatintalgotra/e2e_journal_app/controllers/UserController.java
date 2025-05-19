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

import com.jatintalgotra.e2e_journal_app.models.User;
import com.jatintalgotra.e2e_journal_app.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService uService;

    @GetMapping   // 200 ok by default.
    public List<User> getAll(){
        return uService.getAllUsers();
    }

    @GetMapping("/id/{id}")  //code 200 ok by default. exception handles 404 not found
    public User getById(@PathVariable Long id) {
        return uService.getUserById(id);
    }

    // another one for email
    @GetMapping("/{email}")
    public User getByEmail(@PathVariable String email){
        return uService.getUserByEmail(email);
    }
    
    @PostMapping   // code 201 - created. spring automatically handles 400 bad request.
    public ResponseEntity<User> postNewEntry(@RequestBody User newUser) {
        return new ResponseEntity<>(uService.addEntry(newUser), HttpStatus.CREATED);
    }

    @PutMapping("/{email}")  // code 200 by default. 404 handled by exceptions
    public User putEntry(@PathVariable String email, @RequestBody User newUser) {
        return uService.updateEntry(email, newUser);
    }

    @DeleteMapping("/id/{id}")  // 204 no content. 404 handled by exception
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        uService.deleteId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{email}")  // 204 no content. 404 handled by exception
    public ResponseEntity<?> deleteById(@PathVariable String email){
        User existing = uService.getUserByEmail(email);
        uService.deleteId(existing.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
