package com.gui.ydd.filter;

import java.util.Map;

public class LoginValidationFilter implements Filter {
    @Override
    public void execute(Map<String, String> params) {
        String account = params.get("account");
        if (account == null || account.isEmpty()) {
            throw new IllegalArgumentException("Account is required");
        }

        String password = params.get("password");
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password is required");
        }

        String role = params.get("role");
        if (role == null || role.isEmpty()) {
            throw new IllegalArgumentException("Role is required");
        }
    }
}