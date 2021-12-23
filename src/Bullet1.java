import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Bullet that target one enemy.
 * @author Siming He
 *
 */
public class Bullet1 extends Bullet {
    Color color = Color.YELLOW;
    
    public Bullet1(Point p) {
        super(p);
        super.setDamage(80);
        super.setSpeed(64);
    }
    
    public void motion(Point p) {
        super.setCurrPos(p);
    }
    
    public int getDamage() {
        return super.getDamage();
    }
    
    public boolean attacked(Point p) {
        return true;
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(this.color);
        g.drawLine(super.getIniPos().x + 16, super.getIniPos().y + 
                16, super.getCurrPos().x + 16, super.getCurrPos().y + 16);
    }
    
}
