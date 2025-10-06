package com.games.back.mocked;

import com.games.back.model.User;
import com.games.back.model.Role;
import com.games.back.dtos.User.UserInDTO;
import com.games.back.dtos.User.UserOutDTO;
import com.games.back.dtos.Role.RoleDTO;
import com.games.back.mappers.IUserMapper;
import com.games.back.repository.IUserRepository;
import com.games.back.services.IRoleService;
import com.games.back.services.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    
    @Mock
    private IUserMapper userMapper;
    
    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private IRoleService roleService;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;
    private User savedUser;
    private Role role;
    private UserInDTO userInDTO;
    private UserOutDTO userOutDTO;

    @BeforeEach
    public void setUp() {
        // Configurar Role
        role = new Role();
        role.setId(1L);
        role.setName("ADMIN");

        // Configurar RoleDTO
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(1L);
        roleDTO.setName("ADMIN");

        // Configurar User para persistencia
        user = new User();
        user.setId(null);
        user.setUsername("testuser");
        user.setEmail("testuser@example.com");
        user.setPasswordHash("hashedpassword");
        user.setCreatedAt(Timestamp.valueOf("2023-01-01 00:00:00"));
        user.setRole(role);

        // Configurar User ya persistido
        savedUser = new User();
        savedUser.setId(10L);
        savedUser.setUsername("testuser");
        savedUser.setEmail("testuser@example.com");
        savedUser.setPasswordHash("hashedpassword");
        savedUser.setCreatedAt(Timestamp.valueOf("2023-01-01 00:00:00"));
        savedUser.setRole(role);
        
        // Configurar UserInDTO
        userInDTO = new UserInDTO();
        userInDTO.setUsername("testuser");
        userInDTO.setEmail("testuser@example.com");
        userInDTO.setPassword("password");
        userInDTO.setRoleId(1L);
        
        // Configurar UserOutDTO
        userOutDTO = new UserOutDTO();
        userOutDTO.setId(10L);
        userOutDTO.setUsername("testuser");
        userOutDTO.setEmail("testuser@example.com");
        userOutDTO.setCreatedAt(Timestamp.valueOf("2023-01-01 00:00:00"));
        userOutDTO.setRole(roleDTO);
    }

    @Test
    public void testFindAll() {
        // Configurar mocks
        when(userRepository.findAll()).thenReturn(Arrays.asList(savedUser));
        when(userMapper.userToUserOutDto(any(User.class))).thenReturn(userOutDTO);

        // Ejecutar método a probar
        List<UserOutDTO> users = userService.findAll();
        
        // Verificar resultados
        assertNotNull(users);
        assertTrue(users.size() > 0);
        assertEquals(10L, users.get(0).getId());
        
        // Verificar interacciones
        verify(userRepository, times(1)).findAll();
        verify(userMapper, times(1)).userToUserOutDto(any(User.class));
    }

    @Test
    public void testFindById() {
        // Configurar mocks
        when(userRepository.findById(10L)).thenReturn(Optional.of(savedUser));
        when(userMapper.userToUserOutDto(savedUser)).thenReturn(userOutDTO);

        // Ejecutar método a probar
        UserOutDTO fetchedUser = userService.findById(10L);
        
        // Verificar resultados
        assertNotNull(fetchedUser);
        assertEquals(10L, fetchedUser.getId());
        
        // Verificar interacciones
        verify(userRepository, times(1)).findById(10L);
        verify(userMapper, times(1)).userToUserOutDto(savedUser);
    }

    @Test
    public void testSave() {
        // Configurar mocks
        when(userMapper.userInDtoToUser(userInDTO)).thenReturn(user);
        when(passwordEncoder.encode(anyString())).thenReturn("hashedpassword");
        when(userRepository.save(any(User.class))).thenReturn(savedUser);
        when(userMapper.userToUserOutDto(savedUser)).thenReturn(userOutDTO);
        when(roleService.findById(1L)).thenReturn(role);

        // Ejecutar método a probar
        UserOutDTO result = userService.save(userInDTO);
        
        // Verificar resultados
        assertNotNull(result);
        assertEquals(10L, result.getId());
        assertEquals("testuser", result.getUsername());
        
        // Verificar interacciones
        verify(userMapper, times(1)).userInDtoToUser(userInDTO);
        verify(passwordEncoder, times(1)).encode(anyString());
        verify(userRepository, times(1)).save(any(User.class));
        verify(userMapper, times(1)).userToUserOutDto(savedUser);
    }

    @Test
    public void testDeleteById() {
        // Configurar mocks
        doNothing().when(userRepository).deleteById(10L);
        when(userRepository.findById(10L)).thenReturn(Optional.empty());

        // Ejecutar método a probar
        userService.deleteById(10L);
        
        // Verificar resultados
        assertThrows(RuntimeException.class, () -> userService.findById(10L));
        
        // Verificar interacciones
        verify(userRepository, times(1)).deleteById(10L);
    }

    @Test
    public void testFindAllPage() {
        // Configurar mocks
        List<User> pagedList = Arrays.asList(savedUser);
        when(userRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(pagedList));
        when(userMapper.userToUserOutDto(any(User.class))).thenReturn(userOutDTO);

        // Ejecutar método a probar
        List<UserOutDTO> users = userService.findAllPage(0, 1);
        
        // Verificar resultados
        assertNotNull(users);
        assertEquals(1, users.size());
        
        // Verificar interacciones
        verify(userRepository, times(1)).findAll(any(Pageable.class));
        verify(userMapper, times(1)).userToUserOutDto(any(User.class));
    }
    
    @Test
    public void testFindByUsername() {
        // Configurar mocks
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(savedUser));
        when(userMapper.userToUserOutDto(savedUser)).thenReturn(userOutDTO);

        // Ejecutar método a probar
        UserOutDTO result = userService.findByUsername("testuser");
        
        // Verificar resultados
        assertNotNull(result);
        assertEquals("testuser", result.getUsername());
        
        // Verificar interacciones
        verify(userRepository, times(1)).findByUsername("testuser");
        verify(userMapper, times(1)).userToUserOutDto(savedUser);
    }
}