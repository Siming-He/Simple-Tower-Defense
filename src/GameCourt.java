/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.1, Apr 2017
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * GameCourt
 * 
 * This class holds the primary game logic for how different objects interact with one another. Take
 * time to understand how the timer interacts with the different methods and how it repaints the GUI
 * on every tick().
 */
@SuppressWarnings("serial")
public class GameCourt extends JPanel {

    // the state of the game logic

    private boolean playing = false; // whether the game is running 

    private Point towerPos;
    
    private int level; 
    
    // Game constants
    public static final int COURT_WIDTH = 640;
    public static final int COURT_HEIGHT = 640;
    public static final int SQUARE_VELOCITY = 4;

    // Update interval for timer, in milliseconds
    public static final int INTERVAL = 100;
      
    private Enemies em = new Enemies();
    private Towers tw = new Towers();
    
    int timeTrack = 0;
    
    public GameCourt() {
        // creates border around the court area, JComponent method
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        em.setLevel1();
        level = 1;
        Timer timer = new Timer(INTERVAL, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        });
        timer.start(); // MAKE SURE TO START THE TIMER!
        
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                towerPos = Map.posToCoor(new Point(e.getX(), e.getY()));
            }
        });

    }
    
    public void gameGuide() {
        JFrame guideFrame = new GameGuide();
        guideFrame.setLocation(700, 500);
        guideFrame.setSize(new Dimension(780, 680));
        guideFrame.setVisible(true);
    }
    
    /**
     * (Re-)set the game to its initial state.
     */
    public void reset() {
        playing = false;
        Player.setStatus(Status.RESETING);
        timeTrack = 0;
        em.setLevel1();
        level = 1;
        tw.reset();
        Player.reset();
        Game.getRecords().updateRecords(level, Player.getHealth(), Player.getMoney());
        repaint();
        requestFocusInWindow();
    }

    public void start() {
        tw.reset();
        Player.reset();
        Game.getRecords().updateRecords(level, Player.getHealth(), Player.getMoney());
        Player.setStatus(Status.BEGINNING);
        playing = true;
    }

    public void buyT1() {
        if (towerPos != null) {
            int x = towerPos.x;
            int y = towerPos.y;
            
            if (towerPos != null && Game.getMap().getMapData()[x][y] == '0') {
                tw.buildTower1(towerPos);
            }
        }
    }
    
    public void buyT2() {
        if (towerPos != null) {
            int x = towerPos.x;
            int y = towerPos.y;
            
            if (towerPos != null && Game.getMap().getMapData()[x][y] == '0') {
                tw.buildTower2(towerPos);
            }
        }
    }
    
    public void sellTower() {
        if (towerPos != null) {
            if (towerPos != null) {
                tw.sellTower(towerPos);
            }
        }
    }
    
    public int getLevel() {
        return level;
    }
    
    /**
     * This method is called every time the timer defined in the constructor triggers.
     */
    void tick() {
        
        if (playing) {
            if (timeTrack == 250) {
                em.setLevel2();
                level = 2;
            } else if (timeTrack == 450) {
                em.setLevel3();
                level = 3;
            }
            timeTrack += 1;
            em.updateEnemies(timeTrack);
            tw.towerEnemyUpdate(em, timeTrack);
            
            Game.getRecords().updateRecords(level, Player.getHealth(), Player.getMoney());
            
            if (Player.getHealth() <= 0) {
                this.reset();
                Player.setStatus(Status.LOSSING);
            } else if (level == 3 && em.getEnemies().isEmpty()) {
                this.reset();
                Player.setStatus(Status.WINNING);
            }
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Game.getMap().getMapImg(), 0, 0, null);
        
        if (towerPos != null) {
            if (Game.getMap().getMapData()[towerPos.x][towerPos.y] == '0') {
                //System.out.println(towerPos.x + " " + towerPos.y);
                g.setColor(Color.GRAY);
                Point temp = Map.coorToPos(new Point(towerPos.x, towerPos.y));
                g.fillRect(temp.x, temp.y, 32, 32);
            }
        }
        tw.towerPaint(g);
        
        em.enemyPaint(g);
        
        if (Player.getStatus().equals(Status.WINNING)) {
            Color c = new Color(255, 255, 255, 100);
            g.setColor(c);
            g.fillRect(0, 0, COURT_WIDTH, COURT_HEIGHT);
            g.setColor(Color.BLACK);
            Font font = new Font("SansSerif", 1, 50);
            g.setFont(font); 
            g.drawString("YOU WIN!!!", 200, 300);
        } else if (Player.getStatus().equals(Status.LOSSING)) {
            Color c = new Color(255, 255, 255, 100);
            g.setColor(c);
            g.fillRect(0, 0, COURT_WIDTH, COURT_HEIGHT);
            g.setColor(Color.BLACK);
            Font font = new Font("SansSerif", 1, 50);
            g.setFont(font); 
            g.drawString("YOU LOSE!!!", 200, 300);
        } else if (Player.getStatus().equals(Status.RESETING)) {
            Color c = new Color(255, 255, 255, 100);
            g.setColor(c);
            g.fillRect(0, 0, COURT_WIDTH, COURT_HEIGHT);
            g.setColor(Color.BLACK);
            Font font = new Font("SansSerif", 1, 50);
            g.setFont(font); 
            g.drawString("Press Start", 200, 300);
        }
        
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(COURT_WIDTH, COURT_HEIGHT);
    }
}