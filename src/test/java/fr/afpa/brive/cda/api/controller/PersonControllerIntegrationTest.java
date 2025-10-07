package fr.afpa.brive.cda.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.afpa.brive.cda.api.model.Person;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getPersonTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/persons"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath(
                        "$[0].firstname",
                        CoreMatchers.is("Otto")
                ));
    }

    @Test
    public void createPersonTest() throws Exception {
        Person person = new Person();
        person.setFirstname("Otto");
        person.setLastname("Test");


        String personJson = objectMapper.writeValueAsString(person);
        mockMvc.perform(MockMvcRequestBuilders.post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(personJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath(
                        "$.firstname",
                        CoreMatchers.is("Otto")
                ));
    }
}
