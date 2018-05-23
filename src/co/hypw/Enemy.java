package co.hypw;

import java.util.ArrayList;

public class Enemy {
    int health, speed, damage;
    Direction dir = Direction.NORTH;
    public ArrayList<Enemy> enemies = new ArrayList<>();

    public Enemy() {
        setup();
    }

    private void setup() {

    }

    public void move() {

    }

    public enum Direction {
        NORTH,
        SOUTH,
        WEST,
        EAST
    }

    public enum Type {
        WASTEMAN,
        NERD,
        CHOCH,
        MYYUTE
    }

    public Direction getDir() {
        return this.dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }




}
