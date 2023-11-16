package com.projetop_ratico.model;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {  
    private List<Professor> professores;
    private List<Atividade> atividades;

    public Aluno(String nome, String login, String senha) {
        super(nome, login, senha);
        this.professores = new ArrayList<>();
        this.atividades = new ArrayList<>();
    }



    /*  */

    public void adicionarProfessor(Professor professor) {
        this.professores.add(professor);
    }

    public void removerProfessor(Professor professor) {
        this.professores.remove(professor);
    }

    public void adicionarAtividade(Atividade atividade) {
        this.atividades.add(atividade);
    }

    public void removerAtividade(Atividade atividade) {
        this.atividades.remove(atividade);
    }
}
