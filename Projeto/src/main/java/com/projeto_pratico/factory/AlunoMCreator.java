package com.projeto_pratico.factory;

import com.projeto_pratico.menus.AlunoMenu;
import com.projeto_pratico.menus.Menu;
import com.projeto_pratico.model.Usuario;

public class AlunoMCreator extends MenuCreator{

    @Override
    public Menu createMenu(Usuario usuario) {
        return new AlunoMenu();
    }   
}
