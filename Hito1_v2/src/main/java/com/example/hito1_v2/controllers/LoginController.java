package com.example.hito1_v2.controllers;

import com.example.hito1_v2.modelos.Login;
import com.example.hito1_v2.modelos.Usuario;
import com.example.hito1_v2.modelos.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Controller
public class LoginController {
    Login login;
    private Usuarios registrarUsuario;

    public LoginController(Usuarios registrarUsuario) {
        this.registrarUsuario = registrarUsuario;
    }
    @Autowired //Autowired es para usar el método de la clase
    public void setLogin(Login login) {
        this.login = login;
    }
    @RequestMapping("/comprobar")
    public ModelAndView login(Usuario user, Model model,HttpServletRequest request) {
//        System.out.println(user.getUsuario());
        ModelAndView mv = new ModelAndView();
        Usuario login = this.registrarUsuario.getUsuarios().get(user.getUsuario());

        if (login==null) {

        }
        else {

            if (user.getPass().equals(login.getPass())) {
                this.login.setLogin(login);
                model.addAttribute("sms", "Bienvenido "+login.getUsuario());
                model.addAttribute("arrayOpiniones",login.getOpiniones());
            }
            else {
                model.addAttribute("sms", "El password no es correcto");
            }
        }
        return  getModelAndView(request, model,user, mv);
    }
    private ModelAndView getModelAndView(HttpServletRequest request, Model model,Usuario user, ModelAndView mv) {
        HttpSession sesion = request.getSession();

        if (login.getLogin()==null) {
            mv.addObject("texto", "Usuario no registrado, si deseas escribir tu reseña registrate");
            model.addAttribute("login", new Usuario());
            mv.setViewName("login");
        }
        else {
            mv.addObject("mensaje", "Usuario actual: " + login.getLogin().getUsuario());
//            System.out.println(login.getLogin().getUsuario());
//            System.out.println(sesion.getId());
            mv.addObject("sms1", "Gestor de recomendaciones");
            mv.addObject("sms2", "Id de sesión: "+sesion.getId());
            mv.addObject("login", login.getLogin());
            mv.addObject("user", login.getLogin().getUsuario());
            mv.addObject("textarea","");
            mv.addObject("opinion","");

            Set<Usuario> coleccionUsuarios= new HashSet<Usuario>(this.registrarUsuario.getUsuarios().values());
            model.addAttribute("usuariosCollection",coleccionUsuarios);
            mv.addObject("usuarios", coleccionUsuarios);
            mv.setViewName("opiniones");
        }
        return mv;
    }
}
