package co.hypw.Enemies;

public class Choch extends Enemy {

    public Choch(int x, int y) {
        super(2, 1, 2, 2, Type.CHOCH, x, y);
        enemies.add(this);
    }
}