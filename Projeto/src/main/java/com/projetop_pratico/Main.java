package com.projetop_pratico;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import com.projetop_pratico.gui.LoginFrame;
import com.projetop_pratico.model.Aluno;
import com.projetop_pratico.model.Professor;
import com.projetop_pratico.model.Usuario;

public class Main {
    public static void main(String[] args) {
        List<Usuario> listaDeUsuarios = new ArrayList<>();

        Professor professor = new Professor("NomeProfessor", "professor", "senha123", "Matemática");
        Aluno aluno = new Aluno("NomeAluno", "aluno", "senha456");
    
        listaDeUsuarios.add(professor);
        listaDeUsuarios.add(aluno);

        SwingUtilities.invokeLater(() -> new LoginFrame(listaDeUsuarios));
    }
}