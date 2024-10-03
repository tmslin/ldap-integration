package org.example.controller;

import org.example.authenticator.LdapAuthenticator;
import org.example.authenticator.LoginInfo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController
{
    private final LdapAuthenticator _authenticator;

    public LoginController(LdapAuthenticator authenticator)
    {
        _authenticator = authenticator;
    }

    @PostMapping("/authenticate")
    public String login(@RequestBody LoginInfo loginInfo)
    {
        return _authenticator.authenticate(loginInfo) ? "Login success" : "Invalid credentials";
    }

    @GetMapping("/authenticate")
    public String get()
    {
        return "This is the authentication endpoint";
    }
}
