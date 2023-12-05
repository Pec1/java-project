package com.projeto_pratico.menus;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.projeto_pratico.model.Aluno;
import com.projeto_pratico.model.Professor;
import com.projeto_pratico.model.Usuario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AlunoMenu implements Menu {
    JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    private Aluno aluno;

    @Override
    public void render(Usuario usuario) {
        this.aluno = (Aluno) usuario;

        panel.setLayout(new BorderLayout());

        JLabel[] labels = criarLabelArea();
        JPanel labelPanel = new JPanel(new GridLayout(labels.length, 1));
        for (JLabel label : labels) {
            labelPanel.add(label);
        }
    
        EmptyBorder border = new EmptyBorder(10, 0, 10, 0);
        labelPanel.setBorder(border);
        panel.add(labelPanel, BorderLayout.NORTH);
        
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JLabel[] criarLabelArea() {
        JLabel[] labels = {
            new JLabel("Bem-Vindo(a), Aluno(a)"),
            new JLabel(aluno.getNome()),
            /*
            new JLabel("Label 3"),
            new JLabel("Label 4"),
            new JLabel("Label 5")
            */
        };

        for (JLabel label : labels) {
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
        }
    
        return labels;
    }
}
