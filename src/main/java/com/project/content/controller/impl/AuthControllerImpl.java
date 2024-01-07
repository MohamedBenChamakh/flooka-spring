package com.project.content.controller.impl;

import com.project.content.controller.AuthController;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthControllerImpl implements AuthController {
    @Override
    public String getUserInfo(Principal principal) {
        return principal.getName();
    }
}
