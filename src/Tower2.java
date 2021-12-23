import java.awt.*;

/**
 * A type of tower that attacks all enemies in attack range
 * @author Siming He
 *
 */
public class Tower2 extends Tower {

    private Color color = Color.RED;
    private int width = 32;
    private int height = 32;
    private Bullet bl;
    static private int buy = 40;
    static private int sell = 10;
    
    public Tower2(Point p) {
        super(p);
        super.setLoadSpeed(7);
        super.setAttackRange(6);
        bl = new Bullet2(Map.coorToPos(super.getCoor()));
    }
    
    static public int getSell() {
        return sell;
    }
    
    static public int getBuy() {
        return buy;
    }
    
        
    public void updateBullet(boolean b) {
        
    }
    
    public Bullet getBullet() {
        return bl;
    }
    
    public void causeDamage(boolean b) {
        //System.out.println(b);
        
        if (b) {
            bl.motion(null);
            if (bl.attacked(null)) {
                for (Enemy m : super.getEnemies()) {
                    m.getHurt(bl.getDamage());
                } 
            }
        } else {
            ((Bullet2) bl).resetPos();
        }
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
        
        boolean ret = false;
        
        int count = 0;
        super.clearEnemies();

        while (!en.isEmpty() || count < en.getExisitingNum()) {
            Enemy m = en.getEnemy(count);
            if (m != null) {
                Point p = Map.posToCoor(m.getCoordinate());
                if (p.x >= super.getCoor().x - super.getAttackRange() && 
                        p.x <= super.getCoor().x + super.getAttackRange() && 
                        p.y >= super.getCoor().y - super.getAttackRange() && 
                        p.y <= super.getCoor().y + super.getAttackRange() 
                        && !p.equals(new Point(0, 3))) {
                    if (!super.getEnemies().contains(m)) {
                        super.getEnemies().add(m);
                    }
                    ret = true;
                }
                count += 1;
            } else {
                break;
            }
            
        }

        return ret;
    }

    @Override
    public void draw(Graphics g) {
        Color c = new Color(255, 0, 0, 20);
        g.setColor(c);
        g.fillRect(Map.coorToPos(super.getCoor()).x - 6 * width, 
                Map.coorToPos(super.getCoor()).y - 6 * height, 
                13 * width, 13 * height);
        g.setColor(this.color);
        g.fillRect(Map.coorToPos(super.getCoor()).x, 
                Map.coorToPos(super.getCoor()).y, width, height);
        bl.paint(g);
    }
}
