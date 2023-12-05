package com.projeto_pratico.factory;

import com.projeto_pratico.menus.Menu;
import com.projeto_pratico.model.Usuario;

public abstract class MenuCreator {

    public void renderWindow(Usuario usuario) {
        Menu menu = createMenu(usuario);
        menu.render(usuario);
    }

    public abstract Menu createMenu(Usuario usuario);
}
