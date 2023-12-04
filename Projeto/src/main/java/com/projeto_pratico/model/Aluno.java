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

    public void entrarTurma(List<Turma> listaTurmas, String idTurma) {
        Turma turma = buscarTurma(listaTurmas, idTurma);
        
        if (turma != null) {
            this.turmas.add(turma);
            turma.getAlunos().add(this);
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    private Turma buscarTurma(List<Turma> listaTurmas, String idTurma) {
        for (Turma turma : listaTurmas) {
            String turmaId = turma.getId();
            System.out.println(turmaId);
            
            if (turmaId.equalsIgnoreCase(idTurma)) {
                return turma;
            }
        }
        return null;
    }
}
