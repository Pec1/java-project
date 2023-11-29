package com.projeto_pratico.model;

//import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {  
    private Turma turma;

    public Aluno(String nome, String login, String senha, Turma turma) {
        super(nome, login, senha);
        this.turma = turma;

        this.turma.adicionarAluno(this);
    }

    /* gets // sets */
    public Turma getTurma() {
        return turma;
    }

    public List<Atividade> getAtividades() {
        return turma.getAtividades();
    }
}
