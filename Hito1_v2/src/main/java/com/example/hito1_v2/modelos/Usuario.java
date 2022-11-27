package com.example.hito1_v2.modelos;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {
    private String usuario;
    private String pass ;
    private ArrayList<String> opiniones;
    public Usuario() {
        this.usuario = "";
        this.pass = "";
        this.opiniones = new ArrayList<String>();
    }
    public String getPass() {
        return pass;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

    public ArrayList<String> getOpiniones() {
        return opiniones;
    }

    public void setOpiniones(ArrayList<String> opiniones) {
        this.opiniones = opiniones;
    }
}
