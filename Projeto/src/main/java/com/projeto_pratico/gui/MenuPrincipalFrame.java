package com.projeto_pratico.gui;

import com.projeto_pratico.gui.factory.MenuFactory;
import com.projeto_pratico.interfaces.Menu;
import com.projeto_pratico.model.Usuario;

import javafx.scene.text.Font;

import java.awt.*;

import javax.swing.*;

public class MenuPrincipalFrame extends JFrame {
    private Usuario usuario;

    public MenuPrincipalFrame(Usuario usuario) {
        super("Menu Principal");
        this.usuario = usuario;

        Menu menu = MenuFactory.getMenu(usuario);
        JPanel panel = menu.createMenu();
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
