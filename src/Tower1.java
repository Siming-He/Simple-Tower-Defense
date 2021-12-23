import java.awt.*;

/**
 * A type of tower that attacks single target.
 * @author Siming He
 *
 */
public class Tower1 extends Tower {

    private Color color = Color.YELLOW;
    private int width = 32;
    private int height = 32;
    private Bullet bl;
    static private int buy = 30;
    static private int sell = 10;
    
    public Tower1(Point p) {
        super(p);
        super.setLoadSpeed(3);
        super.setAttackRange(3);
        bl = new Bullet1(Map.coorToPos(super.getCoor()));
    }
    
    static public int getSell() {
        return sell;
    }
    
    static public int getBuy() {
        return buy;
    }
    
    
    public void causeDamage(boolean b) {
        if (b) {
            Point p = super.getEnemies().get(0).getCoordinate();
            bl.motion(p);
            if (bl.attacked(p)) {
                for (Enemy m : super.getEnemies()) {
                    m.getHurt(bl.getDamage());
                } 
            }
        } else {
            bl.resetPos();
        }
    }
    
    public Bullet getBullet() {
        return bl;
    }
    
    public void updateBullet(boolean b) {
        
    }
    
    public boolean rangeCheck(Point p) {
        boolean flag = false;
        if (p.x >= super.getCoor().x - super.getAttackRange() && 
                p.x <= super.getCoor().x + super.getAttackRange() && 
                        p.y >= super.getCoor().y - super.getAttackRange() && 
                        p.y <= super.getCoor().y + super.getAttackRange() && 
                        !p.equals(new Point(0, 3))) {
            flag = true;
        }
        return flag;
    }
    
    @Override
    public boolean attackable(Enemies en) {
        //TODO
        
        if (en == null) {
            return false;
        }
        
        int count = 0;
        
        while (!en.isEmpty() || count < en.getExisitingNum()) {
            Enemy m = en.getEnemy(count);
            if (m != null) {
                Point p = Map.posToCoor(m.getCoordinate());
                if (rangeCheck(p)) {
                    super.clearEnemies();
                    super.addEnemies(m);
                    return true;
                }
                count += 1;
            } else {
                return false;
            }
        }
        
        // Monster in range
        // Bullet loaded
        return false;
    }
    
    @Override
    public void draw(Graphics g) {
        Color c = new Color(255, 255, 0, 20);
        g.setColor(c);
        g.fillRect(Map.coorToPos(super.getCoor()).x - 3 * width, Map.coorToPos(super.getCoor()).y 
                - 3 * height, 
                7 * width, 7 * height);
        g.setColor(this.color);
        g.fillRect(Map.coorToPos(super.getCoor()).x, Map.coorToPos(super.getCoor()).y, width, 
                height);
        
        bl.paint(g);
    }
}
