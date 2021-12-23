import java.awt.Color;
import java.awt.Point;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Enemy1Test {

    @Test
    public void getIdTest() {
        Enemy a = new Enemy1(Direction.RIGHT, new Point(0,0));
        Enemy b = new Enemy1(Direction.RIGHT, new Point(0,0));
        int x = a.getId();
        assertEquals(x + 1, b.getId());
        Enemy c = new Enemy1(Direction.RIGHT, new Point(0,0));
        assertEquals(x + 2, c.getId());
    }
    
    @Test
    public void getHurtTestToZero() {
        Enemy a = new Enemy1(Direction.RIGHT, new Point(0,0));
        assertEquals(2000, a.getHealth());
        a.getHurt(5);
        assertEquals(1995, a.getHealth());
        a.getHurt(1995);
        assertEquals(0, a.getHealth());
        assertFalse(a.getLife());
    }
    
    @Test
    public void getHurtTestToNegative() {
        Enemy a = new Enemy1(Direction.RIGHT, new Point(0,0));
        assertEquals(2000, a.getHealth());
        a.getHurt(2100);
        assertEquals(-100, a.getHealth());
        assertFalse(a.getLife());
    }
    
    @Test
    public void moveStepTest() {
        Enemy a = new Enemy1(Direction.RIGHT, Map.coorToPos(new Point(5,3)));
        a.moveStep();
        assertEquals(new Point(6, 3), Map.posToCoor(a.getCoordinate()));
        a.setDir(Direction.DOWN);
        a.moveStep();
        assertEquals(new Point(6, 4), Map.posToCoor(a.getCoordinate()));
        a.setDir(Direction.LEFT);
        a.moveStep();
        assertEquals(new Point(5, 4), Map.posToCoor(a.getCoordinate()));
        a.setDir(Direction.UP);
        a.moveStep();
        assertEquals(new Point(5, 3), Map.posToCoor(a.getCoordinate()));
    }
    
    @Test
    public void motionChangeTest() {
        Map bc = new Map();
        Enemy a = new Enemy1(Direction.RIGHT, Map.coorToPos(new Point(5,3)));
        assertEquals('1', bc.getMapData()[5][3]);
        assertEquals('1', bc.getMapData()[5][4]);
        a.motion();
        assertEquals(Direction.DOWN, a.getDir());
    }
    
    @Test
    public void lifeColorTest() {
        Enemy a = new Enemy1(Direction.RIGHT, Map.coorToPos(new Point(5,3)));
        assertEquals(new Color(0, 0, 255), ((Enemy1)a).lifeColor());
        a.getHurt(2000);
        assertEquals(new Color(0, 255, 0), ((Enemy1)a).lifeColor());
    }
}
