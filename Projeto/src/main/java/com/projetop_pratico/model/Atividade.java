package com.projetop_pratico.model;

import java.time.LocalDate;

public class Atividade {
    private String titulo;
    private String descricao;
    private LocalDate dataDeInicio;
    private LocalDate dataDeTermino;
    private String prioridade;
    private Professor professor;
    private Aluno aluno;
    private boolean concluida;

    public Atividade(String titulo, String descricao, LocalDate dataDeInicio, LocalDate dataDeTermino, 
                    String prioridade, Professor professor, Aluno aluno) {
        this.titulo = titulo;
        this.prioridade = prioridade;
        this.descricao = descricao;

        this.dataDeInicio = dataDeInicio;
        this.dataDeTermino = dataDeTermino;

        this.professor = professor;
        this.aluno = aluno;
    }
    // getters e setters
}
