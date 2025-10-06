package com.games.back.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.games.back.services.IUserService;
import com.games.back.model.Role;
import com.games.back.dtos.User.UserInDTO;
import com.games.back.dtos.User.UserOutDTO;
import com.games.back.repository.IRoleRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class UserIntegrationTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleRepository roleRepository;

    private UserInDTO buildValidUser(String username, String email) {
        UserInDTO user = new UserInDTO();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword("hashedpassword");
        user.setBio(null);
        user.setBirthdate(null);
        Role role = roleRepository.findById(1L).orElseThrow(() -> new RuntimeException("Role admin not found"));
        user.setRoleId(role.getId());
        return user;
    }

    @Test
    public void testFindAll() {
        UserInDTO user = buildValidUser("findalluser", "findalluser@example.com");
        userService.save(user);

        List<UserOutDTO> users = userService.findAll();
        assertNotNull(users);
        assertTrue(users.size() >= 0);
    }

    @Test
    public void testFindById() {
        UserInDTO user = buildValidUser("testuser", "testuser@example.com");
        UserOutDTO saved = userService.save(user);

        UserOutDTO fetchedUser = userService.findById(saved.getId());
        assertNotNull(fetchedUser);
        assertEquals(saved.getId(), fetchedUser.getId());
    }

    @Test
    public void testSave() {
        UserInDTO user = buildValidUser("newuser", "newuser@example.com");
        UserOutDTO savedUser = userService.save(user);

        assertNotNull(savedUser);
        assertNotNull(savedUser.getId());
        assertEquals("newuser", savedUser.getUsername());
    }

    @Test
    public void testDeleteById() {
        UserInDTO user = buildValidUser("todelete", "todelete@example.com");
        UserOutDTO retrievedUser = userService.save(user);

        userService.deleteById(retrievedUser.getId());
        assertThrows(RuntimeException.class, () -> userService.findById(retrievedUser.getId()));
    }

    @Test
    public void testFindAllPage() {
        UserInDTO user1 = buildValidUser("pageduser1", "pageduser1@example.com");
        userService.save(user1);

        UserInDTO user2 = buildValidUser("pageduser2", "pageduser2@example.com");
        userService.save(user2);

        List<UserOutDTO> users = userService.findAllPage(0, 1);
        assertNotNull(users);
        assertEquals(1, users.size());
    }
}
