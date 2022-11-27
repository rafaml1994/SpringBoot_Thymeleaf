package com.example.hito1_v2.controllers;

import com.example.hito1_v2.modelos.Login;
import com.example.hito1_v2.modelos.Usuario;
import com.example.hito1_v2.modelos.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

@Controller
public class IndexController {
    Login login;
    Usuarios usuarios; // Contiene mapa de usuarios.

    // Inyección de dependencias por medio del constructor.
    public IndexController(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Autowired //Autowired es para usar el método de la clase
    public void setLogin(Login login) {
        this.login = login;
    }

    @RequestMapping("/")
    public ModelAndView index(ModelMap model){
        ModelAndView mv = new ModelAndView();
        //Public ModelView es para cuando creamos objetos mv
        mv.addObject("login", login.getLogin());
        mv.setViewName("index");
        return mv;
    }
    @RequestMapping("/registro")
    public String opionesTemplate(@ModelAttribute("usuario") Usuario usuario){
        return "registro";
    }
    //Model atribute
    @ModelAttribute("usuario")
    public Usuario usuario(){
        return new Usuario();
    }



    @RequestMapping("/login")
    public String loginTemplate(Model model){
        //Creamos el objeto para poder rellenarlo con los datos del formulario
        model.addAttribute("login", new Usuario());
        return "login";
    }

    @RequestMapping("/opiniones")
    public ModelAndView opiniones(){
        ModelAndView mv = new ModelAndView();
        //Public ModelView es para cuando creamos objetos mv
        mv.addObject("login", login.getLogin());
        mv.setViewName("opiniones");
        return mv;
    }

    //Model atribute
    @ModelAttribute("listaUsuarios")
    public  Set<Usuario> usuarios(){
        Set<Usuario> coleccionUsuarios = new HashSet<Usuario>(this.usuarios.getUsuarios().values());
        for (Usuario u: coleccionUsuarios) {
            System.out.println(u.getUsuario());
            for (String o : u.getOpiniones()) {
                System.out.println("   - " + o);
            }
        }
        return coleccionUsuarios;
    }
    @RequestMapping("/cerrarSesion")
    public String cerrarSesion(HttpSession sesion){
        //Cerramos sesion
        sesion.invalidate();
        return "index";
    }
}
