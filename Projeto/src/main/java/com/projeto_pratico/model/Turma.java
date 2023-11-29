package com.projeto_pratico.model;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String nome;
    private List<Aluno> alunos;
    private Professor professor;
    private List<Atividade> atividades;

    public Turma(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
        this.alunos = new ArrayList<>();
        this.atividades = new ArrayList<>();
    }

    /* gets // sets */
    public String getNome() {
        return nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }
    
    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        this.alunos.remove(aluno);
    }

    public void adicionarAtividade(Atividade atividade) {
        this.atividades.add(atividade);
    }

    public void removerAtividade(Atividade atividade) {
        this.atividades.remove(atividade);
    }
}
