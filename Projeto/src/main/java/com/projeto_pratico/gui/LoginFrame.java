package com.projeto_pratico.gui;
import javax.swing.*;

import com.projeto_pratico.model.Turma;
import com.projeto_pratico.model.Usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LoginFrame extends JFrame {
    private JTextField loginField;
    private JPasswordField senhaField;

    private List<Turma> listaTurmas;
    private List<Usuario> listaDeUsuarios;
    private Usuario usuarioAutenticado;

    public LoginFrame(List<Usuario> listaDeUsuarios, List<Turma> listaTurmas) {
        super("Login");
        this.listaTurmas = listaTurmas;
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
                    exibirMenuPrincipal(login);
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Login ou senha incorretos", "Erro", JOptionPane.ERROR_MESSAGE);
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

    private void exibirMenuPrincipal(String login) {
        MenuPrincipalFrame menuFrame = new MenuPrincipalFrame(usuarioAutenticado, listaTurmas);
        menuFrame.setVisible(true);
    }
}
