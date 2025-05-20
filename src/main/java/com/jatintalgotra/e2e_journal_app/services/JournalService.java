package com.jatintalgotra.e2e_journal_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.jatintalgotra.e2e_journal_app.exceptions.ContentNotFound;
import com.jatintalgotra.e2e_journal_app.models.JournalEntry;
import com.jatintalgotra.e2e_journal_app.models.User;
import com.jatintalgotra.e2e_journal_app.repositories.JournalRepo;

@Service
public class JournalService {
    @Autowired
    private JournalRepo jRepo;

    @Autowired
    private UserService uService;
    
    // get all method
    public List<JournalEntry> getAllEntriesOfUser(String userName){
        User user = uService.getUserByUsername(userName);
        return jRepo.findAllByUserId(user.getId());
    }

    // get one by id
    // public JournalEntry getEntryById(Long id){
    //     JournalEntry existing = jRepo.findById(id)
    //                             .orElseThrow(() -> new ContentNotFound("no entry found"));
    //     return existing;
    // }

    // creating method (post)
    public JournalEntry addEntryForUser(JournalEntry entry, String userName){
        User user = uService.getUserByUsername(userName);
        user.getJournals().add(entry);
        entry.setUser(user);
        return jRepo.save(entry);
    }

    // update (put mapping)
    // public JournalEntry updateEntry(Long id, JournalEntry newEntry){
    //     JournalEntry existing = jRepo.findById(id)
    //                                     .orElseThrow(() -> new ContentNotFound("no entry found"));
    //     existing.setContent(newEntry.getContent());
    //     existing.setTitle(newEntry.getTitle());
    //     return jRepo.save(existing);
    // }
    
    // // deleting method
    // public void deleteEntryById(Long id){
    //     if(jRepo.existsById(id)){
    //         jRepo.deleteById(id);;
    //     }
    //     else throw new ContentNotFound("no entry found");
    // }

}
