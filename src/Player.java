/**
 * Class for states of Player
 * @author Siming He
 *
 */
public class Player {
    
    static int money = 100;
    static int health = 10; 
    static Status playerSt = Status.BEGINNING;
    
    static public void cost(int c) {
        money = money - c;
        money = (money > 0) ? money : 0;
    }
    
    static public void gain(int g) {
        money = money + g;
    }
    
    static public void lossHealth(int h) {
        health = health - h;
        health = (health > 0) ? health : 0;
    }
    
    static public void reset() {
        money = 100;
        health = 10;
    }
    
    static public int getHealth() {
        return health;
    }
    
    static public int getMoney() {
        return money;
    }
    
    static public Status getStatus() {
        return playerSt;
    }
    
    static public void setStatus(Status st) {
        playerSt = st;
    }
}
