import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import javax.imageio.ImageIO;

/**
 * Get the map of the game
 * @author Siming He
 *
 */
public class Map {
    //static private final int MAPSIZE = 640;
    static private final int TILESIZE = 32;
    private final String imgPath = "files/Map1.png";
    private final String dataPath = "files/Map1.txt";
    static private BufferedImage mapImg;
    static private char[][] mapData = new char[20][20]; 

    public Map() {
        try {
            if (mapImg == null) {
                mapImg = ImageIO.read(new File(imgPath));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }

        try {
            FileReader freader = new FileReader(dataPath);
            BufferedReader reader = new BufferedReader(freader);

            String ln = reader.readLine();
            int count = 0;
            while (ln != null) {
                char[] c = ln.toCharArray();
                for (int i = 0; i < mapData.length; i++) {
                    mapData[i][count] = c[i];
                }
                count += 1;
                ln = reader.readLine();
            }
            for (int i = 0; i < 20; i++) {
                System.out.println(mapData[i]);
            }

            reader.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException();
        } catch (IOException e) {
            throw new NoSuchElementException();
        }
    }

    public char[][] getMapData() {
        char[][] copy = new char[mapData.length][mapData[0].length];
        for (int i = 0; i < mapData.length; i++) {
            System.arraycopy(mapData[i], 0, copy[i], 0, mapData[0].length);
        }
        return copy; 
    }

    public void setMapData(char value, Point pos) {
        if (pos.x < 20 && pos.x >= 0 && pos.y < 20 && pos.y >= 0) {
            mapData[pos.x][pos.y] = value;
        }
    }


    public BufferedImage getMapImg() {
        return mapImg;
    }

    static Point coorToPos(Point p) {
        int x = p.x * TILESIZE;
        int y = p.y * TILESIZE;
        return new Point(x, y);
    }

    static Point posToCoor(Point c) {
        int x = c.x / TILESIZE;
        int y = c.y / TILESIZE;
        return new Point(x, y);
    }

}
