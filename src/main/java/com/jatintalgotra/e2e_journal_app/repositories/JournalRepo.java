package com.jatintalgotra.e2e_journal_app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jatintalgotra.e2e_journal_app.models.JournalEntry;

public interface JournalRepo extends JpaRepository<JournalEntry, Long> {
    List<JournalEntry> findAllByUserId(Long id);

    @Query("SELECT COUNT(j) FROM JournalEntry j WHERE j.user.id = :userId")
    Long countJournalsByUserId(@Param("userId") Long userId);

    @Query("SELECT j.id FROM JournalEntry j WHERE j.user.id = :userId")
    List<Long> findJournalIdsByUserId(@Param("userId") Long userId);
}
