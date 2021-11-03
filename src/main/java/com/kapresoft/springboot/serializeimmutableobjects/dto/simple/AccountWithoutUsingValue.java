package com.kapresoft.springboot.serializeimmutableobjects.dto.simple;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@ToString
@EqualsAndHashCode
@FieldDefaults(makeFinal=true, level= AccessLevel.PRIVATE)
@JsonPropertyOrder({"username", "email", "firstName", "lastName"})
public class AccountWithoutUsingValue {

    String username;
    String email;
    String firstName;
    String lastName;

    @Builder
    public AccountWithoutUsingValue(@JsonProperty("username") String username,
                                    @JsonProperty("email") String email,
                                    @JsonProperty("firstName") String firstName,
                                    @JsonProperty("lastName") String lastName) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
