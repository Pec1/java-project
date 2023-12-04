package com.projeto_pratico.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario {
    private List<Turma> turmas;

    public Professor(String nome, String login, String senha) {
        super(nome, login, senha);
        this.turmas = new ArrayList<>();
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public List<Atividade> getAtividades(Turma turma) {
        return turma.getAtividades();
    }

    public Atividade criarAtividade(String titulo, String descricao, LocalDate dataDeInicio, LocalDate dataDeTermino, 
    String prioridade, Turma turma) {
        Atividade atividade = new Atividade(titulo, descricao, dataDeInicio, dataDeTermino, prioridade, this, turma);
        turma.getAtividades().add(atividade);
        return atividade;
    }

    public Turma addTurma(String nome) {
        Turma turma = new Turma(nome, this);
        this.turmas.add(turma);
        return turma;
    }

    public void addTurma(Turma turma) {
        this.turmas.add(turma);
    }



    public void removerAtividade(Turma turma, Atividade atividade) {
        turma.getAtividades().remove(atividade);
    }

    /* public void adicionarAluno(Turma turma, Aluno aluno) {
        turma.getAlunos().add(aluno);
        aluno.getTurmas().add(turma);
    } */

    public void removerAluno(Turma turma, Aluno aluno) {
        turma.getAlunos().remove(aluno);
        aluno.getTurmas().remove(turma);
    }

    public void adicionarTurma(Turma turma) {
        this.turmas.add(turma);
        /* turma.setProfessor(this); */
    } 

    public void removerTurma(Turma turma) {
        this.turmas.remove(turma);
    }
}
