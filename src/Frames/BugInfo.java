package Frames;

import Controller.BugInfoCode;
import Entity.Bug;
import Entity.Person;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BugInfo extends JFrame implements ActionListener {

    private final Container container;
    private Person user;
    private Bug bug;
    private JPanel panel;
    private JLabel banerlab, idlab, namelab, desclab, expectedlab, actuallab, commentlab, datelab, prirotylab, statuslab, testerlab, developerlab;
    private JTextArea descarea, expectedarea, actualarea, commentarea;
    private Font banerfont, labfont, fldfont;
    private JTextField idfld, namefld;
    private JScrollPane scroll;
    private JComboBox prirotybox, statusbox;
    private JButton backbtn, updatebtn;
    private String priroty[] = {"LOW", "MEDIUM", "HIGH"};
    private String query;
    private String status[] = {"NEW", "IN PROGRESS", "FIXED", "REOPEN", "CLOSE"};

    public BugInfo(Person user, Bug bug, String query) {
        this.query = query;
        this.user = user;
        this.bug = bug;
        this.setVisible(true);
        this.setTitle(bug.getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(850, 650);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        container = this.getContentPane();
        container.setBackground(new java.awt.Color(0, 51, 51));
        container.setLayout(null);
        variableInitializer();
        Body();
    }

    private void variableInitializer() {
        panel = new JPanel();
        testerlab = new JLabel();
        banerlab = new JLabel();
        idlab = new JLabel();
        statuslab = new JLabel();
        namelab = new JLabel();
        commentlab = new JLabel();
        developerlab = new JLabel();
        idfld = new JTextField();
        namefld = new JTextField();
        desclab = new JLabel();
        prirotylab = new JLabel();
        datelab = new JLabel();
        expectedlab = new JLabel();
        actuallab = new JLabel();
        descarea = new JTextArea();
        expectedarea = new JTextArea();
        actualarea = new JTextArea();
        commentarea = new JTextArea();
        prirotybox = new JComboBox(priroty);
        statusbox = new JComboBox(status);
        backbtn = new JButton();
        updatebtn = new JButton();
        banerfont = new Font("Arial", Font.BOLD, 25);
        labfont = new Font("Arial", Font.BOLD, 15);
        fldfont = new Font("Arial", Font.BOLD, 17);
    }

    private void Body() {
        panel.setBackground(Color.BLACK);
        panel.setBounds(70, 25, 710, 560);
        panel.setLayout(null);
        container.add(panel);

        banerlab.setText("                   BUG INFORMATION");
        banerlab.setBounds(105, 25, 500, 50);
        banerlab.setFont(banerfont);
        banerlab.setForeground(Color.BLACK);
        banerlab.setOpaque(true);
        banerlab.setBackground(Color.ORANGE);
        panel.add(banerlab);

        idlab.setText("  Bug Id");
        idlab.setBounds(20, 100, 145, 35);
        idlab.setFont(labfont);
        idlab.setForeground(Color.WHITE);
        idlab.setOpaque(true);
        idlab.setBackground(Color.BLACK);
        panel.add(idlab);

        idfld.setBounds(175, 100, 285, 35);
        idfld.setText(bug.getBugId());
        idfld.setBorder(null);
        idfld.setEditable(false);
        idfld.setBackground(Color.BLACK);
        idfld.setForeground(Color.WHITE);
        idfld.setFont(labfont);
        panel.add(idfld);

        namelab.setText("  Bug Name");
        namelab.setBounds(20, 145, 145, 35);
        namelab.setFont(labfont);
        namelab.setForeground(Color.WHITE);
        namelab.setOpaque(true);
        namelab.setBackground(Color.BLACK);
        panel.add(namelab);

        namefld.setBounds(175, 145, 285, 35);
        namefld.setText(bug.getName());
        namefld.setBorder(null);
        namefld.setEditable(false);
        namefld.setBackground(Color.BLACK);
        namefld.setForeground(Color.WHITE);
        namefld.setFont(labfont);
        panel.add(namefld);

        desclab.setText("  Description");
        desclab.setBounds(20, 190, 145, 35);
        desclab.setFont(labfont);
        desclab.setForeground(Color.WHITE);
        desclab.setOpaque(true);
        desclab.setBackground(Color.BLACK);
        panel.add(desclab);

        descarea.setBackground(Color.BLACK);
        descarea.setForeground(Color.WHITE);
        descarea.setText(bug.getDescription());
        descarea.setBorder(null);
        descarea.setEditable(false);
        descarea.setLineWrap(true);
        descarea.setWrapStyleWord(true);
        descarea.setFont(labfont);
        scroll = new JScrollPane(descarea);
        scroll.setBorder(null);
        scroll.setBounds(175, 190, 285, 90);
        panel.add(scroll);

        expectedlab.setText("  Expected Outcome");
        expectedlab.setBounds(20, 290, 145, 35);
        expectedlab.setFont(labfont);
        expectedlab.setForeground(Color.WHITE);
        expectedlab.setOpaque(true);
        expectedlab.setBackground(Color.BLACK);
        panel.add(expectedlab);

        expectedarea.setBackground(Color.BLACK);
        expectedarea.setForeground(Color.WHITE);
        expectedarea.setText(bug.getExpected());
        expectedarea.setBorder(null);
        expectedarea.setEditable(false);
        expectedarea.setLineWrap(true);
        expectedarea.setWrapStyleWord(true);
        expectedarea.setFont(labfont);
        scroll = new JScrollPane(expectedarea);
        scroll.setBorder(null);
        scroll.setBounds(175, 290, 285, 60);
        panel.add(scroll);

        actuallab.setText("  Actual Outcome");
        actuallab.setBounds(20, 360, 145, 35);
        actuallab.setFont(labfont);
        actuallab.setForeground(Color.WHITE);
        actuallab.setOpaque(true);
        actuallab.setBackground(Color.BLACK);
        panel.add(actuallab);

        actualarea.setBackground(Color.BLACK);
        actualarea.setForeground(Color.WHITE);
        actualarea.setText(bug.getActual());
        actualarea.setBorder(null);
        actualarea.setEditable(false);
        actualarea.setLineWrap(true);
        actualarea.setWrapStyleWord(true);
        actualarea.setFont(labfont);
        scroll = new JScrollPane(actualarea);
        scroll.setBorder(null);
        scroll.setBounds(175, 360, 285, 60);
        panel.add(scroll);

        commentlab.setText("  Comment");
        commentlab.setBounds(20, 430, 145, 35);
        commentlab.setFont(labfont);
        commentlab.setForeground(Color.WHITE);
        commentlab.setOpaque(true);
        commentlab.setBackground(Color.BLACK);
        panel.add(commentlab);

        commentarea.setBackground(Color.WHITE);
        commentarea.setLineWrap(true);
        commentarea.setWrapStyleWord(true);
        commentarea.setText(bug.getComment());
        commentarea.setFont(fldfont);
        scroll = new JScrollPane(commentarea);
        scroll.setBounds(175, 430, 285, 60);
        panel.add(scroll);

        datelab.setText("  Date : " + bug.getDate());
        datelab.setBounds(470, 100, 145, 35);
        datelab.setFont(labfont);
        datelab.setForeground(Color.WHITE);
        datelab.setOpaque(true);
        datelab.setBackground(Color.BLACK);
        panel.add(datelab);

        prirotylab.setText("  Priroty : " + bug.getPriroty());
        prirotylab.setBounds(470, 145, 200, 35);
        prirotylab.setFont(labfont);
        prirotylab.setForeground(Color.WHITE);
        prirotylab.setOpaque(true);
        prirotylab.setBackground(Color.BLACK);
        panel.add(prirotylab);

        prirotybox.setBounds(590, 145, 110, 35);
        prirotybox.setVisible(false);
        prirotybox.setFont(labfont);
        panel.add(prirotybox);

        statuslab.setText("  Status");
        statuslab.setBounds(470, 255, 120, 35);
        statuslab.setFont(labfont);
        statuslab.setForeground(Color.WHITE);
        statuslab.setOpaque(true);
        statuslab.setBackground(Color.BLACK);
        panel.add(statuslab);

        statusbox.setBounds(590, 255, 110, 35);
        if (bug.getStatus().equalsIgnoreCase("NEW")) {
            statusbox.setSelectedIndex(0);
        } else if (bug.getStatus().equalsIgnoreCase("IN PROGRESS")) {
            statusbox.setSelectedIndex(1);
        } else if (bug.getStatus().equalsIgnoreCase("FIXED")) {
            statusbox.setSelectedIndex(2);
        } else if (bug.getStatus().equalsIgnoreCase("REOPEN")) {
            statusbox.setSelectedIndex(3);
        } else {
            statusbox.setSelectedIndex(4);
        }
        statusbox.setFont(labfont);
        panel.add(statusbox);

        testerlab.setText("  Tester : " + bug.getTesterName());
        testerlab.setBounds(470, 350, 250, 35);
        testerlab.setFont(labfont);
        testerlab.setForeground(Color.WHITE);
        testerlab.setOpaque(true);
        testerlab.setBackground(Color.BLACK);
        panel.add(testerlab);

        developerlab.setText("  Developer : " + bug.getDeveloperName());
        developerlab.setBounds(470, 390, 250, 35);
        developerlab.setFont(labfont);
        developerlab.setForeground(Color.WHITE);
        developerlab.setOpaque(true);
        developerlab.setBackground(Color.BLACK);
        panel.add(developerlab);

        updatebtn.setText("UPDATE");
        updatebtn.setBackground(new Color(255, 0, 0));
        updatebtn.setForeground(Color.BLACK);
        updatebtn.setFont(banerfont);
        panel.add(updatebtn);
        updatebtn.setBounds(390, 500, 150, 45);
        //updatebtn.addMouseListener(this);
        updatebtn.addActionListener(this);

        backbtn.setText("BACK");
        backbtn.setBackground(new Color(0, 153, 255));
        backbtn.setForeground(Color.BLACK);
        backbtn.setFont(banerfont);
        panel.add(backbtn);
        backbtn.setBounds(170, 500, 150, 45);
        //backbtn.addMouseListener(this);
        backbtn.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backbtn) {
            DisplayBug begin = new DisplayBug(user, query, bug.getStatus());
            dispose();
        } else if (ae.getSource() == updatebtn) {
            BugInfoCode obj = new BugInfoCode();
            boolean flag = obj.update(user,bug, commentarea, statusbox);

            if (flag == true) {
                JOptionPane.showMessageDialog(null, "Bug is Updated Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No Internet Connection", "Failed", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
