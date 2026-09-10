package onlinevotingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;

public class VoterPanel extends JFrame implements ActionListener
{
    private JLabel titleLabel, nameLabel, passwordLabel, positionLabel, partyLabel, resultLabel;
    private JTextField nameField, passwordField;
    private JButton loginButton, logoutButton, registerButton, backButton, voteButton, resultButton;
    private JRadioButton position1, position2, position3, party1, party2, party3;
    private ButtonGroup positionGroup, partyGroup;
    private OnlineVotingSystem parent;

    private HashMap<String, String> voters; 
    private HashMap<String, Integer> candidates;
    private HashSet<String> voted;
    
    private String Position1 = "MINISTER";
    private String Position2 = "MAYOR";
    private String Position3 = "CHAIRMAN";
    private String Party1 = "PARTY1";
    private String Party2 = "PARTY2";
    private String Party3 = "PARTY3";
    
    public VoterPanel(OnlineVotingSystem parent) 
    {        
        super("Voter Panel");
        this.parent = parent;
        
        titleLabel = new JLabel("Voter Panel");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));        
        nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        
        positionLabel = new JLabel("CHOOSE A POSITION TO VOTE");        
        positionLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        partyLabel = new JLabel("CHOOSE A PARTY TO VOTE");
        partyLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        
        resultLabel = new JLabel("");       
        nameField = new JTextField(20);
        passwordField = new JTextField(20);
        
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        logoutButton = new JButton("Logout");
        logoutButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        registerButton = new JButton("Register");
        registerButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        voteButton = new JButton("Vote");
        voteButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        resultButton = new JButton("View Result");
        resultButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        backButton = new JButton("Back");
        backButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        
        positionGroup = new ButtonGroup();
        position1 = new JRadioButton(Position1);
        position1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        position2 = new JRadioButton(Position2);
        position2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        position3 = new JRadioButton(Position3);
        position3.setFont(new Font("Times New Roman", Font.BOLD, 16));
        partyGroup = new ButtonGroup();
        party1 = new JRadioButton(Party1);
        party1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        party2 = new JRadioButton(Party2);
        party2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        party3 = new JRadioButton(Party3);
        party3.setFont(new Font("Times New Roman", Font.BOLD, 16));        
        
        setLayout(new GridLayout(10, 2));
        
        add(titleLabel);
        add(new JLabel(""));
        add(new JLabel(""));
        add(nameLabel);
        add(nameField);        
        
        add(new JLabel(""));
        add(passwordLabel);
        add(passwordField);
        add(new JLabel(""));
        
        add(loginButton);
        add(logoutButton);
        add(registerButton);
        add(new JLabel(""));
        
        add(positionLabel);
        add(new JLabel(""));
        add(position1);
        add(position2);
        add(position3);
        add(new JLabel(""));
        add(partyLabel);
        
        add(new JLabel(""));
        add(party1);
        add(party2);
        add(party3);
                              
        add(voteButton);        
        add(resultButton);
        add(backButton);
        add(resultLabel);
        
        positionGroup.add(position1);
        positionGroup.add(position2);
        positionGroup.add(position3);
        partyGroup.add(party1);
        partyGroup.add(party2);
        partyGroup.add(party3);

        loginButton.addActionListener(this);
        logoutButton.addActionListener(this);
        registerButton.addActionListener(this);
        voteButton.addActionListener(this);
        resultButton.addActionListener(this);
        backButton.addActionListener(this);

        voters = new HashMap<>();
        candidates = new HashMap<>();
        voted = new HashSet<>();

        voters.put("Sadia", "123");
        voters.put("Misha", "456");
        voters.put("Medha", "789");
        candidates.put(Position1 + " " + Party1, 0);
        candidates.put(Position1 + " " + Party2, 0);
        candidates.put(Position1 + " " + Party3, 0);
        candidates.put(Position2 + " " + Party1, 0);
        candidates.put(Position2 + " " + Party2, 0);
        candidates.put(Position2 + " " + Party3, 0);
        candidates.put(Position3 + " " + Party1, 0);
        candidates.put(Position3 + " " + Party2, 0);
        candidates.put(Position3 + " " + Party3, 0);

        setTitle("Voter Panel");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
    {
        Object source = e.getSource();

        String name = nameField.getText();
        String password = passwordField.getText();

        JRadioButton position = getSelectedButton(positionGroup);
        JRadioButton party = getSelectedButton(partyGroup);

        if (source == loginButton) 
        {
            if (voters.containsKey(name) && voters.get(name).equals(password)) 
            {
                resultLabel.setText("Login Successful.");
                resultLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
            } 
            else 
            {
                resultLabel.setText("Invalid Name or Password.");
                resultLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
            }
        }
        if (source == logoutButton) 
        {           
            nameField.setText("");
            passwordField.setText("");
            resultLabel.setText("");
        }
        if (source == registerButton) 
        {
            if (!name.isEmpty() && !password.isEmpty()) 
            {
                if (voters.containsKey(name)) 
                {
                    resultLabel.setText("Name Already Exists.");
                    resultLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
                } 
                else 
                {
                    voters.put(name, password);
                    resultLabel.setText("Registration Successful.");
                    resultLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
                }
            } 
            else 
            {
                resultLabel.setText("Empty Name and Password.");
                resultLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
            }
        }
        if (source == voteButton) 
        {
            if (voters.containsKey(name) && voters.get(name).equals(password)) 
            {
                if (voted.contains(name)) 
                {
                    resultLabel.setText("Already Voted.");
                    resultLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
                    
                } 
                else 
                {
                    if (position != null && party != null) 
                    {
                        String candidate = position.getText() + " " + party.getText();
                        candidates.put(candidate, candidates.get(candidate) + 1);
                        voted.add(name);
                        resultLabel.setText("Vote Successful.");
                        resultLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
                    } 
                    else 
                    {
                        resultLabel.setText("Select Position and Party.");
                        resultLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
                    }
                }
            } 
            else 
            {
                resultLabel.setText("Please Login First.");
                resultLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
            }
        }
        if (source == resultButton) 
        {
            if (position != null) 
            {
                String pos = position.getText();
                String winner = "";
                int maxVotes = 0;
                
                for (HashMap.Entry<String, Integer> entry : candidates.entrySet()) 
                {
                    String candidate = entry.getKey();
                    int votes = entry.getValue();                    
                    if (candidate.startsWith(pos)) 
                    {
                        if (votes > maxVotes) 
                        {
                            winner = candidate;
                            maxVotes = votes;
                        }
                    }
                }
                resultLabel.setText("The winner is " + winner + " with " + maxVotes + " votes.");
                resultLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
            } 
            else 
            {
                resultLabel.setText("Select Position.");
                resultLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
            }                   
        }
        if (source == backButton) 
        {
            parent.setVisible(true);
            setVisible(false);
        }
    }

    public JRadioButton getSelectedButton(ButtonGroup group) 
    {
        for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) 
        {
            AbstractButton button = buttons.nextElement();           
            if (button.isSelected()) 
            {
                return (JRadioButton) button;
            }
        }       
        return null;
    }
}