package org.example.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginData {
    public String username;
    public String password;
    public Profile profile;
    public List<String> roles;
}

