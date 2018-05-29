package co.hypw.Enemies;

public class Choch extends Enemy {

    public Choch(int health, int speed, int damage, int x, int y) {
        super(health, speed, damage, Type.CHOCH, x, y);
        enemies.add(this);
    }
}