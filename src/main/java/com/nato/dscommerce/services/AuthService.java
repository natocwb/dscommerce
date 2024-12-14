package com.nato.dscommerce.services;

import com.nato.dscommerce.entities.User;
import com.nato.dscommerce.services.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserService userService;
    public void validateSelfOrAdmin(Long userId) {
        User user = userService.authenticate();
        if (!user.getId().equals(userId) && !user.hasRole("ROLE_ADMIN")) {
            throw new ForbiddenException("Access denied");
        }
    }
}
