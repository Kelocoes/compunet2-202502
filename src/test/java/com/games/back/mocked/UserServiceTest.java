package com.games.back.mocked;

import com.games.back.model.User;
import com.games.back.model.Role;
import com.games.back.repository.IUserRepository;
import com.games.back.services.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class UserServiceTest {

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;
    private User savedUser;
    private Role role;

    // BeforeAll if needed
    @BeforeEach
    public void setUp() {
        role = new Role();
        role.setId(1L);
        role.setName("ADMIN");

        user = new User();
        user.setId(null);
        user.setUsername("testuser");
        user.setEmail("testuser@example.com");
        user.setPasswordHash("hashedpassword");
        user.setCreatedAt(Timestamp.valueOf("2023-01-01 00:00:00"));
        user.setRole(role);

        savedUser = new User();
        savedUser.setId(10L);
        savedUser.setUsername("testuser");
        savedUser.setEmail("testuser@example.com");
        savedUser.setPasswordHash("hashedpassword");
        savedUser.setCreatedAt(Timestamp.valueOf("2023-01-01 00:00:00"));
        savedUser.setRole(role);
    }

    @Test
    public void testFindAll() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(savedUser));

        List<User> users = userService.findAll();
        assertNotNull(users);
        assertTrue(users.size() >= 0);
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        when(userRepository.findById(10L)).thenReturn(Optional.of(savedUser));

        User fetchedUser = userService.findById(10L);
        assertNotNull(fetchedUser);
        assertEquals(10L, fetchedUser.getId());
        verify(userRepository, times(1)).findById(10L);
    }

    @Test
    public void testSave() {
        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        User result = userService.save(user);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals("testuser", result.getUsername());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    public void testDeleteById() {
        doNothing().when(userRepository).deleteById(10L);
        when(userRepository.findById(10L)).thenReturn(Optional.empty());

        userService.deleteById(10L);
        assertThrows(RuntimeException.class, () -> userService.findById(10L));
        verify(userRepository, times(1)).deleteById(10L);
        verify(userRepository, times(1)).findById(10L);
    }

    @Test
    public void testFindAllPage() {
        List<User> pagedList = Arrays.asList(savedUser);
        when(userRepository.findAll(any(Pageable.class)))
                .thenReturn(new PageImpl<>(pagedList));

        List<User> users = userService.findAllPage(0, 1);
        assertNotNull(users);
        assertEquals(1, users.size());
        verify(userRepository, times(1)).findAll(any(Pageable.class));
    }
}
