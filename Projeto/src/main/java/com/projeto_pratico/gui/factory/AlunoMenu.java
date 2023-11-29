package com.projeto_pratico.gui.factory;

import com.projeto_pratico.interfaces.Menu;
import com.projeto_pratico.model.Usuario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlunoMenu implements Menu {
    Usuario usuario;

    public AlunoMenu(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public JPanel createMenu() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
    
        JLabel[] labels = criarLabelArea();
        JPanel labelPanel = new JPanel(new GridLayout(labels.length, 1));
        for (JLabel label : labels) {
            labelPanel.add(label);
        }
    
        JPanel buttonPanel = criarButtonPanel();
    
        EmptyBorder border = new EmptyBorder(10, 0, 10, 0);
        labelPanel.setBorder(border);
        buttonPanel.setBorder(border);
    
        panel.add(labelPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
    
        return panel;
    }

    private JPanel criarButtonPanel() {
        JPanel buttonPanel = new JPanel();

        JButton visualizarAtividadesButton = new JButton("Visualizar Atividades");
        visualizarAtividadesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Visualizar Atividades do Aluno");
            }
        });
    
        buttonPanel.add(visualizarAtividadesButton);
    
        return buttonPanel;
    }

    private JLabel[] criarLabelArea() {
        JLabel[] labels = {
            new JLabel("Bem-Vindo(a), Aluno(a)"),
            new JLabel(usuario.getNome()),
            new JLabel("Label 3"),
            new JLabel("Label 4"),
            new JLabel("Label 5")
        };

        for (JLabel label : labels) {
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
        }
    
        return labels;
    }
}

