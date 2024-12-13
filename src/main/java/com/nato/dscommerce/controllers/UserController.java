package com.nato.dscommerce.controllers;

import com.nato.dscommerce.dto.UserDTO;
import com.nato.dscommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping(value = "/me")
    public ResponseEntity<UserDTO> getMe() {
        return ResponseEntity.ok(service.getMe());
    }
}
