package com.task.global;


import com.task.global.entity.User;
import com.task.global.repository.UserRepository;
import com.task.global.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService.jwtSecret = "secretKey"; // Simula la inyección de la clave secreta JWT
        userService.passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$"; // Simula la inyección de la expresión regular de la contraseña
    }

    @Test
    void registerUser_FailsWhenEmailFormatIsIncorrect() {
        User user = new User();
        user.setEmail("invalidemail");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> userService.registerUser(user));
        assertEquals("Formato de correo electrónico inválido.", exception.getMessage());
    }

    @Test
    void registerUser_FailsWhenPasswordIsInsecure() {
        User user = new User();
        user.setEmail("user@example.com");
        user.setPassword("123");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> userService.registerUser(user));
        assertEquals("La contraseña debe tener al menos 8 caracteres con una mezcla de números y letras.", exception.getMessage());
    }
}
