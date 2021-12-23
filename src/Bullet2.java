import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Bullet that target all enemies in attack range.
 * @author Siming He
 *
 */
public class Bullet2 extends Bullet {
    Color color = Color.RED;
    private int width = 32;
    private int height = 32;
    private boolean attacking;
    
    public Bullet2(Point p) {
        super(p);
        super.setDamage(20);
        super.setSpeed(64);
        attacking = false;
    }
    
    public void motion(Point p) {
        attacking = true;
    }
    
    public boolean attacked(Point p) {
        return true;
    }
    
    @Override
    public void resetPos() {
        attacking = false;
    }
    
    @Override
    public void paint(Graphics g) {
        if (attacking) {
            Color c = new Color(255, 0, 0, 60);
            g.setColor(c);
            g.fillRect(super.getIniPos().x - 6 * width, super.getIniPos().y - 6 * height, 
                    13 * width, 13 * height);
        } else {
            Color c = new Color(255, 0, 0, 0);
            g.setColor(c);
            g.fillRect(super.getIniPos().x - 6 * width, super.getIniPos().y - 6 * height, 
                    13 * width, 13 * height);
        }
    }
    
}
