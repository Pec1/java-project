package com.projeto_pratico.menus;

import java.util.List;

import com.projeto_pratico.model.Turma;
import com.projeto_pratico.model.Usuario;

public interface Menu {
    void render(Usuario usuario, List<Turma> todasTurmas);
}