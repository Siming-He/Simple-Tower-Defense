import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.awt.Point;


public class Tower1Test {
    @Test
    public void getSellTest() {
        assertEquals(10, Tower1.getSell());
    }
    
    @Test
    public void getBuyTest() {
        assertEquals(30, Tower1.getBuy());
    }
    
    @Test
    public void getAttackableFalseTest() {
        Tower1 t = new Tower1(new Point(7,6));
        Enemy em = new Enemy1(Direction.RIGHT, new Point(11,6));
        Enemies ems = new Enemies();
        ems.addEnemy(em);
        assertFalse(t.attackable(ems));
    }
    
    @Test
    public void getAttackanbleTrueTest() {
        Tower1 t = new Tower1(new Point(7,6));
        assertTrue(t.rangeCheck(new Point(8,6)));
    }
    
    @Test
    public void getAttackableLeftBoundTest() {
        Tower1 t = new Tower1(new Point(7,6));
        assertTrue(t.rangeCheck(new Point(4,6)));
    }
    
    @Test
    public void getAttackableRightBoundTest() {
        Tower1 t = new Tower1(new Point(7,6));
        assertTrue(t.rangeCheck(new Point(10,6)));
    }
    
    @Test
    public void getAttackableTopBoundTest() {
        Tower1 t = new Tower1(new Point(7,6));
        assertTrue(t.rangeCheck(new Point(8,9)));
    }
    
    @Test
    public void getAttackableBottomBoundTest() {
        Tower1 t = new Tower1(new Point(7,6));
        assertTrue(t.rangeCheck(new Point(8,3)));
    }
    
    @Test
    public void getAttackableConor1BoundTest() {
        Tower1 t = new Tower1(new Point(7,6));
        assertTrue(t.rangeCheck(new Point(4,3)));
    }
    
    @Test
    public void getAttackableConor2BoundTest() {
        Tower1 t = new Tower1(new Point(7,6));
        assertTrue(t.rangeCheck(new Point(4, 9)));
    }
    
    @Test
    public void getAttackableConor3BoundTest() {
        Tower1 t = new Tower1(new Point(7,6));
        assertTrue(t.rangeCheck(new Point(10,3)));
    }
    
    @Test
    public void getAttackableConor4BoundTest() {
        Tower1 t = new Tower1(new Point(7,6));
        assertTrue(t.rangeCheck(new Point(10,9)));
    }
    
    @Test
    public void getAttackableIniPointTest() {
        Tower1 t = new Tower1(new Point(1,2));
        assertFalse(t.rangeCheck(new Point(0,3)));
    }
    
    @Test
    public void checkBulletTest() {
        Tower1 t = new Tower1(new Point(7,6));
        assertTrue(t instanceof Tower1);
    }
}
