package co.hypw;

import java.util.ArrayList;

public class Enemy {
    private int health, speed, damage;
    private int x, y;

    private Direction dir = Direction.NORTH;
    public ArrayList<Enemy> enemies = new ArrayList<>();

    public Enemy() {
        setup();
    }

    private void setup() {

    }

    public void move() {
        switch(dir) {
            case NORTH:
                break;
            case EAST: break;
            case WEST: break;
            case SOUTH: break;

        }
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
