package co.hypw;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Enemy extends Rectangle {
    private int health, speed;
    private int x = 28, y = 665, width = 40, height = 40;

    private Direction dir = Direction.NORTH;
    public static ArrayList<Enemy> enemies = new ArrayList<>();

    public Enemy(int health, int speed) {
        this.health = health;
        this.speed = speed;
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }


    public void move() {
        switch(dir) {
            case NORTH:
                this.y -=speed;
                break;
            case EAST:
                this.x += speed;
                break;
            case WEST:
                this.x -= speed;
                break;
            case SOUTH:
                this.y +=speed;
                break;

        }
        update();
    }

    private void update() {
        setY(y);
        setX(x);
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
