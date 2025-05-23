package com.jatintalgotra.e2e_journal_app.dto;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.jatintalgotra.e2e_journal_app.models.JournalEntry;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class JournalDTO {
    private Long entry_id;
    private Instant createdAt;
    private Instant lastUpdated;
    private String title;
    private String content;
    private Long userId;

    public JournalDTO(JournalEntry entry){
        this.entry_id = entry.getId();
        this.createdAt = entry.getCreatedAt();
        this.lastUpdated = entry.getLastUpdated();
        this.title = entry.getTitle();
        this.content = entry.getContent();
        this.userId = entry.getUser().getId();
    }

    public static List<JournalDTO> mapList (List<JournalEntry> entries){
        return entries.stream()
                    .map(JournalDTO::new)
                    .collect(Collectors.toList());
    }
}
