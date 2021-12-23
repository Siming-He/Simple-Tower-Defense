import java.awt.Graphics;
import java.awt.Point;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Record data of enemies in the game. Updating enemies' position and 
 * health. Set different groups of enemies for different game level.
 * @author Siming He
 *
 */
public class Enemies {
    private List<Enemy> enemyList;
    private int frequency;
    private int monsterNum;
    private int exisitingNum;
    
    public Enemies() {
        enemyList = new LinkedList<Enemy>();
        frequency = 0;
        monsterNum = 0;
        exisitingNum = 0;
    }
    
    //==========================================================================
    // Game Levels
    //==========================================================================

    public void setLevel1() {
        enemyList.clear();
        exisitingNum = 0;
        monsterNum = 5;
        for (int i = 0; i < monsterNum; i++) {
            enemyList.add(new Enemy1(Direction.RIGHT, Map.coorToPos(new Point(0,3)))); 
        }
        frequency = 10;
    }
    
    public void setLevel2() {
        enemyList.clear();
        exisitingNum = 0;
        monsterNum = 20;
        for (int i = 0; i < monsterNum; i++) {
            enemyList.add(new Enemy1(Direction.RIGHT, Map.coorToPos(new Point(0,3)))); 
        }
        frequency = 7;
    }
    
    public void setLevel3() {
        enemyList.clear();
        exisitingNum = 0;
        monsterNum = 40;
        for (int i = 0; i < monsterNum; i++) {
            enemyList.add(new Enemy1(Direction.RIGHT, Map.coorToPos(new Point(0,3)))); 
        }
        frequency = 4;
    }
    
    //==========================================================================
    // Updating enemies
    //==========================================================================

    public int getExisitingNum() {
        return exisitingNum;
    }
    
    public boolean isEmpty() {
        return (enemyList.size() == 0);
    }
    
    private void updating(int time) {
        List<Enemy> enemyDeath = new LinkedList<Enemy>();
        
        for (Enemy enem : enemyList) {
            if (!enem.getLife()) {
                Player.gain(((Enemy1)enem).getValue());
                enemyDeath.add(enem);
                exisitingNum -= 1;
                monsterNum -= 1;
            } else if (((Enemy1)enem).isPassed()) {
                Player.lossHealth(enem.getAttack());
                enemyDeath.add(enem);
                exisitingNum -= 1;
                monsterNum -= 1;
            }
        }
        
        for (Enemy enem : enemyDeath) {
            enemyList.remove(enem);
        }
        
        exisitingNum = (exisitingNum > enemyList.size()) ? enemyList.size() : exisitingNum;
        
        for (int i = 0; i < exisitingNum; i++) {
            enemyList.get(i).motion();
        }
    }
    
    public void updateEnemies(int time) {
        if (time >= 50 && time < 250) {
            if (exisitingNum < monsterNum) {
                exisitingNum = (time - 50) / frequency; 
            } else {
                exisitingNum = monsterNum;
            }
            updating(time);
        } else if  (time >= 250 && time < 450) {
            if (exisitingNum < monsterNum) {
                exisitingNum = (time - 250) / frequency; 
            } else {
                exisitingNum = monsterNum;
            }
            updating(time);
        } else if  (time >= 450) {
            if (exisitingNum < monsterNum) {
                exisitingNum = (time - 450) / frequency; 
            } else {
                exisitingNum = monsterNum;
            }
            updating(time);
        }
    }
    
    public void addEnemy(Enemy addedEm) {
        enemyList.add(addedEm);
    }
    
    public void enemyPaint(Graphics g) {
        for (int i = 0; i < exisitingNum; i++) {
            enemyList.get(i).draw(g);
        }
    }
    
    //==========================================================================
    // Getter and setter methods
    //==========================================================================

    public List<Enemy> getEnemies() {
        return Collections.unmodifiableList(enemyList);
    }
    
    protected void setExisting() {
        exisitingNum = 1;
    }
    
    public Enemy getEnemy(int i) {
        if (i < monsterNum && i >= 0) {
            return enemyList.get(i);
        } else {
            return null; 
        }
    }    
}
