package com.projeto_pratico;

import javax.swing.*;

import com.projeto_pratico.factory.*;

import com.projeto_pratico.model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Login extends JFrame {
    private static MenuCreator menuCreator;

    private JTextField loginField;
    private JPasswordField senhaField;

    private List<Usuario> listaDeUsuarios;
    private Usuario usuarioAutenticado;

    public Login(List<Usuario> listaDeUsuarios) {
        super("Login");
        this.listaDeUsuarios = listaDeUsuarios;
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JLabel loginLabel = new JLabel("Login:");
        JLabel senhaLabel = new JLabel("Senha:");
        loginField = new JTextField(15);
        senhaField = new JPasswordField(15);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                String senha = new String(senhaField.getPassword());

                if (autenticarUsuario(login, senha)) {
                    dispose();
                    exibirMenuPrincipal();
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Login ou senha incorretos", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(loginLabel);
        panel.add(loginField);
        panel.add(senhaLabel);
        panel.add(senhaField);
        panel.add(loginButton);

        add(panel);
        setVisible(true);
        
    }

    private boolean autenticarUsuario(String login, String senha) {
        for (Usuario usuario : listaDeUsuarios) {
            if (usuario.autenticar(login, senha)) {
                usuarioAutenticado = usuario;
                return true;
            }
        }
        return false;
    }

    private void exibirMenuPrincipal() {
        if (usuarioAutenticado instanceof Aluno) {
            menuCreator =  new AlunoMCreator();
            menuCreator.renderWindow((Aluno) usuarioAutenticado);
        } else if (usuarioAutenticado instanceof Professor) {
            menuCreator =  new ProfessorMCreator();
            menuCreator.renderWindow((Professor) usuarioAutenticado);
        }
    }
}
