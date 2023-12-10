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

    public static Turma buscarTurma(List<Turma> turmas, String id) {
        for (Turma turma : turmas) {
            if (turma.getId().equals(id)) {
                return turma;
            }
        }
        return null;
    }

    public void addAluno(Aluno aluno) {
        if(!this.alunos.contains(aluno)) {
            this.alunos.add(aluno);
            aluno.setTurma(this);
        }
    }

    public void removeAluno(Aluno aluno) {
        if(this.alunos.contains(aluno)) {
            this.alunos.remove(aluno);
            aluno.getTurmas().remove(this);
        }
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
