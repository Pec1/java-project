package com.projeto_pratico.menus;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.projeto_pratico.model.*;

public class ProfessorMenu implements Menu {

    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("Turmas do professor");
    private JPanel panelTurma;
    private JPanel turmasPanel;
    private JFrame frameTurma;
    private Professor professor;
    private List<Turma> listaTurmas;

    @Override
    public void render(Usuario usuario, List<Turma> todasTurmas) {
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
                new JLabel("Bem-Vindo(a), Professor(a)"),
                new JLabel(professor.getNome()),
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
        blocoTurma.add(new JLabel("Qtd de Alunos: " + turma.getAlunos().size()));

        JButton btnVisualizar = new JButton("Visualizar a Turma");
        btnVisualizar.addActionListener(e -> {
            painelTurma(turma);
        });
        blocoTurma.add(btnVisualizar);

        return blocoTurma;
    }

    private void painelTurma(Turma turma) {
        if (frameTurma != null) {
            frameTurma.dispose();
        }
        frameTurma = new JFrame();
        panelTurma = new JPanel();

        StringBuilder str = new StringBuilder();
        str.append("Professor: " + turma.getProfessor().getNome() + "\n");
        str.append("Alunos: " + turma.getAlunos().size() + "\n");
        str.append("Atividades: " + turma.getAtividades().size() + "\n");
        panelTurma.add(new JLabel("<html>" + str.toString().replace("\n", "<br>") + "</html>"));

        JPanel atividadesPanel = exibirPainelAtividades(turma);
        frameTurma.add(criarToolBar(2, turma), BorderLayout.PAGE_START);
        panelTurma.add(atividadesPanel, BorderLayout.CENTER);
        frameTurma.add(panelTurma);
        frameTurma.setSize(600, 400);
        frameTurma.setLocationRelativeTo(null);
        frameTurma.setVisible(true);
    }

    private void adicionarTurma() {
        JTextField nomeTurma = new JTextField();
        nomeTurma.setPreferredSize(new Dimension(200, 24));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Nome da turma:"));
        panel.add(nomeTurma);

        int result = JOptionPane.showConfirmDialog(null, panel, "Adicionar Turma",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            // Adiciona a nova turma
            Turma turma = professor.addTurma(nomeTurma.getText());

            // Atualiza a lista de turmas
            listaTurmas = professor.getTurmas();

            // Cria um bloco para a nova turma e adiciona ao painel existente
            JPanel blocoTurma = criarBlocoTurma(turma);
            turmasPanel.add(blocoTurma);

            // Atualiza o painel de turmas
            turmasPanel.revalidate();
            turmasPanel.repaint();
        }
    }

    private JToolBar criarToolBar(int opc, Turma turma) {
        JToolBar toolBar = new JToolBar("Ações Rápidas");
        toolBar.setFloatable(false);

        if (opc == 2) {
            JButton btnAddAtividade = new JButton("Adicionar Atividade");
            toolBar.add(btnAddAtividade);
            btnAddAtividade.addActionListener(e -> adicionarAtividade(turma));
        } else if (opc == 1) {
            JButton btnNovaTurma = new JButton("Nova Turma");
            toolBar.add(btnNovaTurma);
            btnNovaTurma.addActionListener(e -> adicionarTurma());
        }

        return toolBar;
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

            JButton btnVisualizar = new JButton("Visualizar");
            btnVisualizar.addActionListener(e -> {
                atividade(lAtv, atividade.getId());
            });
            blocoAtv.add(btnVisualizar);

            JButton btnExcluir = new JButton("Excluir");
            btnExcluir.addActionListener(e -> {
                professor.removerAtividade(turma, atividade);
                panelTurma.removeAll();
                panelTurma.revalidate();
                panelTurma.repaint();
                painelTurma(turma);
            });
            blocoAtv.add(btnExcluir);

            atvPanel.add(blocoAtv);
        }
        return atvPanel;
    }

    private void atividade(List<Atividade> lAtv, String id) {
        Atividade atividade = Atividade.buscarAtividade(lAtv, id);
    
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Aluno");
        model.addColumn("Resposta");
        model.addColumn("Data de Entrega");

        atividade.getRespostas().forEach((aluno, resposta) -> {
            LocalDate dataEntrega = atividade.getDataEntregaAluno();
            model.addRow(new Object[]{aluno, resposta, dataEntrega});
        });
    
        JTable table = new JTable(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
    
        JScrollPane scrollPane = new JScrollPane(table);
    
        // Criação de um painel para a descrição da atividade
        JPanel descriptionPanel = new JPanel(new BorderLayout());
        descriptionPanel.add(new JLabel("Descrição da Atividade: " + atividade.getDescricao()), BorderLayout.NORTH);
        descriptionPanel.add(new JLabel("Data de Início: " + atividade.getDataDeInicio()), BorderLayout.CENTER);
        descriptionPanel.add(new JLabel("Data de Término: " + atividade.getDataDeTermino()), BorderLayout.SOUTH);
    
        JFrame frameRespostas = new JFrame("Respostas da Atividade");
        frameRespostas.setLayout(new BorderLayout());
        frameRespostas.add(descriptionPanel, BorderLayout.NORTH);
        frameRespostas.add(scrollPane, BorderLayout.CENTER);
        frameRespostas.setSize(600, 400);
        frameRespostas.setLocationRelativeTo(null);
        frameRespostas.setVisible(true);
    }

    private void adicionarAtividade(Turma turma) {
        JTextField tituloField = new JTextField();
        tituloField.setPreferredSize(new Dimension(200, 24));
        JTextArea descricaoArea = new JTextArea();
        descricaoArea.setPreferredSize(new Dimension(200, 80));
        JScrollPane scrollPane = new JScrollPane(descricaoArea);
        scrollPane.setPreferredSize(new Dimension(200, 80));
        JTextField dataInicioField = new JTextField();
        dataInicioField.setPreferredSize(new Dimension(100, 24));
        JTextField dataTerminoField = new JTextField();
        dataTerminoField.setPreferredSize(new Dimension(100, 24));

        // Cria as caixas de seleção para a prioridade
        JCheckBox altaCheckBox = new JCheckBox("Alta");
        JCheckBox mediaCheckBox = new JCheckBox("Média");
        JCheckBox baixaCheckBox = new JCheckBox("Baixa");

        // Agrupa as caixas de seleção para garantir que apenas uma possa ser
        // selecionada
        ButtonGroup prioridadeGroup = new ButtonGroup();
        prioridadeGroup.add(altaCheckBox);
        prioridadeGroup.add(mediaCheckBox);
        prioridadeGroup.add(baixaCheckBox);

        JPanel prioridadePanel = new JPanel();
        prioridadePanel.add(altaCheckBox);
        prioridadePanel.add(mediaCheckBox);
        prioridadePanel.add(baixaCheckBox);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Título:"));
        panel.add(tituloField);
        panel.add(new JLabel("Descrição:"));
        panel.add(scrollPane);
        panel.add(new JLabel("Data de Início (dd/MM/yyyy):"));
        panel.add(dataInicioField);
        panel.add(new JLabel("Data de Término (dd/MM/yyyy):"));
        panel.add(dataTerminoField);
        panel.add(new JLabel("Prioridade:"));
        panel.add(prioridadePanel);

        int result = JOptionPane.showConfirmDialog(null, panel, "Adicionar Atividade",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            LocalDate dataDeInicio = LocalDate.parse(dataInicioField.getText(),
                    DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalDate dataDeTermino = LocalDate.parse(dataTerminoField.getText(),
                    DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            // Determina a prioridade selecionada
            String prioridade = altaCheckBox.isSelected() ? "Alta"
                    : mediaCheckBox.isSelected() ? "Média" : baixaCheckBox.isSelected() ? "Baixa" : "";

            Atividade novaAtividade = professor.criarAtividade(
                    tituloField.getText(),
                    descricaoArea.getText(),
                    dataDeInicio,
                    dataDeTermino,
                    prioridade,
                    turma);

            panelTurma.removeAll();
            panelTurma.revalidate();
            panelTurma.repaint();
            painelTurma(turma);
        }
    }
}
