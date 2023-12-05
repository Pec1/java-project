package com.projeto_pratico.menus;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.projeto_pratico.model.*;

public class ProfessorMenu implements Menu{

    JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    private Professor professor;

    @Override
    public void render(Usuario usuario) {
        this.professor = (Professor) usuario;

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
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(labelPanel, BorderLayout.NORTH);
        
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel criarButtonPanel() {
        JPanel buttonPanel = new JPanel();
    
        JButton visualizarTurmasButton = new JButton("Visualizar Turmas");
        visualizarTurmasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder turmasStr = new StringBuilder("<html>");

                List<Turma> ListTurmas = professor.getTurmas();

                for (int i = 0; i < ListTurmas.size(); i++) {
                    if (i % 3 == 0) {
                        turmasStr.append("<table border=1><tr>");
                    }

                    Turma turma = ListTurmas.get(i);
                    turmasStr.append("<td>" + "Turma: " + turma.getNome() + " " + turma.getId() + "<br>");

                    turmasStr.append("Alunos: " + turma.getAlunos().size() + "<br>");
                    /* int count = 1;
                    for (Aluno aluno : turma.getAlunos()) {
                        turmasStr.append(count + "- " + aluno.getNome() + "<br>");
                        count++;
                    } */

                    turmasStr.append("Atividades: " + turma.getAtividades().size() + "<br>");
                    /* count = 1;
                    for (Atividade atividade : turma.getAtividades()) {
                        turmasStr.append(count + "- " + atividade.getTitulo() + "<br>");
                        count++;
                    } */
                    
                    turmasStr.append("</td>");

                    if (i % 3 == 2 || i == ListTurmas.size() - 1) {
                        turmasStr.append("</tr></table>");
                    }
                }
                
                turmasStr.append("</html>");
                JOptionPane.showMessageDialog(null, turmasStr.toString(), "Turmas", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    
        JButton buscarTurmaButton = new JButton("Buscar Turma");
        buscarTurmaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idTurma = JOptionPane.showInputDialog(null, "Digite o ID da turma", "Buscar Turma", JOptionPane.QUESTION_MESSAGE);

                List<Turma> ListTurmas = professor.getTurmas();

                for (Turma turma : ListTurmas) {
                    if (turma.getId().equals(idTurma)) {
                        StringBuilder alunosStr = new StringBuilder("<html>");
                        alunosStr.append("Professor: " + turma.getProfessor().getNome() + "<br>");
                        alunosStr.append("Alunos: " + turma.getAlunos().size() + "<br>");
                        int count = 1;
                        for (Aluno aluno : turma.getAlunos()) {
                            alunosStr.append(count + "- " + aluno.getNome() + "<br>");
                            count++;
                        }
                        alunosStr.append("</html>");

                        JPanel panel = new JPanel();
                        panel.add(new JLabel(alunosStr.toString()));

                        JButton exibirAtividadesButton = new JButton("Exibir Atividades");
                        exibirAtividadesButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                StringBuilder atvStr = new StringBuilder("<html><table border=1>");
                                for (Atividade atividades : turma.getAtividades()) {
                                    atvStr.append("Titulo: " + atividades.getTitulo() + "<br>");
                                    atvStr.append("Prioridade: " + atividades.getPrioridade() + "<br>");
                                    atvStr.append("Inicio: " + atividades.getDataDeInicio() + "<br>");
                                    atvStr.append("Entrega: " + atividades.getDataDeTermino() + "<br>");
                                    atvStr.append(atividades.getDescricao() + "<br>");
                                }
                                atvStr.append("</table></html>");
                                JOptionPane.showMessageDialog(null, atvStr.toString(), "Atividades", JOptionPane.INFORMATION_MESSAGE);
                            }
                        });
                        panel.add(exibirAtividadesButton);

                        JButton criarAtividadeButton = new JButton("Criar Atividade");
                        criarAtividadeButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JOptionPane.showMessageDialog(null, "Criar Atividade");
                            }
                        });
                        panel.add(criarAtividadeButton);

                        JButton excluirAtividadeButton = new JButton("Excluir Atividade");
                        excluirAtividadeButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JOptionPane.showMessageDialog(null, "Excluir Atividade");
                            }
                        });
                        panel.add(excluirAtividadeButton);

                        JOptionPane.showMessageDialog(null, panel, "Turma: " + turma.getNome(), JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }
            }
        });
        
        buttonPanel.add(visualizarTurmasButton);
        buttonPanel.add(buscarTurmaButton);
    
        return buttonPanel;
    }


    private JLabel[] criarLabelArea() {
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
    
}
