package Frames;

import Controller.CreateBugCode;
import Entity.Person;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.swing.JButton;

public class CreateBug extends JFrame implements MouseListener, ActionListener {

    private final Container container;
    private JPanel panel;
    private JLabel idlab, namelab, desclab, expectedlab, actuallab, datelab, commentlab, prirotylab, statuslab, banerlab;
    private JTextField idfld, namefld;
    private JTextArea descarea, expectedarea, actualarea, commentarea;
    private JComboBox prirotybox, statusbox;
    private Font banerfont, labfont, fldfont;
    private JScrollPane scroll;
    private JButton submitbtn, backbtn;
    private String priroty[] = {"LOW", "MEDIUM", "HIGH"};
    private String status[] = {"NEW", "IN PROGRESS", "FIXED", "REOPEN", "CLOSE"};
    private String date;
    private Person user;

    public CreateBug(Person user) {
        this.setVisible(true);
        this.setTitle("Create New Bug");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(850, 650);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        container = this.getContentPane();
        container.setBackground(new java.awt.Color(0, 51, 51));
        container.setLayout(null);
        this.user = user;
        variableInitializer();
        Body();
    }

    private void variableInitializer() {
        panel = new JPanel();
        banerfont = new Font("Arial", Font.BOLD, 30);
        labfont = new Font("Arial", Font.BOLD, 15);
        fldfont = new Font("Arial", Font.BOLD, 17);
        banerlab = new JLabel();
        idlab = new JLabel();
        namelab = new JLabel();
        desclab = new JLabel();
        expectedlab = new JLabel();
        actuallab = new JLabel();
        datelab = new JLabel();
        commentlab = new JLabel();
        prirotylab = new JLabel();
        statuslab = new JLabel();
        idfld = new JTextField();
        namefld = new JTextField();
        descarea = new JTextArea();
        expectedarea = new JTextArea();
        actualarea = new JTextArea();
        commentarea = new JTextArea();
        prirotybox = new JComboBox(priroty);
        statusbox = new JComboBox(status);
        submitbtn = new JButton();
        backbtn = new JButton();
    }

    private void Body() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        date = dtf.format(now);

        panel.setBackground(Color.BLACK);
        panel.setBounds(70, 25, 710, 560);
        panel.setLayout(null);
        container.add(panel);

        banerlab.setText("     CREATE NEW BUG REPORT");
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
        idfld.setFont(fldfont);
        panel.add(idfld);

        namelab.setText("  Bug Name");
        namelab.setBounds(20, 145, 145, 35);
        namelab.setFont(labfont);
        namelab.setForeground(Color.WHITE);
        namelab.setOpaque(true);
        namelab.setBackground(Color.BLACK);
        panel.add(namelab);

        namefld.setBounds(175, 145, 285, 35);
        namefld.setFont(fldfont);
        panel.add(namefld);

        desclab.setText("  Description");
        desclab.setBounds(20, 190, 145, 35);
        desclab.setFont(labfont);
        desclab.setForeground(Color.WHITE);
        desclab.setOpaque(true);
        desclab.setBackground(Color.BLACK);
        panel.add(desclab);

        descarea.setBackground(Color.WHITE);
        descarea.setLineWrap(true);
        descarea.setWrapStyleWord(true);
        descarea.setFont(fldfont);
        scroll = new JScrollPane(descarea);
        scroll.setBounds(175, 190, 285, 90);
        panel.add(scroll);

        expectedlab.setText("  Expected Outcome");
        expectedlab.setBounds(20, 290, 145, 35);
        expectedlab.setFont(labfont);
        expectedlab.setForeground(Color.WHITE);
        expectedlab.setOpaque(true);
        expectedlab.setBackground(Color.BLACK);
        panel.add(expectedlab);

        expectedarea.setBackground(Color.WHITE);
        expectedarea.setLineWrap(true);
        expectedarea.setWrapStyleWord(true);
        expectedarea.setFont(fldfont);
        scroll = new JScrollPane(expectedarea);
        scroll.setBounds(175, 290, 285, 60);
        panel.add(scroll);

        actuallab.setText("  Actual Outcome");
        actuallab.setBounds(20, 360, 145, 35);
        actuallab.setFont(labfont);
        actuallab.setForeground(Color.WHITE);
        actuallab.setOpaque(true);
        actuallab.setBackground(Color.BLACK);
        panel.add(actuallab);

        actualarea.setBackground(Color.WHITE);
        actualarea.setLineWrap(true);
        actualarea.setWrapStyleWord(true);
        actualarea.setFont(fldfont);
        scroll = new JScrollPane(actualarea);
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
        commentarea.setFont(fldfont);
        scroll = new JScrollPane(commentarea);
        scroll.setBounds(175, 430, 285, 60);
        panel.add(scroll);

        datelab.setText("  Date : " + date);
        datelab.setBounds(470, 100, 145, 35);
        datelab.setFont(labfont);
        datelab.setForeground(Color.WHITE);
        datelab.setOpaque(true);
        datelab.setBackground(Color.BLACK);
        panel.add(datelab);

        prirotylab.setText("  Choose Priroty");
        prirotylab.setBounds(470, 145, 120, 35);
        prirotylab.setFont(labfont);
        prirotylab.setForeground(Color.WHITE);
        prirotylab.setOpaque(true);
        prirotylab.setBackground(Color.BLACK);
        panel.add(prirotylab);

        prirotybox.setBounds(590, 145, 110, 35);
        prirotybox.setFont(labfont);
        panel.add(prirotybox);

        statuslab.setText("  Choose Status");
        statuslab.setBounds(470, 255, 120, 35);
        statuslab.setFont(labfont);
        statuslab.setForeground(Color.WHITE);
        statuslab.setOpaque(true);
        statuslab.setBackground(Color.BLACK);
        panel.add(statuslab);

        statusbox.setBounds(590, 255, 110, 35);
        statusbox.setFont(labfont);
        panel.add(statusbox);

        submitbtn.setText("SUBMIT");
        submitbtn.setBackground(new Color(255, 0, 0));
        submitbtn.setForeground(Color.BLACK);
        submitbtn.setFont(banerfont);
        panel.add(submitbtn);
        submitbtn.setBounds(390, 500, 150, 45);
        submitbtn.addMouseListener(this);
        submitbtn.addActionListener(this);

        backbtn.setText("BACK");
        backbtn.setBackground(new Color(0, 153, 255));
        backbtn.setForeground(Color.BLACK);
        backbtn.setFont(banerfont);
        panel.add(backbtn);
        backbtn.setBounds(170, 500, 150, 45);
        backbtn.addMouseListener(this);
        backbtn.addActionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == submitbtn) {
            submitbtn.setBackground(Color.YELLOW);
        } else if (me.getSource() == backbtn) {
            backbtn.setBackground(Color.YELLOW);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == submitbtn) {
            submitbtn.setBackground(new Color(255, 0, 0));
        } else if (me.getSource() == backbtn) {
            backbtn.setBackground(new Color(0, 153, 255));
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backbtn) {
            MainMenu begin = new MainMenu(user);
            dispose();
        } else if (ae.getSource() == submitbtn) {
            CreateBugCode check = new CreateBugCode(idfld, namefld, descarea, expectedarea, actualarea, commentarea, date, prirotybox, statusbox, user);
            boolean flag = check.checkAll();
            if (flag == true) {
                boolean flag2 = check.insertInDatabase();
                if (flag2 == true) {
                    MainMenu begin = new MainMenu(user);
                    dispose();
                }
            }
        }
    }
}
