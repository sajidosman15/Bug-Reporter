package Frames;

import Entity.Person;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JFrame implements MouseListener, ActionListener {

    private final Container container;
    private Person User;
    private JPanel panel;
    private JLabel banerlab, buglab;
    private Font banerfont;
    private JButton createBug, newBug, inProgressBug, fixedBug, reopenBug, closedBug, logOut;
    private String query;

    public MainMenu(Person User) {
        this.setVisible(true);
        this.setTitle("Bug Reporter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(850, 650);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        container = this.getContentPane();
        container.setBackground(new java.awt.Color(0, 51, 51));
        container.setLayout(null);
        this.User = User;
        variableInitializer();
        Body();
    }

    private void variableInitializer() {
        panel = new JPanel();
        banerfont = new Font("Arial", Font.BOLD, 25);
        banerlab = new JLabel();
        buglab = new JLabel();
        createBug = new JButton();
        newBug = new JButton();
        inProgressBug = new JButton();
        fixedBug = new JButton();
        reopenBug = new JButton();
        closedBug = new JButton();
        logOut = new JButton();
    }

    private void Body() {

        panel.setBackground(Color.BLACK);
        panel.setBounds(200, 25, 450, 560);
        panel.setLayout(null);
        container.add(panel);

        banerlab.setText("  WELCOME TO BUG REPORTER");
        banerlab.setBounds(20, 25, 410, 50);
        banerlab.setFont(banerfont);
        banerlab.setForeground(Color.BLACK);
        banerlab.setOpaque(true);
        banerlab.setBackground(Color.ORANGE);
        panel.add(banerlab);

        createBug.setText("CREATE NEW BUG");
        createBug.setBackground(Color.RED);
        createBug.setForeground(Color.BLACK);
        createBug.setFont(banerfont);
        panel.add(createBug);
        createBug.setBounds(50, 90, 350, 45);
        createBug.addMouseListener(this);
        createBug.addActionListener(this);

        buglab.setText("               EXISTING BUGS");
        buglab.setBounds(20, 150, 410, 50);
        buglab.setFont(banerfont);
        buglab.setForeground(Color.BLACK);
        buglab.setOpaque(true);
        buglab.setBackground(Color.ORANGE);
        panel.add(buglab);

        newBug.setText("NEW BUG");
        newBug.setBackground(Color.RED);
        newBug.setForeground(Color.BLACK);
        newBug.setFont(banerfont);
        panel.add(newBug);
        newBug.setBounds(50, 215, 350, 45);
        newBug.addMouseListener(this);
        newBug.addActionListener(this);

        inProgressBug.setText("IN PROGRESS BUG");
        inProgressBug.setBackground(Color.RED);
        inProgressBug.setForeground(Color.BLACK);
        inProgressBug.setFont(banerfont);
        panel.add(inProgressBug);
        inProgressBug.setBounds(50, 270, 350, 45);
        inProgressBug.addMouseListener(this);
        inProgressBug.addActionListener(this);

        fixedBug.setText("FIXED BUG");
        fixedBug.setBackground(Color.RED);
        fixedBug.setForeground(Color.BLACK);
        fixedBug.setFont(banerfont);
        panel.add(fixedBug);
        fixedBug.setBounds(50, 325, 350, 45);
        fixedBug.addMouseListener(this);
        fixedBug.addActionListener(this);

        reopenBug.setText("REOPENED BUG");
        reopenBug.setBackground(Color.RED);
        reopenBug.setForeground(Color.BLACK);
        reopenBug.setFont(banerfont);
        panel.add(reopenBug);
        reopenBug.setBounds(50, 380, 350, 45);
        reopenBug.addMouseListener(this);
        reopenBug.addActionListener(this);

        closedBug.setText("CLOSED BUG");
        closedBug.setBackground(Color.RED);
        closedBug.setForeground(Color.BLACK);
        closedBug.setFont(banerfont);
        panel.add(closedBug);
        closedBug.setBounds(50, 435, 350, 45);
        closedBug.addMouseListener(this);
        closedBug.addActionListener(this);

        logOut.setText("LOG OUT");
        logOut.setBackground(new Color(0, 153, 255));
        logOut.setForeground(Color.BLACK);
        logOut.setFont(banerfont);
        panel.add(logOut);
        logOut.setBounds(120, 495, 210, 45);
        logOut.addMouseListener(this);
        logOut.addActionListener(this);

        if (User.getRole().equalsIgnoreCase("Developer")) {
            createBug.setVisible(false);
            panel.setBounds(200, 25, 450, 560);
            buglab.setBounds(20, 100, 410, 50);
            newBug.setBounds(50, 175, 350, 45);
            inProgressBug.setBounds(50, 235, 350, 45);
            fixedBug.setBounds(50, 295, 350, 45);
            reopenBug.setBounds(50, 355, 350, 45);
            closedBug.setBounds(50, 415, 350, 45);
            logOut.setBounds(120, 485, 210, 45);
        }
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
        JButton button = (JButton) me.getSource();
        button.setBackground(Color.yellow);
    }

    @Override
    public void mouseExited(MouseEvent me) {
        JButton button = (JButton) me.getSource();
        if (me.getSource() == logOut) {
            logOut.setBackground(new Color(0, 153, 255));
        } else {
            button.setBackground(Color.RED);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == logOut) {
            LogIn back = new LogIn();
            dispose();
        } else if (ae.getSource() == createBug) {
            CreateBug begin = new CreateBug(User);
            dispose();
        } else if (ae.getSource() == newBug) {
            query = "SELECT * FROM `bugs` WHERE Status='new'";
            DisplayBug begin = new DisplayBug(User, query, "NEW");
            dispose();
        } else if (ae.getSource() == inProgressBug) {
            query = "SELECT * FROM `bugs` WHERE Status='IN PROGRESS'";
            DisplayBug begin = new DisplayBug(User, query, "IN PROGRESS");
            dispose();
        } else if (ae.getSource() == fixedBug) {
            query = "SELECT * FROM `bugs` WHERE Status='FIXED'";
            DisplayBug begin = new DisplayBug(User, query, "FIXED");
            dispose();
        } else if (ae.getSource() == reopenBug) {
            query = "SELECT * FROM `bugs` WHERE Status='REOPEN'";
            DisplayBug begin = new DisplayBug(User, query, "REOPEN");
            dispose();
        } else if (ae.getSource() == closedBug) {
            query = "SELECT * FROM `bugs` WHERE Status='CLOSE'";
            DisplayBug begin = new DisplayBug(User, query, "CLOSE");
            dispose();
        }
    }
}
