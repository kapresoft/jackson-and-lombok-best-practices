package com.kapresoft.springboot.serializeimmutableobjects.hierarchical;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kapresoft.springboot.serializeimmutableobjects.dto.hierarchical.HierarchicalAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HierarchicalAccountSerializationTest {

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
    void canSerializeHierarchicalAccount() throws JsonProcessingException {
        final HierarchicalAccount account = HierarchicalAccount.builder()
                .email("johndoe@gmail.com").username("johndoe")
                .firstName("John").lastName("Doe")
                .build();
        final String jsonText = mapper.writeValueAsString(account);
        final String expectedJSON = "{\"username\":\"johndoe\",\"email\":\"johndoe@gmail.com\",\"firstName\":\"John\",\"lastName\":\"Doe\"}";
        assertThat(jsonText).as("Expected Account JSON")
                .isEqualTo(expectedJSON);
    }

    @Test
    void canDeserializeHierarchicalAccount() throws JsonProcessingException {
        final HierarchicalAccount account = mapper.readValue(JSON, HierarchicalAccount.class);
        assertThat(account).as("Account")
                .isNotNull();
        assertThat(account.getUsername()).as("Username")
                .isEqualTo("kapre");
        assertThat(account.getEmail()).as("Email")
                .isEqualTo("kapre@kapresoft.com");
    }


}