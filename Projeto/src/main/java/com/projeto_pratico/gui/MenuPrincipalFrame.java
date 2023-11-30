package com.projeto_pratico.gui;

import com.projeto_pratico.gui.factory.MenuFactory;
import com.projeto_pratico.interfaces.Menu;
import com.projeto_pratico.model.Turma;
import com.projeto_pratico.model.Usuario;

import javafx.scene.text.Font;
import java.util.List;

import java.awt.*;

import javax.swing.*;

public class MenuPrincipalFrame extends JFrame {
    private List<Turma> listaTurmas;
    private Usuario usuario;

    public MenuPrincipalFrame(Usuario usuario, List<Turma> listaTurmas) {
        super("Menu Principal");
        this.usuario = usuario;
        this.listaTurmas = listaTurmas;

        Menu menu = MenuFactory.getMenu(usuario, listaTurmas);
        JPanel panel = menu.createMenu();
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
