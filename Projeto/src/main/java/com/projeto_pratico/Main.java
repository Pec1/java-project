package com.projeto_pratico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import com.projeto_pratico.model.*;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Usuario> listaDeUsuarios = new ArrayList<>();
        List<Turma> listaTurmas = new ArrayList<>();
    
        Professor professor = new Professor("Jonas Arduino", "professor", "senha123");
        Aluno aluno = new Aluno("NomeAluno", "aluno", "senha123");
        Aluno aluno2 = new Aluno("NomeAluno2", "aluno2", "senha1234");

        Turma turmaA = professor.addTurma("Dev. Sistemas");

        Turma turmab = new Turma("Dev. Sasdasdaistemas", professor );
        professor.addTurma(turmab);
        professor.addTurma(turmab);
        professor.addTurma(turmab);
        professor.addTurma(turmab);
        professor.addTurma(turmab);

        Atividade atividade = new Atividade(null, null, null, null, null, professor, turmab);

        LocalDate dataDeInicio = LocalDate.now();
        LocalDate dataDeTermino = LocalDate.now().plusDays(7);
        Atividade atividade1  = professor.criarAtividade("Laço de repetição", "Descricao da atividade", dataDeInicio, dataDeTermino, "Alta", turmaA);
        Atividade atividade2  = professor.criarAtividade("Laço de repetição", "Descricao da atividade", dataDeInicio, dataDeTermino, "Alta", turmaA);
        Atividade atividade3  = professor.criarAtividade("Laço de repetição", "Descricao da atividade", dataDeInicio, dataDeTermino, "Alta", turmaA);
        Atividade atividade4  = professor.criarAtividade("Laço de repetição", "DescricaoDescricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao Descricao  da atividade", dataDeInicio, dataDeTermino, "Alta", turmaA);

        listaDeUsuarios.add(professor);
        listaDeUsuarios.add(aluno);
        listaDeUsuarios.add(aluno2);
        listaTurmas.add(turmaA);
        listaTurmas.add(turmab);

        /* aluno.entrarTurma(null, turmaA.getId()); */

        Turma buscaTurma = Turma.buscarTurma(listaTurmas, turmaA.getId());
        buscaTurma.addAluno(aluno);
        
        System.out.println(atividade1.getId());

        aluno.addResposta(atividade1.getId(), "Não sei sou burro, desculpa professor", LocalDate.now());
        aluno2.addResposta(atividade1.getId(), "bla bla bla bla bla", LocalDate.now());

        for (Atividade atividades : aluno.getAtividades()){
            System.out.print(atividades.getRespostas());
        }

        System.out.println(turmab.getId());
        
        SwingUtilities.invokeLater(() -> new Login(listaDeUsuarios, listaTurmas));
        SwingUtilities.invokeLater(() -> new Login(listaDeUsuarios, listaTurmas));
    }
}