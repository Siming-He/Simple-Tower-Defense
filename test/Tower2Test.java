import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.awt.Point;


public class Tower2Test {
    @Test
    public void getSellTest() {
        assertEquals(10, Tower2.getSell());
    }
    
    @Test
    public void getBuyTest() {
        assertEquals(40, Tower2.getBuy());
    }
    
    @Test
    public void getAttackableFalseTest() {
        Tower2 t = new Tower2(new Point(7,6));
        Enemy em = new Enemy1(Direction.RIGHT, new Point(14,6));
        Enemies ems = new Enemies();
        ems.addEnemy(em);
        assertFalse(t.attackable(ems));
    }
    
    @Test
    public void getAttackanbleTrueTest() {
        Tower2 t = new Tower2(new Point(7,6));
        assertTrue(t.rangeCheck(new Point(8,6)));
    }
    
    @Test
    public void getAttackableLeftBoundTest() {
        Tower2 t = new Tower2(new Point(7,6));
        assertTrue(t.rangeCheck(new Point(1,6)));
    }
    
    @Test
    public void getAttackableRightBoundTest() {
        Tower2 t = new Tower2(new Point(7,6));
        assertTrue(t.rangeCheck(new Point(13,6)));
    }
    
    @Test
    public void getAttackableTopBoundTest() {
        Tower2 t = new Tower2(new Point(7,6));
        assertTrue(t.rangeCheck(new Point(8,12)));
    }
    
    @Test
    public void getAttackableBottomBoundTest() {
        Tower2 t = new Tower2(new Point(7,6));
        assertTrue(t.rangeCheck(new Point(8,0)));
    }
    
    @Test
    public void getAttackableConor1BoundTest() {
        Tower2 t = new Tower2(new Point(7,6));
        assertTrue(t.rangeCheck(new Point(1,0)));
    }
    
    @Test
    public void getAttackableConor2BoundTest() {
        Tower2 t = new Tower2(new Point(7,6));
        assertTrue(t.rangeCheck(new Point(1,12)));
    }
    
    @Test
    public void getAttackableConor3BoundTest() {
        Tower2 t = new Tower2(new Point(7,6));
        assertTrue(t.rangeCheck(new Point(13,0)));
    }
    
    @Test
    public void getAttackableConor4BoundTest() {
        Tower2 t = new Tower2(new Point(7,6));
        assertTrue(t.rangeCheck(new Point(13,12)));
    }
    
    @Test
    public void getAttackableIniPointTest() {
        Tower2 t = new Tower2(new Point(1,2));
        assertFalse(t.rangeCheck(new Point(0,3)));
    }
    
    @Test
    public void checkBulletTest() {
        Tower2 t = new Tower2(new Point(7,6));
        assertTrue(t instanceof Tower2);
    }
}
