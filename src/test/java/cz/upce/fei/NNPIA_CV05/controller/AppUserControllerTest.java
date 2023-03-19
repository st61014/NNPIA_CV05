package cz.upce.fei.NNPIA_CV05.controller;

import cz.upce.fei.NNPIA_CV05.Example;
import cz.upce.fei.NNPIA_CV05.domain.AppUser;
import cz.upce.fei.NNPIA_CV05.repository.AppUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:applications.yml")
class AppUserControllerTest {
    @LocalServerPort
    private int randomPort;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private MockMvc mockMvc;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {appUserRepository.deleteAll();}

    @Test
    void findUserByIDCode200() throws Exception {
        AppUser user = appUserRepository.save(Example.EXISTING_USER);
        mockMvc.perform(MockMvcRequestBuilders.get("localhost:" + randomPort + "/app-user/" + user.getUserID()))
                .andDo(print()).
                andExpect(status().isOk());
    }
    @Test
    void findUserByIDCode404() throws Exception {
        AppUser user = appUserRepository.save(Example.EXISTING_USER);
        mockMvc.perform(MockMvcRequestBuilders.get("localhost:" + randomPort + "/app-user/" + user.getUserID()))
                .andDo(print()).
                andExpect(status().isNotFound());
    }
}