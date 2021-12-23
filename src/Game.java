/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * Author: Siming He
 * @version 2.1, Apr 2017
 */

// imports necessary libraries for Java swing
import java.awt.*;
import javax.swing.*;

/**
 * Game Main class that specifies the frame and widgets of the GUI
 */
public class Game implements Runnable {
    static private Map bc = new Map();
    static final private GameCourt COURT = new GameCourt();  
    static final private Records RECORDS = new Records(COURT);
    
    public void run() {
        // NOTE : recall that the 'final' keyword notes immutability even for local variables.

        // Top-level frame in which game components live
        // Be sure to change "TOP LEVEL FRAME" to the name of your game
        final JFrame frame = new JFrame("Tower Defense");
        frame.setLocation(300, 500);

        // Main playing area
        
        frame.add(COURT, BorderLayout.LINE_START);
        
        // Navbar
        final Navbar bar = new Navbar(COURT);
        frame.add(bar, BorderLayout.PAGE_START);
        
        // Player Records
        RECORDS.updateRecords(COURT.getLevel(), Player.getHealth(), Player.getMoney());
        frame.add(RECORDS, BorderLayout.PAGE_END);
        
        // Tool Bar
        final ToolBar tools = new ToolBar(COURT);
        frame.add(tools, BorderLayout.LINE_END);
        
        // Put the frame on the screen
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Start game
        COURT.reset();
    }
    
    static public Records getRecords() {
        return RECORDS;
    }
    
    static public Map getMap() {
        return bc;
    }
    
    /**
     * Main method run to start and run the game. Initializes the GUI elements specified in Game and
     * runs it. IMPORTANT: Do NOT delete! You MUST include this in your final submission.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Game());
    }
}