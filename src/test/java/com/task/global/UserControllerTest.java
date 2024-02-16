package com.task.global;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.global.controller.UserController;
import com.task.global.entity.User;
import com.task.global.model.UserResponseDTO;
import com.task.global.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper; 

    @Test
    public void registerUser_ReturnsUserResponseDTO() throws Exception {
        
        User user = new User(); 
        UserResponseDTO responseDTO = new UserResponseDTO(); 
        responseDTO.setMessage("Usuario creado exitosamente");

        given(userService.registerUser(any(User.class))).willReturn(responseDTO);

        mockMvc.perform(put("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(responseDTO)));
    }
}
