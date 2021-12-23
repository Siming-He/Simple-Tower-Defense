/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.1, Apr 2017
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Diplaying buttons to build and sell towers
 * @author Siming He
 *
 */
@SuppressWarnings("serial")
public class ToolBar extends JPanel {

    public static final int COURT_WIDTH = 200;
    public static final int COURT_HEIGHT = 640;

    public ToolBar(GameCourt court) {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        GridLayout btLayout = new GridLayout(3,1);
        setLayout(btLayout);
        
        final JButton t1 = new JButton("Buy Tower 1 ($30)");
        t1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                court.buyT1();
            }
        });
        t1.setPreferredSize(new Dimension(150, 50));
        
        final JButton t2 = new JButton("Buy Tower 2 ($40)");
        t2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                court.buyT2();
            }
        });
        t2.setPreferredSize(new Dimension(150, 50));
        
        
        final JButton sellT = new JButton("Sell ($10)");
        sellT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                court.sellTower();
            }
        });
        sellT.setPreferredSize(new Dimension(150, 50));
        
        add(t1);
        add(t2);
        add(sellT);
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