package com.projeto_pratico.model;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public void setTurma(Turma turma) {
        this.turmas.add(turma);
    }

    public List<Atividade> getAtividades() {
        List<Atividade> atividades = new ArrayList<>();
        for (Turma turma : this.turmas) {
            atividades.addAll(turma.getAtividades());
        }
        return atividades;
    }

    public void addResposta(String idAtv, String resposta, LocalDate entrega) {
        Atividade atividade = Atividade.buscarAtividade(getAtividades(), idAtv);
    
        if (atividade != null) {
            atividade.getRespostas().put(getNome(), resposta);
            atividade.setDataEntregaAluno(entrega);
        }
    }
    
    public void concluirAtividade(Atividade atividade) {
        atividade.marcarComoConcluida();
    }
}
