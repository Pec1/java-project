package com.projeto_pratico.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Turma {
    private String id;
    private String nome;
    private List<Aluno> alunos;
    private Professor professor;
    private List<Atividade> atividades;

    public Turma(String nome, Professor professor) {
        this.id = UUID.randomUUID().toString().substring(0, 5);
        this.nome = nome;
        this.professor = professor;
        this.alunos = new ArrayList<>();
        this.atividades = new ArrayList<>();
    }

    /* gets // sets */
    public String getId() {
        return id;
    }

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
}
