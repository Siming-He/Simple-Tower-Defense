/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.1, Apr 2017
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * the navigation bar of the game
 * @author Siming He
 *
 */
@SuppressWarnings("serial")
public class Navbar extends JPanel {

    public static final int COURT_WIDTH = 840;
    public static final int COURT_HEIGHT = 50;
    //private Status gameStatus = Status.BeginSt;

    public Navbar(GameCourt court) {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        GridLayout btLayout = new GridLayout(1,3);
        setLayout(btLayout);
        
        final JButton start = new JButton("Start");
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                court.start();
            }
        });
        start.setPreferredSize(new Dimension(150, 50));
        
        final JButton reset = new JButton("Reset");
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                court.reset();
            }
        });
        reset.setPreferredSize(new Dimension(150, 50));
        
        final JButton guide = new JButton("Game Guide");
        guide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                court.gameGuide();
            }
        });
        guide.setPreferredSize(new Dimension(150, 50));
        
        add(start);
        add(reset);
        add(guide);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(COURT_WIDTH, COURT_HEIGHT);
    }
}