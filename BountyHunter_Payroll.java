package bounty_payroll;
/*
    YEEHAW! Welcome to your first legal gig as the Mounty County's Bounty Huntin'...

    This Java app tracks outlaw records and calculates bounties with a 20% cut 
    for the sheriff. Round up names or reckon pay with easy buttons. The UI’s 
    like a sheriff’s office - modal dialogs, clean layouts, and bounty-worthy 
    centered labels. Saddle up and keep that payroll tight, partner!
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BountyHunter_Payroll extends JFrame {
    JMenuBar menuBar;
    JMenu menu;

    // Font and color for that gritty sheriff office vibe
    private Font bountyFont = new Font("Serif", Font.BOLD | Font.ITALIC, 14);
    private Color sheriffBrown = new Color(102, 51, 0); // Dark Brown

    public BountyHunter_Payroll(String title) {
        super(title);
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        menuBar = new JMenuBar();
        menu = new JMenu("🏜️ Bounty Hunter Payroll");
        menuBar.add(menu);
        setJMenuBar(menuBar);

        JMenuItem recordsItem = new JMenuItem("🔫 Outlaw Records");
        JMenuItem computeItem = new JMenuItem("💰 Calculate Bounty");
        JMenuItem exitItem = new JMenuItem("🏃‍♂️ Ride Away");

        menu.add(recordsItem);
        menu.add(computeItem);
        menu.add(exitItem);

        recordsItem.addActionListener(e -> new RecordsDialog());
        computeItem.addActionListener(e -> new ComputeDialog());
        exitItem.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    class RecordsDialog extends JDialog {
        JTextField lastNameField, firstNameField;
        JLabel firstNameLabel, lastNameLabel;

        RecordsDialog() {
            super(BountyHunter_Payroll.this, "🔫 Outlaw Records", true);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setSize(400, 300);
            setLocationRelativeTo(BountyHunter_Payroll.this);

            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
            mainPanel.setBackground(new Color(222, 184, 135)); // burlywood

            JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
            inputPanel.setOpaque(false);

            JLabel lblLast = new JLabel("Outlaw Last Name:");
            JLabel lblFirst = new JLabel("Outlaw First Name:");
            lblLast.setFont(bountyFont);
            lblLast.setForeground(sheriffBrown);
            lblFirst.setFont(bountyFont);
            lblFirst.setForeground(sheriffBrown);

            inputPanel.add(lblLast);
            lastNameField = new JTextField(10);
            inputPanel.add(lastNameField);
            inputPanel.add(lblFirst);
            firstNameField = new JTextField(10);
            inputPanel.add(firstNameField);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
            buttonPanel.setOpaque(false);
            JButton display = new JButton("Reveal Outlaw");
            JButton clear = new JButton("Clear Trail");
            JButton close = new JButton("Close Case");
            display.setFont(bountyFont);
            display.setForeground(sheriffBrown);
            clear.setFont(bountyFont);
            clear.setForeground(sheriffBrown);
            close.setFont(bountyFont);
            close.setForeground(sheriffBrown);

            buttonPanel.add(display);
            buttonPanel.add(clear);
            buttonPanel.add(close);

            firstNameLabel = new JLabel(" ", JLabel.CENTER);
            lastNameLabel = new JLabel(" ", JLabel.CENTER);
            firstNameLabel.setFont(bountyFont);
            firstNameLabel.setForeground(sheriffBrown);
            lastNameLabel.setFont(bountyFont);
            lastNameLabel.setForeground(sheriffBrown);

            display.addActionListener(e -> {
                firstNameLabel.setText("Outlaw First Name: " + firstNameField.getText());
                lastNameLabel.setText("Outlaw Last Name: " + lastNameField.getText());
            });

            clear.addActionListener(e -> {
                lastNameField.setText("");
                firstNameField.setText("");
                firstNameLabel.setText(" ");
                lastNameLabel.setText(" ");
            });

            close.addActionListener(e -> dispose());

            mainPanel.add(inputPanel);
            mainPanel.add(Box.createVerticalStrut(10));
            mainPanel.add(buttonPanel);
            mainPanel.add(Box.createVerticalStrut(10));
            mainPanel.add(firstNameLabel);
            mainPanel.add(lastNameLabel);

            add(mainPanel);
            setVisible(true);
        }
    }

    class ComputeDialog extends JDialog {
        JTextField hoursField, rateField, bountyField;

        ComputeDialog() {
            super(BountyHunter_Payroll.this, "💰 Bounty Calculator", true);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setSize(350, 300);
            setLocationRelativeTo(BountyHunter_Payroll.this);

            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
            mainPanel.setBackground(new Color(222, 184, 135));

            JPanel fieldsPanel = new JPanel(new GridLayout(3, 2, 10, 10));
            fieldsPanel.setOpaque(false);

            JLabel lblHours = new JLabel("Hours on the Trail:");
            JLabel lblRate = new JLabel("Rate per Hour:");
            JLabel lblBounty = new JLabel("Final Bounty:");
            lblHours.setFont(bountyFont);
            lblHours.setForeground(sheriffBrown);
            lblRate.setFont(bountyFont);
            lblRate.setForeground(sheriffBrown);
            lblBounty.setFont(bountyFont);
            lblBounty.setForeground(sheriffBrown);

            hoursField = new JTextField();
            rateField = new JTextField();
            bountyField = new JTextField();
            bountyField.setEditable(false);

            fieldsPanel.add(lblHours);
            fieldsPanel.add(hoursField);
            fieldsPanel.add(lblRate);
            fieldsPanel.add(rateField);
            fieldsPanel.add(lblBounty);
            fieldsPanel.add(bountyField);

            JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
            buttonsPanel.setOpaque(false);
            JButton calc = new JButton("Calculate Bounty");
            JButton clear = new JButton("Clear Trail");
            JButton close = new JButton("Close Case");

            calc.setFont(bountyFont);
            calc.setForeground(sheriffBrown);
            clear.setFont(bountyFont);
            clear.setForeground(sheriffBrown);
            close.setFont(bountyFont);
            close.setForeground(sheriffBrown);

            calc.addActionListener(e -> {
                try {
                    double hours = Double.parseDouble(hoursField.getText());
                    double rate = Double.parseDouble(rateField.getText());
                    double net = (hours * rate) * 0.8; // Sheriff takes 20%
                    bountyField.setText(String.format("%.2f", net));
                } catch (NumberFormatException ex) {
                    bountyField.setText("Invalid Input");
                }
            });

            clear.addActionListener(e -> {
                hoursField.setText("");
                rateField.setText("");
                bountyField.setText("");
            });

            close.addActionListener(e -> dispose());

            buttonsPanel.add(calc);
            buttonsPanel.add(clear);
            buttonsPanel.add(close);

            mainPanel.add(fieldsPanel);
            mainPanel.add(Box.createVerticalStrut(15));
            mainPanel.add(buttonsPanel);

            add(mainPanel);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BountyHunter_Payroll("Bounty Hunter Payroll"));
    }
}
