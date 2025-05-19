package com.jatintalgotra.e2e_journal_app.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String displayName;

    @Column(nullable = false)
    private String password;

    // fetchtype by default lazy becuse JPA assume many side to be bulky (collections)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) 
    //cascade on the one side since only if the one is deleted, all the many are alse deleted
    private List<JournalEntry> journals;
}
