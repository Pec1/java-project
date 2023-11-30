package com.projeto_pratico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import com.projeto_pratico.gui.*;
import com.projeto_pratico.model.*;

public class Main {
    public static void main(String[] args) {
        List<Usuario> listaDeUsuarios = new ArrayList<>();
        List<Turma> listaTurmas = new ArrayList<>();
    
        Professor professor = new Professor("Jonas Arduino", "professor", "senha123");
        Turma turmaA = new Turma("Dev. Sistemas", professor);
        Aluno aluno = new Aluno("NomeAluno", "aluno", "senha123");
    
        LocalDate dataDeInicio = LocalDate.now();
        LocalDate dataDeTermino = LocalDate.now().plusDays(7);
        
        Atividade atividade = professor.criarAtividade("Atividade 1", "Descricao da atividade", dataDeInicio, dataDeTermino, "Alta", turmaA);
        
        professor.adicionarTurma(turmaA);
        professor.adicionarAluno(turmaA, aluno);
    
        for (Turma turmas : aluno.getTurmas()) {
            System.out.println(turmas.getNome());
        }

        professor.removerAluno(turmaA, aluno);

        for (Turma turmas : aluno.getTurmas()) {
            System.out.println(turmas.getNome());
        }

        listaDeUsuarios.add(professor);
        listaDeUsuarios.add(aluno);
        listaTurmas.add(turmaA);
    
        /* SwingUtilities.invokeLater(() -> new LoginFrame(listaDeUsuarios, listaTurmas)); */
    }
}