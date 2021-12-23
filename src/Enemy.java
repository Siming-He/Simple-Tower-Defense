import java.awt.Graphics;
import java.awt.Point;

/**
 * Abstract class for enemy
 * @author Siming He
 *
 */
public abstract class Enemy {

    private int id;
    private int health;
    private int attack;
    private Direction dir;
    private Point location;
    private Point coordinate;
    private int speed;
    private boolean life;
    static int counter = -1;
    
    public Enemy(Direction d, Point c) {
        dir = d;
        coordinate = new Point(c.x, c.y);
        location = Map.coorToPos(coordinate);
        life = true;
    }
    
    //==========================================================================
    // Abstract methods
    //==========================================================================

    public abstract void motion();
    public abstract void moveStep();
    public abstract void getHurt(int damage);
    public abstract void draw(Graphics g);
    
    //==========================================================================
    // Getter and setter methods
    //==========================================================================

    public int getSpeed() {
        return speed;
    }
    
    public void setSpeed(int s) {
        speed = s;
    }
    
    public void setId() {
        id = counter;
        counter += 1;
    }
    
    public int getId() {
        return id;
    }
    
    public int getHealth() {
        return health;
    }
    
    public void setHealth(int h) {
        health = h;
    }
    
    public void setDir(Direction d) {
        dir = d;
    }
    
    public Direction getDir() {
        return dir;
    }
    
    public Point getLocation() {
        return new Point(location.x, location.y);
    }
    
    public Point getCoordinate() {
        return new Point(coordinate.x, coordinate.y);
    }
    
    public void setLocation(Point p) {
        location = p;
    }
    
    public void setCoordination(Point p) {
        coordinate = p;
    }
    
    public boolean getLife() {
        return life;
    }
    
    public void setLife(boolean b) {
        life = b;
    }
    
    public int getAttack() {
        return attack;
    }
    
    public void setAttack(int a) {
        attack = a;
    }
}
