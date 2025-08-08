package com.example.inventory;

import javax.servlet.http.HttpServletRequest;

public class UserResolver {
    public static User resolve(HttpServletRequest req) {
        String roleHeader = req.getHeader(null);
        String userId = req.getHeader(null);
        Role role = Role.valueOf(roleHeader);

        return new User(userId, role);
    }
}