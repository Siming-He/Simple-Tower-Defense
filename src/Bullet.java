import java.awt.Graphics;
import java.awt.Point;
import java.util.Collections;
import java.util.List;

/**
 * The {@code Users} Abstract class of bullets.
 */
public abstract class Bullet {
    private Enemies em;
    private int damage;
    private int speed;
    private Point currPos;
    private Point iniPos;
    private int time = 0; 
    
    /**
     * Constructor
     */
    public Bullet(Point p) {
        iniPos = new Point(p.x, p.y);
        currPos = new Point(p.x, p.y);
        em = new Enemies();
    }
    
    /**
     * Check if bullet is loaded
     * @param t
     * @param loadTime
     * @return
     */
    public boolean bLoaded(int t, int loadTime) {
        if (t - time > loadTime) {
            t = time;
            return true;
        } else {
            return false;
        }
    }
    
    //==========================================================================
    // Getter and setter methods
    //==========================================================================

    public abstract void paint(Graphics g);
    public abstract void motion(Point p);
    public abstract boolean attacked(Point p);
    
    
    //==========================================================================
    // Getter and setter methods
    //==========================================================================

    public int getSpeed() {
        return speed;
    }
    
    public void setSpeed(int s) {
        speed = s;
    }
    
    public Point getCurrPos() {
        return currPos;
    }
    
    public void setCurrPos(Point p) {
        currPos = p;
    }
    
    public Point getIniPos() {
        return iniPos;
    }
    
    public void setIniPos(Point p) {
        iniPos = p;
    }
    
    public int getTime() {
        return time;
    }
    
    public void setTime(int t) {
        time = t;
    }
    
    public List<Enemy> getEnemies() {
        return Collections.unmodifiableList(em.getEnemies());
    }
    
    public void setEnemies(Enemies em) {
        this.em = em;
    }
    
    public int getDamage() {
        return damage;
    }
    
    public void setDamage(int d) {
        damage = d;
    }
    
    public void resetPos() {
        currPos = new Point(iniPos.x, iniPos.y);
    }
}
