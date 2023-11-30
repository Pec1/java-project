package com.projeto_pratico.gui.factory;

import java.util.List;

import com.projeto_pratico.interfaces.Menu;
import com.projeto_pratico.model.Aluno;
import com.projeto_pratico.model.Professor;
import com.projeto_pratico.model.Turma;
import com.projeto_pratico.model.Usuario;

public class MenuFactory {
    public static Menu getMenu(Usuario usuario, List<Turma> listaTurmas) {
        if (usuario instanceof Aluno) {
            return new AlunoMenu(usuario, listaTurmas);
        } else if (usuario instanceof Professor) {
            return new ProfessorMenu(usuario, listaTurmas);
        }
        throw new IllegalArgumentException("Tipo de usuário desconhecido");
    }
}
