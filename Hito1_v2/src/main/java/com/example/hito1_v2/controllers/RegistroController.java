package com.example.hito1_v2.controllers;

import com.example.hito1_v2.modelos.Usuario;
import com.example.hito1_v2.modelos.Usuarios;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;


@Controller
public class RegistroController {
    private Usuarios registrarUsuario;

    public RegistroController(Usuarios registrarUsuario) throws IOException, ClassNotFoundException {
        this.registrarUsuario = registrarUsuario;
    }

    @RequestMapping("/registrar")
    public ModelAndView registro(Usuario usuario, Model model) throws IOException, ClassNotFoundException {
        ModelAndView mv = new ModelAndView("opiniones");
        Usuario userLogin = this.registrarUsuario.getUsuarios().get(usuario.getUsuario());
        if (userLogin==null) {
            if(usuario.getUsuario().equals("") || usuario.getPass().equals("")){
                model.addAttribute("texto","Por favor rellene los campos");
                mv.setViewName("registro");
            }else {
                model.addAttribute("texto", "REGISTRADO CON EXITO");
                this.registrarUsuario.getUsuarios().put(usuario.getUsuario(), usuario);
                model.addAttribute("usuarios", usuario);
                mv.setViewName("index");
            }
        }else{
            model.addAttribute("texto", "Este usuario ya existe");
            mv.setViewName("registro");
        }
        return mv;
    }

}
