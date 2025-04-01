package com.example.schedule;

import com.example.schedule.user.dto.RequestUserDto;
import com.example.schedule.user.entity.User;
import com.example.schedule.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User admin;

    @BeforeEach
    public void setUp() {
        admin = userRepository.save(new User("adminUser@example.com","Pw123"));
    }

    @Test
    @DisplayName("설정된 이름")
    public void screenUser() {
        System.out.println("admin = " + admin.getEmail());
        assertEquals("adminUser@example.com", admin.getEmail());
    }

    @Test
    @DisplayName("변경된 이름")
    public void updateUser() {
        RequestUserDto testUser = new RequestUserDto(
                "testName",
                "newAdminUser@example.com",
                "newPw123"
        );

        admin.update(testUser);
        User testAdmin = userRepository.save(admin);
        System.out.println("testAdmin = " + admin.getEmail());
        assertEquals(admin.getEmail(), testAdmin.getEmail());
    }
}
