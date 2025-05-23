package com.jatintalgotra.e2e_journal_app.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.jatintalgotra.e2e_journal_app.models.User;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDTO {
    private Long user_id;
    private String email;
    private String username;
    // private String password;
    // private List<JournalDTO> journals;
    private Long journalCount;

    public UserDTO(User user){
        this.user_id = user.getId();
        this.email = user.getEmail();
        this.username = user.getUsername();
        // this.password = user.getPassword();S
        // this.journals = JournalDTO.mapList(user.getJournals());
        this.journalCount = Long.valueOf(user.getJournals().size());
    }

    public static List<UserDTO> mapList(List<User> users) {
        return users.stream().map(UserDTO::new).collect(Collectors.toList());
    }
}
