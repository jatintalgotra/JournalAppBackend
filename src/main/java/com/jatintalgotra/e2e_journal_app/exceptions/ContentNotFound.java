package com.jatintalgotra.e2e_journal_app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContentNotFound extends RuntimeException{
    public ContentNotFound (String message){
        super(message);
    }
}
