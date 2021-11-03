package com.kapresoft.springboot.serializeimmutableobjects.simple;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kapresoft.springboot.serializeimmutableobjects.dto.simple.Account;
import com.kapresoft.springboot.serializeimmutableobjects.dto.simple.AccountWithoutUsingValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AccountSerializationTest {

    public static final String JSON = "{\n" +
            "  \"username\": \"kapre\",\n" +
            "  \"email\": \"kapre@kapresoft.com\",\n" +
            "  \"firstName\": \"Kapre\",\n" +
            "  \"lastName\": \"Agta\"\n" +
            "}";
    private ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
    }

    @Test
    void canSerializeAccount() throws JsonProcessingException {
        final Account account = Account.builder()
                .email("johndoe@gmail.com").username("johndoe")
                .firstName("John").lastName("Doe")
                .build();
        final String jsonText = mapper.writeValueAsString(account);
        final String expectedJSON = "{\"username\":\"johndoe\",\"email\":\"johndoe@gmail.com\",\"firstName\":\"John\",\"lastName\":\"Doe\"}";
        assertThat(jsonText).as("Expected Account JSON")
                .isEqualTo(expectedJSON);
    }

    @Test
    void canDeserializeAccountJSON() throws JsonProcessingException {
        final Account account = mapper.readValue(JSON, Account.class);
        assertThat(account).as("Account")
                .isNotNull();
        assertThat(account.getUsername()).as("Username")
                .isEqualTo("kapre");
        assertThat(account.getEmail()).as("Email")
                .isEqualTo("kapre@kapresoft.com");
    }

    @Test
    void canSerializeAccount_WithoutUsingValue() throws JsonProcessingException {
        final AccountWithoutUsingValue account = AccountWithoutUsingValue.builder()
                .email("johndoe@gmail.com").username("johndoe")
                .firstName("John").lastName("Doe")
                .build();
        final String jsonText = mapper.writeValueAsString(account);
        final String expectedJSON = "{\"username\":\"johndoe\",\"email\":\"johndoe@gmail.com\",\"firstName\":\"John\",\"lastName\":\"Doe\"}";
        assertThat(jsonText).as("Expected Account JSON")
                .isEqualTo(expectedJSON);
    }

    @Test
    void canDeserializeAccountJSON_WithoutUsingValue() throws JsonProcessingException {
        final AccountWithoutUsingValue account = mapper.readValue(JSON, AccountWithoutUsingValue.class);
        assertThat(account).as("Account")
                .isNotNull();
        assertThat(account.getUsername()).as("Username")
                .isEqualTo("kapre");
        assertThat(account.getEmail()).as("Email")
                .isEqualTo("kapre@kapresoft.com");
    }

}