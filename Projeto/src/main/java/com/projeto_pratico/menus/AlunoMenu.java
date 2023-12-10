package com.projeto_pratico.menus;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.projeto_pratico.model.*;

public class AlunoMenu implements Menu {

    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("Turmas do Aluno");
    private JPanel panelTurma;
    private JPanel turmasPanel;
    private JFrame frameTurma;
    private Aluno aluno;
    private List<Turma> listaTurmas;
    private List<Turma> todasTurmas;

    @Override
    public void render(Usuario usuario, List<Turma> todasTurmas) {
        this.aluno = (Aluno) usuario;
        this.listaTurmas = aluno.getTurmas();
        this.todasTurmas = todasTurmas;

        JLabel[] labels = infosUser();
        JPanel labelPanel = new JPanel(new GridLayout(labels.length, 1));
        for (JLabel label : labels) {
            labelPanel.add(label);
        }
        panel.add(labelPanel, BorderLayout.NORTH);

        EmptyBorder border = new EmptyBorder(10, 0, 10, 0);
        labelPanel.setBorder(border);

        turmasPanel = exibirTurmas();

        panel.add(turmasPanel, BorderLayout.CENTER);
        frame.add(criarToolBar(1, null), BorderLayout.PAGE_START);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JLabel[] infosUser() {
        JLabel[] labels = {
                new JLabel("Bem-Vindo(a), Aluno(a)"),
                new JLabel(aluno.getNome()),
        };

        for (JLabel label : labels) {
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
        }

        return labels;
    }

    private JPanel exibirTurmas() {
        JPanel turmasPanel = new JPanel(new GridLayout(0, 3, 10, 10));

        for (Turma turma : listaTurmas) {
            JPanel blocoTurma = criarBlocoTurma(turma);
            turmasPanel.add(blocoTurma);
        }
        return turmasPanel;
    }

    private JPanel criarBlocoTurma(Turma turma) {
        JPanel blocoTurma = new JPanel();
        blocoTurma.setLayout(new BoxLayout(blocoTurma, BoxLayout.Y_AXIS));
        blocoTurma.setBorder(BorderFactory.createTitledBorder(turma.getNome()));

        blocoTurma.add(new JLabel("ID: " + turma.getId()));
        blocoTurma.add(new JLabel("Atividades: " + turma.getAtividades().size()));

        JButton btnVisualizar = new JButton("Visualizar Atividades");
        btnVisualizar.addActionListener(e -> visualizarAtividades(turma));
        blocoTurma.add(btnVisualizar);

        return blocoTurma;
    }

    private void visualizarAtividades(Turma turma) {
        if (frameTurma != null) {
            frameTurma.dispose();
        }
        frameTurma = new JFrame();
        panelTurma = new JPanel();

        StringBuilder str = new StringBuilder();
        str.append("Professor: " + turma.getProfessor().getNome() + "\n");
        str.append("Atividades: " + turma.getAtividades().size() + "\n");
        panelTurma.add(new JLabel("<html>" + str.toString().replace("\n", "<br>") + "</html>"));

        JPanel atividadesPanel = exibirPainelAtividades(turma);
        frameTurma.add(panelTurma, BorderLayout.NORTH);
        frameTurma.add(atividadesPanel, BorderLayout.CENTER);
        frameTurma.setSize(600, 400);
        frameTurma.setLocationRelativeTo(null);
        frameTurma.setVisible(true);
    }

    private JPanel exibirPainelAtividades(Turma turma) {
        JPanel atvPanel = new JPanel(new GridLayout(0, 3, 10, 10));
    
        List<Atividade> lAtv = turma.getAtividades();
        for (Atividade atividade : lAtv) {
            JPanel blocoAtv = new JPanel();
            blocoAtv.setLayout(new BoxLayout(blocoAtv, BoxLayout.Y_AXIS));
            blocoAtv.setBorder(BorderFactory.createTitledBorder(atividade.getTitulo()));
    
            blocoAtv.add(new JLabel("Prioridade: " + atividade.getPrioridade()));
            blocoAtv.add(new JLabel("Inicio: " + atividade.getDataDeInicio()));
            blocoAtv.add(new JLabel("Entrega: " + atividade.getDataDeTermino()));
    
            JButton btnResponder = new JButton("Responder");
            btnResponder.addActionListener(e -> responderAtividade(atividade, lAtv));
            blocoAtv.add(btnResponder);
    
            JButton btnConcluir = new JButton("Concluir");
            btnConcluir.addActionListener(e -> concluirAtividade(atividade));
            blocoAtv.add(btnConcluir);
    
            atvPanel.add(blocoAtv);
        }
        return atvPanel;
    }

    private void responderAtividade(Atividade atividade, List<Atividade> lAtv) {
        String resposta = JOptionPane.showInputDialog(null, "Digite sua resposta:", "Responder Atividade",
                JOptionPane.PLAIN_MESSAGE);
    
        if (resposta != null) {
            aluno.addResposta(atividade.getId(), resposta, LocalDate.now());
    
            // Atualiza a exibição da atividade
            atualizarExibicaoAtividades();
        }
    }
    
    private void concluirAtividade(Atividade atividade) {
        aluno.concluirAtividade(atividade);
        
        atualizarExibicaoAtividades();
    }
    
    private void atualizarExibicaoAtividades() {
        turmasPanel.removeAll();
        turmasPanel.setLayout(new GridLayout(0, 3, 10, 10));
    
        for (Turma turma : listaTurmas) {
            JPanel blocoTurma = criarBlocoTurma(turma);
            turmasPanel.add(blocoTurma);
        }
    
        turmasPanel.revalidate();
        turmasPanel.repaint();
    }

    private JToolBar criarToolBar(int opc, Turma turma) {
        JToolBar toolBar = new JToolBar("Ações Rápidas");
        toolBar.setFloatable(false);

        if (opc == 1) {
            JButton btnNovaTurma = new JButton("Nova Turma");
            toolBar.add(btnNovaTurma);
            btnNovaTurma.addActionListener(e -> adicionarTurma());
        }

        return toolBar;
    }

    private void adicionarTurma() {
        JTextField idTurmaField = new JTextField();
        idTurmaField.setPreferredSize(new Dimension(200, 24));
    
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Id da turma:"));
        panel.add(idTurmaField);
    
        int result = JOptionPane.showConfirmDialog(null, panel, "Adicionar Turma",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    
        if (result == JOptionPane.OK_OPTION) {
            String idTurma = idTurmaField.getText();
            Turma turmaSelecionada = buscarTurmaPorId(idTurma, todasTurmas);
    
            if (turmaSelecionada != null) {
                // Adiciona a turma ao aluno
                aluno.setTurma(turmaSelecionada);
    
                // Atualiza a lista de turmas do aluno
                listaTurmas = aluno.getTurmas();
    
                // Atualiza a exibição das turmas na interface
                turmasPanel.removeAll();
                turmasPanel.setLayout(new GridLayout(0, 3, 10, 10));
    
                for (Turma turma : listaTurmas) {
                    JPanel blocoTurma = criarBlocoTurma(turma);
                    turmasPanel.add(blocoTurma);
                }
    
                turmasPanel.revalidate();
                turmasPanel.repaint();
            } else {
                JOptionPane.showMessageDialog(null, "Turma não encontrada", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private Turma buscarTurmaPorId(String idTurma, List<Turma> listaTurmas) {
        for (Turma turma : listaTurmas) {
            if (turma.getId().equals(idTurma)) {
                return turma;
            }
        }
        return null;
    }
}
