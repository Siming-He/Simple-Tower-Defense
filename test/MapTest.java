import java.awt.Point;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class MapTest {

    @Test
    public void mapData() {
        Map mp = new Map();
        char[][] md = mp.getMapData();
        assertEquals(20, md.length);
        assertEquals(20, md[0].length);
        assertEquals('0', md[0][0]);
        assertEquals('1', md[0][3]);
        assertEquals('0', md[5][2]);
        assertEquals('1', md[5][3]);
        assertEquals('1', md[5][4]);
        assertEquals('0', md[19][19]);
    }
    
    @Test
    public void mapDataEncap() {
        Map mp = new Map();
        char[][] md = mp.getMapData();
        md[0][0] = '1';
        assertEquals('0', mp.getMapData()[0][0]);
    }
    
    @Test
    public void setMapData() {
        Map mp = new Map();
        mp.setMapData('1', new Point(0,0));
        assertEquals('1', mp.getMapData()[0][0]);
    }
    
    @Test
    public void setMapOutBoundData() {
        Map mp = new Map();
        mp.setMapData('1', new Point(1,100));
        assertEquals('0', mp.getMapData()[0][0]);
    }
    
    @Test
    public void posToCoorTest() {
        assertEquals(new Point(0,0), Map.posToCoor(new Point(0,0)));
        assertEquals(new Point(1,1), Map.posToCoor(new Point(32,32)));
        assertEquals(new Point(1,1), Map.posToCoor(new Point(60,52)));
        assertEquals(new Point(2,1), Map.posToCoor(new Point(64,52)));
    }
    
    @Test
    public void coorToPosTest() {
        assertEquals(new Point(0,0), Map.coorToPos(new Point(0,0)));
        assertEquals(new Point(32,32), Map.coorToPos(new Point(1,1)));
        assertEquals(new Point(64,64), Map.coorToPos(new Point(2,2)));
        assertEquals(new Point(96,0), Map.coorToPos(new Point(3,0)));
    }
    
}
