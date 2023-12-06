package com.projeto_pratico.factory;

import com.projeto_pratico.menus.Menu;
import com.projeto_pratico.menus.ProfessorMenu;
import com.projeto_pratico.model.Usuario;

public class ProfessorMCreator extends MenuCreator{

    @Override
    public Menu createMenu(Usuario usuario) {
        return new ProfessorMenu();
    }
}
