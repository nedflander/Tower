package co.hypw.Enemies;

import co.hypw.Tile;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.util.ArrayList;

public class Enemy extends Rectangle {
    private int health, speed, damage;
    private int x, y, width = 40, height = 40;
    private Type type;
    Image image;
    private boolean turning;

    private Direction dir = Direction.NORTH;
    public static ArrayList<Enemy> enemies = new ArrayList<>();

    public Enemy(int health, int speed, int damage, Type type, int x, int y) {
        this.health = health;
        this.speed = speed;
        this.damage = damage;
        this.x = x;
        this.y = y;
        this.type = type;
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setImage();
    }

    private void setImage() {
        try {
            switch (type) {
                case MYYUTE:
                    image = new Image(new FileInputStream("myyute.png"), 850, 750, true, true);
                    break;
                case CHOCH:
                    image = new Image(new FileInputStream("choch.png"), 850, 750, true, true);
                    break;
            }
            ImagePattern bg = new ImagePattern(image);
            this.setFill(bg);
        } catch(Exception e) {
            System.out.println(e);
        }
    }


    public void move() {
        tileInteract();
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

    public void tileInteract() {
        ArrayList<Tile> tiles = Tile.tiles;
        ArrayList<Tile> black = new ArrayList<>();
        for (Tile tile : tiles) {
            if (this.intersects(tile.getLayoutBounds())) {
                black.add(tile);
            }
        }
        if (black.size() == 1) {
            switch (black.get(0).getType()) {
                case NORTH:
                    setDir(Direction.NORTH);
                    setRotate(0);
                    break;
                case EAST:
                    setDir(Direction.EAST);
                    setRotate(90);
                    break;
                case WEST:
                    setDir(Direction.WEST);
                    setRotate(270);
                    break;
                case SOUTH:
                    setDir(Direction.SOUTH);
                    setRotate(180);
                    break;
                default:
                    break;
            }
        }
    }
}
