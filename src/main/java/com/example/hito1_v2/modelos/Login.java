package com.example.hito1_v2.modelos;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class Login {
    private Usuario login;

    public Login() {
        this.login = null;
        // Sin inicio de sesión por el momento.
    }

    public Usuario getLogin() {

        return login;
    }

    public void setLogin(Usuario usuario) {
        this.login = usuario;
    }
}
