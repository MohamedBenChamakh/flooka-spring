package com.project.content.controller;

import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

public interface AuthController {

    @GetMapping("/info")
    public String getUserInfo(Principal principal);
}
