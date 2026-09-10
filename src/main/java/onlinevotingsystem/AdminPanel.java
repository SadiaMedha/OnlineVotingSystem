package onlinevotingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminPanel extends JFrame implements ActionListener
{
    private JLabel titleLabel, usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, backButton, logoutButton, voteCountButton;
    private OnlineVotingSystem parent;

    public AdminPanel(OnlineVotingSystem parent) 
    {
        super("Admin Panel");
        this.parent = parent;

        titleLabel = new JLabel("Admin Panel");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(4, 1));
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
        backButton = new JButton("Back");
        backButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
        logoutButton = new JButton("Logout");
        logoutButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
        voteCountButton = new JButton("Vote Count");
        voteCountButton.setFont(new Font("Times New Roman", Font.BOLD, 22));

        loginButton.addActionListener(this);
        backButton.addActionListener(this);
        logoutButton.addActionListener(this);
        voteCountButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));
        buttonPanel.add(loginButton);
        buttonPanel.add(backButton);
        buttonPanel.add(logoutButton);
        buttonPanel.add(voteCountButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(loginPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setSize(800, 500);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);    
    }

    public void actionPerformed(ActionEvent e) 
    {
        Object source = e.getSource();

        if (source == loginButton) 
        {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals("Sadia") && password.equals("sadia123")) 
            {
                JOptionPane.showMessageDialog(this, "Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                setVisible(true);
            } 
            else 
            {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }                 
        else if (source == logoutButton) 
        {
            setVisible(false);
            parent.setVisible(true);
        }        
        else if (source == voteCountButton) 
        {
            JOptionPane.showMessageDialog(this, "Votes Given: " + getTotalVotes(), "Vote Count", JOptionPane.INFORMATION_MESSAGE);
        }        
        else if (source == backButton) 
        {
            parent.setVisible(true);
            setVisible(false);
        } 
    }

    private int getTotalVotes() 
    {
        return 0;
    }
}