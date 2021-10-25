package Frames;

import Database.RetriveDatabase;
import Entity.Bug;
import Entity.Person;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class DisplayBug extends JFrame implements ActionListener, MouseListener {

    private final Container container;
    private Person user;
    private String query, status;
    private JButton bugButton[], banerButton, backbtn, listen;
    private JPanel panel;
    private LinkedList<Bug> bugs = new LinkedList<>();
    private Font btnfont, banerfont;
    private GridLayout grid;
    private Border bor2, bor3, bor, bor1;
    private JScrollPane scroll;

    public DisplayBug(Person user, String query, String status) {
        this.query = query;
        this.status = status;
        this.setVisible(true);
        this.setTitle(status + " Bugs");
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
        RetriveDatabase obj = new RetriveDatabase();
        obj.getBugs(bugs, query);
        btnfont = new Font("Arial", Font.BOLD, 20);
        banerfont = new Font("Arial", Font.BOLD, 30);
        bugButton = new JButton[bugs.size()];
        banerButton = new JButton();
        backbtn = new JButton();
        panel = new JPanel();
        bor1 = BorderFactory.createLineBorder(Color.WHITE, 4);
        bor2 = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
        bor3 = BorderFactory.createBevelBorder(0, Color.GREEN, Color.ORANGE, Color.RED, Color.BLUE);
        bor = BorderFactory.createCompoundBorder(bor3, bor2);
    }

    private void Body() {

        banerButton.setText(status + " BUGS");
        banerButton.setBackground(Color.ORANGE);
        banerButton.setForeground(Color.BLACK);
        banerButton.setFont(banerfont);
        container.add(banerButton);
        banerButton.setBounds(200, 50, 450, 45);

        if (bugs.size() < 10) {
            grid = new GridLayout(10, 1);
        } else {
            grid = new GridLayout(bugs.size(), 1);
        }
        grid.setVgap(3);
        panel.setLayout(grid);
        panel.setBorder(bor);
        panel.setBackground(Color.BLACK);
        scroll = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(200, 100, 450, 500);
        container.add(scroll);

        for (int i = 0; i < bugs.size(); i++) {
            bugButton[i] = new JButton();
            bugButton[i].setText(bugs.get(i).getName());
            bugButton[i].setBorder(bor1);
            bugButton[i].setFont(btnfont);
            bugButton[i].setBackground(Color.PINK);
            bugButton[i].setToolTipText("" + i);
            bugButton[i].addActionListener(this);
            bugButton[i].addMouseListener(this);
            panel.add(bugButton[i]);
        }

        backbtn.setText("BACK");
        backbtn.setBackground(new Color(0, 153, 255));
        backbtn.setForeground(Color.BLACK);
        backbtn.setFont(banerfont);
        container.add(backbtn);
        backbtn.setBounds(20, 107, 160, 45);
        //backbtn.addMouseListener(this);
        backbtn.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backbtn) {
            MainMenu begin = new MainMenu(user);
            dispose();
        } else {
            listen = (JButton) ae.getSource();
            int index = Integer.parseInt(listen.getToolTipText());
            BugInfo begin = new BugInfo(user, bugs.get(index),query);
            dispose();
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
        listen = (JButton) me.getSource();
        listen.setBackground(Color.RED);
    }

    @Override
    public void mouseExited(MouseEvent me) {
        listen = (JButton) me.getSource();
        listen.setBackground(Color.PINK);
    }
}
