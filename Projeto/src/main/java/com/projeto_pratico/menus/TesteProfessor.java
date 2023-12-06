package com.projeto_pratico.menus;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.projeto_pratico.model.*;

public class TesteProfessor implements Menu{

    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame();
    private Professor professor;
    private List<Turma> listaTurmas;

    @Override
    public void render(Usuario usuario) {
        this.professor = (Professor) usuario;
        this.listaTurmas = professor.getTurmas();
    
        JLabel[] labels = infosUser();
        JPanel labelPanel = new JPanel(new GridLayout(labels.length, 1));
        for (JLabel label : labels) {
            labelPanel.add(label);
        }
        panel.add(labelPanel, BorderLayout.NORTH);

        EmptyBorder border = new EmptyBorder(10, 0, 10, 0);
        labelPanel.setBorder(border);

        JPanel turmasPanel = painelTurmas();
    
        panel.add(turmasPanel, BorderLayout.CENTER);
        
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JLabel[] infosUser() {
        JLabel[] labels = {
            new JLabel("Bem-Vindo(a), Professor(a)"),
            new JLabel(professor.getNome()),
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

    private JPanel painelTurmas() {
        JPanel turmasPanel = new JPanel(new GridLayout(0, 3, 10, 10));

        for (Turma turma : listaTurmas) {
            JPanel blocoTurma = new JPanel();
            blocoTurma.setLayout(new BoxLayout(blocoTurma, BoxLayout.Y_AXIS));
            blocoTurma.setBorder(BorderFactory.createTitledBorder(turma.getNome()));

            blocoTurma.add(new JLabel("ID: " + turma.getId()));
            blocoTurma.add(new JLabel("Qtd de Alunos: " + turma.getAlunos().size()));
            blocoTurma.add(new JLabel("Qtd de Atividades: " + turma.getAtividades().size()));

            // Adiciona o botão "Visualizar a Turma"
            JButton btnVisualizar = new JButton("Visualizar a Turma");
            btnVisualizar.addActionListener(e -> {
                // Ação a ser executada quando o botão for pressionado
                JOptionPane.showMessageDialog(frame, "Detalhes da Turma:\n" +
                        "ID: " + turma.getId() + "\n" +
                        "Nome: " + turma.getNome() + "\n" +
                        "Qtd de Alunos: " + turma.getAlunos().size() + "\n" +
                        "Qtd de Atividades: " + turma.getAlunos().size());
            });
            blocoTurma.add(btnVisualizar);

            turmasPanel.add(blocoTurma);
        }
        return turmasPanel;
    }
}
