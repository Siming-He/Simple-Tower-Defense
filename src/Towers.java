import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

/**
 * Records all towers that are built during the game.
 * @author Siming He
 *
 */
public class Towers {
    private List<Tower> towerList;
    
    public Towers() {
        towerList = new LinkedList<Tower>();
    }
    
    public void sellTower(Point p) {
        int x = p.x;
        int y = p.y;
        if (Game.getMap().getMapData()[x][y] == '2' || Game.getMap().getMapData()[x][y] == '3') {
            for (Tower t : towerList) {
                if (t.getCoor().equals(p)) {
                    if (t instanceof Tower1) {
                        Player.gain(Tower1.getSell());
                    } else if (t instanceof Tower2) {
                        Player.gain(Tower2.getSell());
                    }
                    // Map
                    Game.getMap().setMapData('0', p);
                    
                    // Player money

                    // Tower
                    towerList.remove(t);
                    break;
                }
            }
        }
    }
    
    public void reset() {
        towerList.clear();
        char[][] chs = Game.getMap().getMapData();
        for (int i = 0; i < chs.length; i++) {
            for (int j = 0; j < chs[0].length; j++) {
                if (chs[i][j] != '1' && chs[i][j] != '0' && chs[i][j] != '9') {
                    Game.getMap().setMapData('0', new Point(i, j));
                }
            }
        }
    }
    
    public void buildTower1(Point p) {
//        System.out.println("P: " + Player.getMoney());
//        System.out.println("T: " + Tower1.getBuy());
        if (Player.getMoney() >= Tower1.getBuy()) {
            Player.cost(Tower1.getBuy());
            int x = p.x;
            int y = p.y;
            if (Game.getMap().getMapData()[x][y] == '0') {
                // Map
                Game.getMap().setMapData('2', p);
                // Tower
                towerList.add(new Tower1(p));
                // Play Money
            }
        }
    }
    
    public void buildTower2(Point p) {
        if (Player.getMoney() >= Tower2.getBuy()) {
            Player.cost(Tower2.getBuy());
            int x = p.x;
            int y = p.y;
            if (Game.getMap().getMapData()[x][y] == '0') {
                // Map
                Game.getMap().setMapData('3', p);
                // Tower
                towerList.add(new Tower2(p));
                // Play Money
            }
        }
    }
    
    public void towerEnemyUpdate(Enemies em, int time) {
        // Update enemies
        // Cause damage
        if (time >= 50) {
            for (Tower t : towerList) {
                boolean at = t.attackable(em);
                if (t.getBullet().bLoaded(time, t.getLoadSpeed())) {
                    t.causeDamage(at);
                }
            }
        } 
        
        // Check alive
        
        // Update bullet
    }
    
    public void towerPaint(Graphics g) {
        for (Tower t : towerList) {
            t.draw(g);
        }
    }    
    
}
