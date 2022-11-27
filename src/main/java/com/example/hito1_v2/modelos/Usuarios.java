package com.example.hito1_v2.modelos;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.io.Serializable;
import java.util.TreeMap;

@Service
@ApplicationScope
public class Usuarios implements Serializable {
    TreeMap<String,Usuario> usuarios;

    public Usuarios() {
        Usuario usuario1 = new Usuario();
        usuario1.setUsuario("juan");
        usuario1.setPass("1234");
        usuario1.getOpiniones().add("·THOR: LOVE AND THUNDER: Una de las peores películas de MARVEL. sigue un humor bastante repetitivo de eso se dedica y muy mala en cuestión de contenido");
        usuario1.getOpiniones().add("·LIGHTYEAR: La película esta buenísima!!! Hace mucho tiempo que no me pasa que la gente aplauda en el cine en el final, incluso tuve ese impulso!! Que para mi es bastante ridículo. No sé guíen por las críticas, hay mucho mente cerrada retrógrada que la están defenestrando por no entender o adaptarse al cambio que estamos viviendo como sociedad.. aclaro: es para chicos mayores de 7 u 8 años, como cunado Andy vió por primera ves la movie de su personaje favorito, Buzz!!");
        usuario1.getOpiniones().add("·JURASSIC WORLD: DOMINION: Una película sin sentido y con un argumento absurdo totalmente fuera de control. Lo único que le salva del 0 rotundo son los gráficos y efectos especiales.");

        this.usuarios = new TreeMap<String, Usuario>();
        usuarios.put(usuario1.getUsuario(),usuario1);
    }

    public void setUsuarios(TreeMap<String, Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public TreeMap<String, Usuario> getUsuarios() {
        return usuarios;
    }
}
