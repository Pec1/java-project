package com.projeto_pratico;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import com.projeto_pratico.model.*;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Usuario> listaDeUsuarios = new ArrayList<>();
    
        Professor professor = new Professor("Jonas Arduino", "professor", "senha123");
        Aluno aluno = new Aluno("NomeAluno", "aluno", "senha123");

        listaDeUsuarios.add(professor);
        listaDeUsuarios.add(aluno);
        
        SwingUtilities.invokeLater(() -> new Login(listaDeUsuarios));
    }
/*     public static void main(String[] args) {
        List<Usuario> listaDeUsuarios = new ArrayList<>();
        List<Turma> listaTurmas = new ArrayList<>();
    
        Professor professor = new Professor("Jonas Arduino", "professor", "senha123");
        Turma turmab = new Turma("Dev. Sasdasdaistemas", professor );
        Aluno aluno = new Aluno("NomeAluno", "aluno", "senha123");

        LocalDate dataDeInicio = LocalDate.now();
        LocalDate dataDeTermino = LocalDate.now().plusDays(7);
        Atividade atividade1  = professor.criarAtividade("Laço de repetição", "Descricao da atividade", dataDeInicio, dataDeTermino, "Alta", turmaA);       
        Turma turmaA = professor.addTurma("Dev. Sistemas");
        professor.addTurma(turmab);

        listaDeUsuarios.add(professor);
        listaDeUsuarios.add(aluno);
        listaTurmas.add(turmaA);
        listaTurmas.add(turmab);

        aluno.entrarTurma(listaTurmas, turmaA.getId());

        for (Turma turmas : aluno.getTurmas()) {
            System.out.println("turmas: " + turmas.getNome());
        }

        for (Turma turma : listaTurmas) {
            System.out.println("Turma: " + turma.getNome());
            System.out.println("Professor: " + turma.getProfessor().getNome());
            System.out.println("Alunos: " + turma.getAlunos().size());
            int count = 1;
            for (Aluno alunos : turma.getAlunos()) {
                System.out.println(count + "- " + alunos.getNome());
                count++;
            }
            System.out.println("Atividades: " + turma.getAtividades().size());
           for (int i = 0; i < turma.getAtividades().size(); i++) {
                System.out.print(i + 1);
            } 
            System.out.println();
        }
        
        MenuPrincipalFrame menuFrame = new MenuPrincipalFrame(professor, listaTurmas);
        SwingUtilities.invokeLater(() -> new LoginFrame(listaDeUsuarios, listaTurmas)); 
    } */
}