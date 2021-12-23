import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Provide guide for the game
 * @author Siming He
 *
 */
@SuppressWarnings("serial")
public class GameGuide extends JFrame {
    static GraphicsConfiguration gc;
    private int pageNum = 0;
    static final int TOTALNUM = 8;
    private String folderPath = "files/";
    static private BufferedImage[] imgs = new BufferedImage[TOTALNUM];
    private JLabel imgLabel;
    final JPanel photos;
    
    public GameGuide() {
        super("Game Guide");
        
        try {
            for (int i = 0; i < TOTALNUM; i++) {
                imgs[i] = ImageIO.read(new File(folderPath + i + ".png"));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        photos = new JPanel();
        photos.setSize(new Dimension(680, 680));
        photos.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        imgLabel = new JLabel(new ImageIcon(imgs[pageNum]));
        photos.add(imgLabel);
        
        final JButton prev = new JButton("Prev");
        prev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                prev();
            }
        });
        prev.setSize(new Dimension(50, 680));
        
        final JButton nxt = new JButton("Next");
        nxt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                next();
            }
        });
        nxt.setSize(new Dimension(50, 680));
        
        add(photos, BorderLayout.CENTER);
        add(prev, BorderLayout.LINE_START);
        add(nxt, BorderLayout.LINE_END);
    }
    
    private void prev() {
        if (pageNum > 0) {
            pageNum -= 1;
        }
        imgLabel = new JLabel(new ImageIcon(imgs[pageNum]));
        photos.removeAll();
        photos.add(imgLabel);
        photos.updateUI();
    }
    
    private void next() {
        if (pageNum < TOTALNUM - 1) {
            pageNum += 1;
        }
        imgLabel = new JLabel(new ImageIcon(imgs[pageNum]));
        photos.removeAll();
        photos.add(imgLabel);
        photos.updateUI();
    }
}
