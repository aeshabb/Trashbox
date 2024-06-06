package org.itmo.client.login;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class RegistrationLogin {

    private static Map<String, String> users = new HashMap<>();
    private static JFrame frame;

    public void login() {
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width / 2 - 150, dimension.height / 2 - 90, 300, 180);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);

    }

    private void  placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(180, 80, 100, 25);
        panel.add(registerButton);

        JLabel messageLabel = new JLabel("");
        messageLabel.setBounds(10, 110, 300, 25);
        panel.add(messageLabel);

        loginButton.addActionListener(e -> {
            String user = userText.getText();
            String password = new String(passwordText.getPassword());

            if (users.containsKey(user) && users.get(user).equals(password)) {
                messageLabel.setText("Login successful!");
                frame.dispose();
            } else {
                messageLabel.setText("Invalid username or password.");
            }
        });

        registerButton.addActionListener(e -> {
            String user = userText.getText();
            String password = new String(passwordText.getPassword());

            if (users.containsKey(user)) {
                messageLabel.setText("Username already exists.");
            } else {
                users.put(user, password);
                messageLabel.setText("Registration successful!");
                frame.dispose();
            }
        });
    }
}
