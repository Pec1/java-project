package com.projeto_pratico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import com.projeto_pratico.model.*;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Usuario> listaDeUsuarios = new ArrayList<>();
    
        Professor professor = new Professor("Jonas Arduino", "professor", "senha123");
        Aluno aluno = new Aluno("NomeAluno", "aluno", "senha123");

        Turma turmaA = professor.addTurma("Dev. Sistemas");

        Turma turmab = new Turma("Dev. Sasdasdaistemas", professor );
        professor.addTurma(turmab);


        LocalDate dataDeInicio = LocalDate.now();
        LocalDate dataDeTermino = LocalDate.now().plusDays(7);
        Atividade atividade1  = professor.criarAtividade("Laço de repetição", "Descricao da atividade", dataDeInicio, dataDeTermino, "Alta", turmaA);

        listaDeUsuarios.add(professor);
        listaDeUsuarios.add(aluno);

        for (Atividade atividade : aluno.getAtividades()){
            System.out.println(atividade.getTitulo());
        }
        
        SwingUtilities.invokeLater(() -> new Login(listaDeUsuarios));
    }
}