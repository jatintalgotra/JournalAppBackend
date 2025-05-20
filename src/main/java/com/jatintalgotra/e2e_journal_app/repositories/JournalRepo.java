package com.jatintalgotra.e2e_journal_app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jatintalgotra.e2e_journal_app.models.JournalEntry;

public interface JournalRepo extends JpaRepository<JournalEntry, Long> {
    List<JournalEntry> findAllByUserId(Long id);
}
