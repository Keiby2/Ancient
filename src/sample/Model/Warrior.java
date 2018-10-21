package sample.Model;

/**
 * Created by lushi on 27.06.2018.
 */
public class Warrior implements Unit {
    private int Attack, Health, Defence, Speed;

    public Warrior(int attack, int health, int defence, int speed) {
        Attack = attack;
        Health = health;
        Defence = defence;
        Speed = speed;
    }

    public int getAttack() {
        return Attack;
    }

    public void setAttack(int attack) {
        Attack = attack;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public int getDefence() {
        return Defence;
    }

    public void setDefence(int defence) {
        Defence = defence;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }
}
