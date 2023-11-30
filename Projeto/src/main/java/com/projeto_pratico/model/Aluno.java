package com.projeto_pratico.model;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {  
    private List<Turma> turmas;

    public Aluno(String nome, String login, String senha) {
        super(nome, login, senha);
        this.turmas = new ArrayList<>();
    }

    /* gets // sets */
    public List<Turma> getTurmas() {
        return turmas;
    }

    public List<Atividade> getAtividades() {
        List<Atividade> atividades = new ArrayList<>();
        for (Turma turma : this.turmas) {
            atividades.addAll(turma.getAtividades());
        }
        return atividades;
    }
}
