package com.projetop_ratico;

import com.projetop_ratico.model.Aluno;
import com.projetop_ratico.model.Professor;

public class Main {
    public static void main(String[] args) {
        Aluno a1 = new Aluno("José", "dwqeeqw", "1234567");
        Professor p1 = new Professor("Carlos", "qae8162", "1234cvnm71m", "Matematica");
        

        boolean sla = a1.autenticar("dasdasda", "1234567");

        System.out.println(p1.getMateria());
    }
}