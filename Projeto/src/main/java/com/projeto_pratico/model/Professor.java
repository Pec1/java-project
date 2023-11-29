package com.projeto_pratico.model;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario {
    private List<Turma> turmas;

    public Professor(String nome, String login, String senha) {
        super(nome, login, senha);
        this.turmas = new ArrayList<>();
    }

    /* gets // sets */
    public List<Atividade> getAtividades(Turma turma) {
        return turma.getAtividades();
    }

    public void adicionarTurma(Turma turma) {
        this.turmas.add(turma);
    }

    public void removerTurma(Turma turma) {
        this.turmas.remove(turma);
    }

    public void adicionarAtividade(Turma turma, Atividade atividade) {
        turma.adicionarAtividade(atividade);
    }

    public void removerAtividade(Turma turma, Atividade atividade) {
        turma.removerAtividade(atividade);
    }
}
