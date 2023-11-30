package com.projeto_pratico.model;

import java.time.LocalDate;

public class Atividade {
    private String titulo;
    private String descricao;
    private LocalDate dataDeInicio;
    private LocalDate dataDeTermino;
    private String prioridade;
    private Professor professor;
    private Turma turma;
    private boolean concluida;

    public Atividade(String titulo, String descricao, LocalDate dataDeInicio, LocalDate dataDeTermino, 
    String prioridade, Professor professor, Turma turma) {
        this.titulo = titulo;
        this.prioridade = prioridade;
        this.descricao = descricao;

        this.dataDeInicio = dataDeInicio;
        this.dataDeTermino = dataDeTermino;

        this.professor = professor;
        this.turma = turma;
    }

    /* gets // sets */
    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataDeInicio() {
        return dataDeInicio;
    }

    public LocalDate getDataDeTermino() {
        return dataDeTermino;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Turma getTurma() {
        return turma;
    }

    public boolean getConcluida() {
        return concluida;
    }
}
