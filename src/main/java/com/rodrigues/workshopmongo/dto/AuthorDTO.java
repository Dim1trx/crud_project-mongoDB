package com.rodrigues.workshopmongo.dto;

import com.rodrigues.workshopmongo.domain.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {
    private String id, name;


    public AuthorDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public AuthorDTO(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
