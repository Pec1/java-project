package com.projetop_pratico.gui;

import javax.swing.*;

import com.projetop_pratico.model.Aluno;
import com.projetop_pratico.model.Professor;
import com.projetop_pratico.model.Usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipalFrame extends JFrame {
    private Usuario usuario;

    public MenuPrincipalFrame(Usuario usuario) {
        super("Menu Principal");
        this.usuario = usuario;

        initComponents();
        configureUI();

        // Restante do código...
    }

    private void initComponents() {
        // Inicialização dos componentes do Menu Principal
        // Adicione os componentes conforme necessário
    }

    private void configureUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        // Adicione lógica condicional para os menus de acordo com o tipo de usuário
        if (usuario instanceof Aluno) {
            configureAlunoMenu(menuBar);
        } else if (usuario instanceof Professor) {
            configureProfessorMenu(menuBar);
        }

        setJMenuBar(menuBar);
    }

    private void configureAlunoMenu(JMenuBar menuBar) {
        JMenu atividadesMenu = new JMenu("Atividades");
        JMenuItem visualizarAtividadesItem = new JMenuItem("Visualizar Atividades");

        visualizarAtividadesItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adicione lógica para visualizar atividades do aluno
                JOptionPane.showMessageDialog(MenuPrincipalFrame.this, "Visualizar Atividades do Aluno");
            }
        });

        atividadesMenu.add(visualizarAtividadesItem);
        menuBar.add(atividadesMenu);
    }

    private void configureProfessorMenu(JMenuBar menuBar) {
        JMenu alunosMenu = new JMenu("Alunos");
        JMenuItem visualizarAlunosItem = new JMenuItem("Visualizar Alunos");

        visualizarAlunosItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adicione lógica para visualizar alunos do professor
                JOptionPane.showMessageDialog(MenuPrincipalFrame.this, "Visualizar Alunos do Professor");
            }
        });

        JMenu atividadesMenu = new JMenu("Atividades");
        JMenuItem visualizarAtividadesItem = new JMenuItem("Visualizar Atividades");
        JMenuItem criarAtividadeItem = new JMenuItem("Criar Atividade");

        visualizarAtividadesItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adicione lógica para visualizar atividades do professor
                JOptionPane.showMessageDialog(MenuPrincipalFrame.this, "Visualizar Atividades do Professor");
            }
        });

        criarAtividadeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adicione lógica para criar atividade do professor
                JOptionPane.showMessageDialog(MenuPrincipalFrame.this, "Criar Atividade do Professor");
            }
        });

        alunosMenu.add(visualizarAlunosItem);
        atividadesMenu.add(visualizarAtividadesItem);
        atividadesMenu.add(criarAtividadeItem);

        menuBar.add(alunosMenu);
        menuBar.add(atividadesMenu);
    }
}
