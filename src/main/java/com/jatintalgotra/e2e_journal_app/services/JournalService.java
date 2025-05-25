package com.jatintalgotra.e2e_journal_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jatintalgotra.e2e_journal_app.dto.JournalDTO;
import com.jatintalgotra.e2e_journal_app.exceptions.ContentNotFound;
import com.jatintalgotra.e2e_journal_app.models.JournalEntry;
import com.jatintalgotra.e2e_journal_app.models.User;
import com.jatintalgotra.e2e_journal_app.repositories.JournalRepo;

import jakarta.transaction.Transactional;

@Service
public class JournalService {
    @Autowired
    private JournalRepo jRepo;

    // connected j service to u service instead of adding to j controller.
    @Autowired
    private UserService uService;
    
    // get all method
    public List<JournalDTO> getAllEntriesOfUser(String userName){
        User user = uService.getUserByUsername(userName);
        
        return JournalDTO.mapList(jRepo.findAllByUserId(user.getId()));
    }


    // get one by id
    public JournalDTO getEntryById(Long id){
        JournalEntry existing = jRepo.findById(id)
                                .orElseThrow(()-> new ContentNotFound("no entry found"));
        return new JournalDTO(existing);
    }

    // post mapping - new creating method
    @Transactional
    public JournalDTO addEntryForUser(JournalEntry entry, String userName){
        // handle direct entities only in service layer, not in controller
        User user = uService.getUserByUsername(userName);
        user.getJournals().add(entry);
        entry.setUser(user);
        return new JournalDTO(jRepo.save(entry));
    }

    // update (put mapping)
    @Transactional
    public JournalDTO updateEntry(Long id, JournalEntry newEntry){
        JournalEntry existing = jRepo.findById(id)
                                        .orElseThrow(() -> new ContentNotFound("no entry found"));
        existing.setContent(newEntry.getContent());
        existing.setTitle(newEntry.getTitle());
        return new JournalDTO(jRepo.save(existing)) ;
    }
    
    // deleting method
    public void deleteEntryById(Long id){
        if(jRepo.existsById(id)){
            jRepo.deleteById(id);;
        }
        else throw new ContentNotFound("no entry found");
    }

}
