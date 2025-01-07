package org.itmo.client.login;

import lombok.Getter;
import org.itmo.client.command.Command;
import org.itmo.client.command.LoginCommand;
import org.itmo.client.command.RegisterCommand;
import org.itmo.client.entity.User;
import org.itmo.client.output.InfoPrinter;

import javax.swing.*;
import java.awt.*;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

@Getter
public class RegistrationLogin {

    private JFrame frame;
    private final Command loginCommand;
    private final Command registerCommand;
    private User user;

    public RegistrationLogin(Socket socket, InfoPrinter commandPrinter, InputStreamReader inputStreamReader, User user) {
        loginCommand = new LoginCommand(socket, commandPrinter, inputStreamReader, user);
        registerCommand = new RegisterCommand(socket, commandPrinter, inputStreamReader, user);
    }

    public User login() {
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width / 2 - 150, dimension.height / 2 - 90, 300, 180);

        JPanel panel = new JPanel();
        frame.add(panel);

        placeComponents(panel);
        frame.setVisible(true);

        return user;
        
    }

    private void placeComponents(JPanel panel) {
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
            loginCommand.execute(new String[]{user, password});

            if (loginCommand.getUser() != null) {
                messageLabel.setText("Login successful!");
                this.user = loginCommand.getUser();
            } else {
                messageLabel.setText("Invalid username or password.");
            }
        });

        registerButton.addActionListener(e -> {
            String user = userText.getText();
            String password = new String(passwordText.getPassword());
            registerCommand.execute(new String[]{user, password});

            if (registerCommand.getUser() == null) {
                messageLabel.setText("Username already exists.");
            } else {
                messageLabel.setText("Registration successful!");
                this.user = registerCommand.getUser();
            }
        });

}
}
