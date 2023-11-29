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

        
        Professor professor = new Professor("Jonas Arduino", "professor", "senha123");
        Turma turmaA = new Turma("Dev. Sistemas", professor);
        Aluno aluno = new Aluno("NomeAluno", "aluno", "senha123", turmaA);

        LocalDate dataDeInicio = LocalDate.now();
        LocalDate dataDeTermino = LocalDate.now().plusDays(7);
        Atividade atividade = new Atividade("Atividade 1", "Descricao da atividade", dataDeInicio, dataDeTermino, "Alta", professor, aluno, turmaA);

        professor.adicionarAtividade(turmaA, atividade);

        for (Aluno alunos : turmaA.getAlunos()) {
            System.out.println("Turma: " + turmaA.getNome());
            System.out.println("Professor: " + turmaA.getProfessor().getNome());
            
            for(Atividade atividades : turmaA.getAtividades()) {
                System.out.println("Atividades:");
                System.out.println(atividades.getTitulo());
            }
            System.out.println("Alunos: " + alunos.getNome());
        }
    
        listaDeUsuarios.add(professor);
        listaDeUsuarios.add(aluno);

        /* SwingUtilities.invokeLater(() -> new LoginFrame(listaDeUsuarios)); */

        /* MenuPrincipalFrame menu = new MenuPrincipalFrame(professor); */
        /* MenuPrincipalFrame menu2 = new MenuPrincipalFrame(aluno); */
    }
}