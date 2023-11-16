package com.projetop_ratico.model;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario {
    private String materia;
    private List<Aluno> alunos;
    private List<Atividade> atividades;

    public Professor(String nome, String login, String senha, String materia) {
        super(nome, login, senha);
        this.materia = materia;
        this.alunos = new ArrayList<>();
        this.atividades = new ArrayList<>();
    }

    public String getMateria() {
        return materia;
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
