package com.kapresoft.springboot.serializeimmutableobjects.dto.hierarchical;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
@JsonPropertyOrder({"username", "email", "firstName", "lastName"})
public class HierarchicalAccount extends BaseAccount {

    String firstName;
    String lastName;

    @Builder
    HierarchicalAccount(@JsonProperty("username") String username,
                        @JsonProperty("email") String email,
                        @JsonProperty("firstName") String firstName,
                        @JsonProperty("lastName") String lastName) {
        super(username, email);

        this.firstName = firstName;
        this.lastName = lastName;
    }

}
