package com.jatintalgotra.e2e_journal_app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jatintalgotra.e2e_journal_app.models.User;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String Email);
    void deleteByUsername(String uname);


}
