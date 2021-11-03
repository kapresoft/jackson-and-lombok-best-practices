package com.kapresoft.springboot.serializeimmutableobjects.dto.simple;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Value;

/**
 * Immutable Account using Lombok {@code @Value}.
 */
@Value
@JsonPropertyOrder({"username", "email", "firstName", "lastName"})
public class Account {

    String username;
    String email;
    String firstName;
    String lastName;

    @Builder
    public Account(@JsonProperty("username") String username,
                   @JsonProperty("email") String email,
                   @JsonProperty("firstName") String firstName,
                   @JsonProperty("lastName") String lastName) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
