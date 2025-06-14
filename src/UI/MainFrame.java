/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author USER
 */
public class MainFrame extends JFrame {
    
    private JLabel labelGreeting, labelUsername, labelPassword;
    private JTextField textUsername;
    private JPasswordField textPassword;
    private JButton buttonLogin, buttonChangeLang;

    private Locale currentLocale;
    private ResourceBundle messages;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
    currentLocale = new Locale("ID"); // Default Bahasa Indonesia
    loadLanguage(currentLocale);

    setTitle("Aplikasi Multi-Bahasa");
    setSize(500, 400);
    setLayout(null); // Pakai layout manual, jangan campur dengan GroupLayout NetBeans
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    // Komponen GUI
    labelGreeting = new JLabel(messages.getString("label.greeting"));
    labelGreeting.setBounds(140, 10, 200, 25);
    add(labelGreeting);

    labelUsername = new JLabel(messages.getString("label.username"));
    labelUsername.setBounds(50, 50, 100, 25);
    add(labelUsername);

    textUsername = new JTextField();
    textUsername.setBounds(150, 50, 180, 25);
    add(textUsername);

    labelPassword = new JLabel(messages.getString("label.password"));
    labelPassword.setBounds(50, 90, 100, 25);
    add(labelPassword);

    textPassword = new JPasswordField();
    textPassword.setBounds(150, 90, 180, 25);
    add(textPassword);

    buttonLogin = new JButton(messages.getString("button.login"));
    buttonLogin.setBounds(150, 130, 180, 30);
    add(buttonLogin);

    buttonChangeLang = new JButton(messages.getString("button.change_language"));
    buttonChangeLang.setBounds(150, 180, 180, 30);
    add(buttonChangeLang);
    
    updateTexts();

    // Event Login
    buttonLogin.addActionListener(e -> {
        String user = textUsername.getText();
        String pass = new String(textPassword.getPassword());

        if (user.equals("admin") && pass.equals("admin")) {
            JOptionPane.showMessageDialog(this, messages.getString("login.success"));
        } else {
            JOptionPane.showMessageDialog(this, messages.getString("login.fail"));
        }
    });

    // Event Ganti Bahasa
    buttonChangeLang.addActionListener(e -> changeLanguage());

    setVisible(true); // Tampilkan frame
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       SwingUtilities.invokeLater(() -> {
        new MainFrame(); // Sudah otomatis setVisible(true)
    });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
private void loadLanguage(Locale locale) {
        messages = ResourceBundle.getBundle("Lang.MessagesBundle", locale);
    }

    private void changeLanguage() {
        String[] options = {"Bahasa Indonesia", "English", "Español", "中文"};
        int choice = JOptionPane.showOptionDialog(this,
                "Pilih Bahasa / Choose Language / Seleccione Idioma / 选择语言",
                "Ganti Bahasa",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        switch (choice) {
            case 0:
                currentLocale = new Locale("id");
                break;
            case 1:
                currentLocale = new Locale("en");
                break;
            case 2:
                currentLocale = new Locale("es");
                break;
            case 3:
                currentLocale = new Locale("zh");
                break;
            default:
                return;
        }

        loadLanguage(currentLocale);
        updateTexts();
    }

    private void updateTexts() {
        labelGreeting.setText(messages.getString("label.greeting"));
        labelUsername.setText(messages.getString("label.username"));
        labelPassword.setText(messages.getString("label.password"));
        buttonLogin.setText(messages.getString("button.login"));
        buttonChangeLang.setText(messages.getString("button.change_language"));
    }
}
