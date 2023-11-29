package com.projeto_pratico.gui.factory;

import com.projeto_pratico.interfaces.Menu;
import com.projeto_pratico.model.Aluno;
import com.projeto_pratico.model.Professor;
import com.projeto_pratico.model.Usuario;

public class MenuFactory {
    public static Menu getMenu(Usuario usuario) {
        if (usuario instanceof Aluno) {
            return new AlunoMenu(usuario);
        } else if (usuario instanceof Professor) {
            return new ProfessorMenu(usuario);
        }
        throw new IllegalArgumentException("Tipo de usuário desconhecido");
    }
}
