import java.awt.Graphics;
import java.util.List;
import java.awt.Point;
import java.util.LinkedList;

/**
 * Abstract class for tower
 * @author Siming He
 *
 */
public abstract class Tower {
    private List<Enemy> targetedEnemies;
    private Point coor;
    private int attackRange;
    private int bulletLoadSpeed;
    
    public Tower(Point p) {
        coor = p;
        targetedEnemies = new LinkedList<Enemy>();
    }
    
    //==========================================================================
    // Abstract methods
    //==========================================================================

    public abstract void causeDamage(boolean b);
    public abstract void draw(Graphics g);
    public abstract void updateBullet(boolean b);
    public abstract Bullet getBullet();
    
    //==========================================================================
    // Methods
    //==========================================================================

    public boolean attackable(Enemies en) {
        for (Enemy em : en.getEnemies()) {
            if (getDistance(coor, em.getCoordinate()) <= attackRange) {
                return true;
            }
        }
        return false;
    }
    
    //==========================================================================
    // Getter and setter methods
    //==========================================================================
    
    public double getDistance(Point a, Point b) {
        double x = Math.abs(a.x - b.x);
        double y = Math.abs(a.y - b.y);
        return Math.sqrt(x * x + y * y);
    }
    
    public int getAttackRange() {
        return attackRange;
    }
    
    public void setAttackRange(int a) {
        attackRange = a;
    }
    
    public Point getCoor() {
        return coor;
    }
    
    public void setCoor(Point p) {
        coor = p;
    }
    
    public int getLoadSpeed() {
        return bulletLoadSpeed;
    }
    
    public void setLoadSpeed(int b) {
        bulletLoadSpeed = b;
    }
    
    public List<Enemy> getEnemies() {
        return targetedEnemies;
    }
    
    public void addEnemies(Enemy e) {
        targetedEnemies.add(e);
    }
    
    public void clearEnemies() {
        targetedEnemies.clear();
    }
    
}
