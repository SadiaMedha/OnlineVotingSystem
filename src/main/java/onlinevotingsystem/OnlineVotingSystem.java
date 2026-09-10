package onlinevotingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnlineVotingSystem extends JFrame implements ActionListener 
{
    private JLabel titleLabel;
    private JButton adminButton, voterButton, exitButton;
    private JFrame adminPanel;
    private JFrame voterPanel;

    public OnlineVotingSystem() 
    {
        super("Online Voting System");

        titleLabel = new JLabel("Online Voting System");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        adminButton = new JButton("Admin");
        adminButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
        voterButton = new JButton("Voter");
        voterButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Times New Roman", Font.BOLD, 22));

        adminButton.addActionListener(this);
        voterButton.addActionListener(this);
        exitButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));
        buttonPanel.add(adminButton);
        buttonPanel.add(voterButton);
        buttonPanel.add(exitButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        add(mainPanel);

        setSize(600, 400);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
    {
        Object source = e.getSource();

        if (source == adminButton) 
        {
            if (adminPanel == null) 
            {
                adminPanel = new AdminPanel(this);
            }
            adminPanel.setVisible(true);
            setVisible(false);
        } 
        else if (source == voterButton) 
        {
            if (voterPanel == null) 
            {
                voterPanel = new VoterPanel(this);
            }
            voterPanel.setVisible(true);
            setVisible(false);
        } 
        else if (source == exitButton) 
        {
            System.exit(0);
        }
    }

    public static void main(String[] args) 
    {
        new OnlineVotingSystem();
    }
}