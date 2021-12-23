import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * A type of enemy
 * @author Siming He
 *
 */
public class Enemy1 extends Enemy {

    private Color color = new Color(0, 0, 255);
    private int width = 32;
    private int height = 32;
    private int value = 3;
    private boolean pased = false;

    public Enemy1(Direction d, Point c) {
        super(d, c);
        super.setId();
        super.setHealth(2000);
        super.setAttack(1);
        super.setSpeed(32);
    }

    public int getValue() {
        return value;
    }

    public void getHurt(int dm) {
        super.setHealth(super.getHealth() - dm);
        if (super.getHealth() <= 0 && super.getLife()) {
            super.setLife(false);
        }
    }

    //==========================================================================
    // Updating enemy position
    //==========================================================================

    public void motion() {

        super.setLocation(Map.posToCoor(super.getCoordinate()));

        if (Game.getMap().getMapData()[super.getLocation().x][super.getLocation().y] == '9') {
            super.setSpeed(0);
            pased = true;
        }

        switch (super.getDir()) {
            case LEFT:
                if (super.getLocation().y + 1 < 20 && super.getLocation().y - 1 >= 0) {
                    if (Game.getMap().getMapData()[super.getLocation().x][super.getLocation().y + 1]
                            == '1') {
                        super.setDir(Direction.DOWN);
                        //coordinate.y += speed;
                    } else if (
                            Game.getMap().
                            getMapData()[super.getLocation().x][super.getLocation().y - 1]
                                    == '1') {
                        super.setDir(Direction.UP);
                        //coordinate.y -= speed;
                    } 
                }
                break;
            case RIGHT:
                if (super.getLocation().y + 1 < 20 && super.getLocation().y - 1 >= 0) {
                    //System.out.println(Game.getMap().getMapData()[location.x][location.y + 1]);
                    if (Game.getMap().getMapData()[super.getLocation().x][super.getLocation().y + 1]
                            == '1') {
                        super.setDir(Direction.DOWN);
                        //coordinate.y += speed;
                    } else if (
                            Game.getMap().
                            getMapData()[super.getLocation().x][super.getLocation().y - 1]
                                    == '1') {
                        super.setDir(Direction.UP);
                        //coordinate.y -= speed;
                    } 
                }
                break;
            case UP:
                if (super.getLocation().x + 1 < 20 && super.getLocation().x - 1 >= 0) {
                    if (Game.getMap().getMapData()[super.getLocation().x + 1][super.getLocation().y]
                            == '1') {
                        super.setDir(Direction.RIGHT);
                        //coordinate.x += speed;
                    } else if (
                            Game.getMap().
                            getMapData()[super.getLocation().x - 1][super.getLocation().y]
                                    == '1') {
                        super.setDir(Direction.LEFT);
                        //coordinate.x -= speed;
                    } 
                }
                break;
            case DOWN:
                if (super.getLocation().x + 1 < 20 && super.getLocation().x - 1 >= 0) {
                    if (Game.getMap().getMapData()[super.getLocation().x + 1][super.getLocation().y]
                            == '1') {
                        super.setDir(Direction.RIGHT);
                        //coordinate.x += speed;
                    } else if (
                            Game.getMap().
                            getMapData()[super.getLocation().x - 1][super.getLocation().y]
                                    == '1') {
                        super.setDir(Direction.LEFT);
                        //coordinate.x -= speed;
                    }
                }
                break;
            default:
                break;
        }

        moveStep();
    }

    public void moveStep() {
        int x = super.getCoordinate().x;
        int y = super.getCoordinate().y;
        switch (super.getDir()) {
            case LEFT:
                x = x - super.getSpeed();
                break;
            case RIGHT:
                x = x + super.getSpeed();
                break;
            case UP:
                y = y - super.getSpeed();
                break;
            case DOWN:
                y = y + super.getSpeed();
                break;
            default:
                break;
        }
        super.setCoordination(new Point(x, y));
    }

    protected Color lifeColor() {
        int b = (int) (super.getHealth() * 255 * 1.0 / 2000);
        b = (b > 255) ? 255 : b;
        b = (b < 0) ? 0 : b;
        int g = 255 - b;

        return new Color(0,g,b);
    }

    public boolean isPassed() {
        return pased;
    }

    @Override
    public void draw(Graphics g) {
        color = lifeColor();
        g.setColor(this.color);
        g.fillOval(super.getCoordinate().x, super.getCoordinate().y, width, height);
    }


}
