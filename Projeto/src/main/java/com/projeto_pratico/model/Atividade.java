package com.projeto_pratico.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Atividade {
    private String id;
    private String titulo;
    private String descricao;

    private LocalDate dataDeInicio;
    private LocalDate dataDeTermino;
    private LocalDate dataEntregaAluno;
    private String prioridade;

    private Professor professor;
    private Turma turma;

    private HashMap<String, String> respostas = new HashMap<>();
    private boolean concluida;

    public Atividade(String titulo, String descricao, LocalDate dataDeInicio, LocalDate dataDeTermino, 
    String prioridade, Professor professor, Turma turma) {
        this.id =UUID.randomUUID().toString().substring(0, 3);

        this.titulo = titulo;
        this.prioridade = prioridade;
        this.descricao = descricao;

        this.dataDeInicio = dataDeInicio;
        this.dataDeTermino = dataDeTermino;

        this.professor = professor;
        this.turma = turma;

    }

    public static Atividade buscarAtividade(List<Atividade> atividades, String id) {
        for (Atividade atividade : atividades) {
            if (atividade.getId().equals(id)) {
                return atividade;
            }
        }
        return null;
    }

    public boolean passouDoPrazo() {
        return LocalDate.now().isAfter(this.dataDeTermino);
    }
    
    public String getId() {
        return id;
    }

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

    public LocalDate getDataEntregaAluno() {
        return dataEntregaAluno;
    }

    public void setDataEntregaAluno(LocalDate entrega) {
        this.dataEntregaAluno = entrega;
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

    public HashMap<String, String> getRespostas() {
        return respostas;
    }

    public boolean getConcluida() {
        return concluida;
    }

    public void marcarComoConcluida() {
        concluida = !concluida;
    }
}
