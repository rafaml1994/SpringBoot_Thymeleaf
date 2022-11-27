package com.example.hito1_v2.controllers;

import com.example.hito1_v2.modelos.Login;
import com.example.hito1_v2.modelos.modificarOpiniones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
public class OpinionesController {
    private Login login;
    private ArrayList<String> modificar;

    public OpinionesController() {
        this.modificar = new ArrayList<String>();
        this.modificar.add("");
    }
    @Autowired //Autowired es para usar el método de la clase
    public void setLogin(Login login) {
        this.login = login;
    }


    @RequestMapping("/insertarOpiniones")
    public ModelAndView setOpiniones(String textarea, ModelMap model){
        ModelAndView mv = new ModelAndView();
        model.addAttribute("login", login.getLogin());
        if(!(textarea.equals(""))) {
            login.getLogin().getOpiniones().add("·"+textarea);
        }
        mv.addObject("arrayOpiniones", login.getLogin().getOpiniones());
        System.out.println(login.getLogin().getOpiniones());
        mv.setViewName("opiniones");

        return  mv;
    }


    @RequestMapping("/modificarOpiniones")
    public String modificarOpiniones(String textarea, ModelMap model){
        ArrayList<String> arrayOpiniones = login.getLogin().getOpiniones();

        String[] partes = textarea.split(",·");
        for (int i = 0; i < login.getLogin().getOpiniones().size(); i++){
            if(partes[i].contains("·")){
                arrayOpiniones.set(i,partes[i]);
            }else{
                arrayOpiniones.set(i, "·" + partes[i]);
            }
        }
        model.addAttribute("login", login.getLogin());
        model.addAttribute("arrayOpiniones",login.getLogin().getOpiniones());
        return  "opiniones";
    }
    @RequestMapping("/volverInicio")
    public String volverInicio(ModelMap model){
        model.addAttribute("login",login.getLogin());
        return  "index";
    }
}
