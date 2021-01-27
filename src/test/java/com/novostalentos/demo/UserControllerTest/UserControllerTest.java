package com.novostalentos.demo.UserControllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.novostalentos.demo.EstudosApplication;
import com.novostalentos.demo.model.User;
import com.novostalentos.demo.resources.UserController;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.novostalentos.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= EstudosApplication.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    @Test
    public void deveCriarNovoUser() throws Exception {

        User userEsperado = new User();
        userEsperado.setId(1);
        userEsperado.setName("Ana");
        userEsperado.setIdade(22);
        userEsperado.setEmail("ana@cadmus.com.br");

        mockMvc.perform(MockMvcRequestBuilders.post("crud/save")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(userEsperado)))
                .andExpect(status().isCreated());


    }

}