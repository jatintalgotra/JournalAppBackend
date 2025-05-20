package com.jatintalgotra.e2e_journal_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.jatintalgotra.e2e_journal_app.models.JournalEntry;
import com.jatintalgotra.e2e_journal_app.models.User;
import com.jatintalgotra.e2e_journal_app.services.JournalService;
import com.jatintalgotra.e2e_journal_app.services.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/api/journals")
public class JournalController {
    @Autowired
    private JournalService jService;
    
    @GetMapping("/{userName}")   // 200 ok by default.
    public List<JournalEntry> getAllEntriesOfUser(@PathVariable String userName){
        return jService.getAllEntriesOfUser(userName);
    }

    // @GetMapping("/{id}")  //code 200 ok by default. exception handles 404 not found
    // public JournalEntry getById(@PathVariable Long id) {
    //     return jService.getEntryById(id);
    // }
    
    @PostMapping("/{userName}")   // code 201 - created. spring automatically handles 400 bad request.
    public ResponseEntity<JournalEntry> postNewEntry(@RequestBody JournalEntry entry, @PathVariable String userName) {

        return new ResponseEntity<>(jService.addEntryForUser(entry, userName), HttpStatus.CREATED);
    }

    // @PutMapping("/{id}")  // code 200 by default. 404 handled by exceptions
    // public JournalEntry putEntry(@PathVariable Long id, @RequestBody JournalEntry entry) {
    //     return jService.updateEntry(id, entry);
    // }

    // @DeleteMapping("/{id}")  // 204 no content. 404 handled by exception
    // public ResponseEntity<?> deleteById(@PathVariable Long id){
    //     jService.deleteEntryById(id);
    //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }
}
