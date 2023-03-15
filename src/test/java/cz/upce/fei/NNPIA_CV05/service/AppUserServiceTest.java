package cz.upce.fei.NNPIA_CV05.service;

import cz.upce.fei.NNPIA_CV05.Example;
import cz.upce.fei.NNPIA_CV05.domain.AppUser;
import cz.upce.fei.NNPIA_CV05.repository.AppUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AppUserServiceTest {
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private AppUserRepository appUserRepository;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
        appUserRepository.deleteAll();
    }

    @Test
    void findAllByActiveEquals() {
    }

    //@Test(expected = ResourceNotFoundException.class)
    @Test
    void findById() throws ResourceNotFoundException {
        var expected = appUserRepository.save(Example.EXISTING_USER);
        var actual = appUserService.findById(100L);
        assertEquals(expected,actual);
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}