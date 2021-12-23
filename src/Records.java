/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.1, Apr 2017
 */

import java.awt.*;
import javax.swing.*;

/**
 * Class for displaying game states
 * @author Siming He
 *
 */
@SuppressWarnings("serial")
public class Records extends JPanel {

    public static final int COURT_WIDTH = 840;
    public static final int COURT_HEIGHT = 50;
    final JLabel level;
    final JLabel health;
    final JLabel money;
    public Records(GameCourt court) {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        GridLayout btLayout = new GridLayout(1,3);
        setLayout(btLayout);
        
        level = new JLabel();
        health = new JLabel();
        money = new JLabel();
        
        level.setText("  level: " + 0);
        health.setText("  health: " + 0);
        money.setText("  money: " + 0);
        
        add(level);
        add(health);
        add(money);
    }
    
    public void updateRecords(int l, int h, int m) {
        level.setText("  level: " + l);
        health.setText("  health: " + h);
        money.setText("  money: " + m);
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