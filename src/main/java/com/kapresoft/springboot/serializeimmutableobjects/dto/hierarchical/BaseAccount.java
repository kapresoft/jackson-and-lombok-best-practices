package com.kapresoft.springboot.serializeimmutableobjects.dto.hierarchical;

import lombok.Getter;

@Getter
public abstract class BaseAccount {

    String username;
    String email;

    BaseAccount(String username, String email) {
        this.username = username;
        this.email = email;
    }

}
