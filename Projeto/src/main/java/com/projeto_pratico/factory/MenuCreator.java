package com.projeto_pratico.factory;

import java.util.List;

import com.projeto_pratico.menus.Menu;
import com.projeto_pratico.model.Turma;
import com.projeto_pratico.model.Usuario;

public abstract class MenuCreator {

    public void renderWindow(Usuario usuario, List<Turma> todasTurmas) {
        Menu menu = createMenu(usuario);
        menu.render(usuario, todasTurmas);
    }

    public abstract Menu createMenu(Usuario usuario);
}
