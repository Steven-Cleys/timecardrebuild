package be.rmc.timecard.security;

import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;

/**
 * Created by scleys on 3/20/17.
 */

public class AccountCredentials {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


