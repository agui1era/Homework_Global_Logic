package com.task.global.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.global.entity.Phone;
import com.task.global.entity.User;
import com.task.global.model.ResponseDTO;
import com.task.global.model.UserDTO;
import com.task.global.repository.UserRepository;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseDTO registerUser(UserDTO userDTO) throws NoSuchAlgorithmException {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new RuntimeException("El correo ya registrado");
        }

        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());
        user.setActive(true);
        user.setToken(generateToken(user));
        
        Set<Phone> phones = userDTO.getPhones().stream().map(phoneDTO -> {
            Phone phone = new Phone();
            phone.setNumber(phoneDTO.getNumber());
            phone.setCitycode(phoneDTO.getCitycode());
            phone.setCountrycode(phoneDTO.getContrycode());
            phone.setUser(user);
            return phone;
        }).collect(Collectors.toSet());

        user.setPhones(phones);

        userRepository.save(user);

        ResponseDTO response = new ResponseDTO();
        response.setMessage("Usuario creado exitosamente");

        return response;
    }

    private String generateToken(User user) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        
        return Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS512, "tuClaveSecreta") 
                .compact();
    }
}
