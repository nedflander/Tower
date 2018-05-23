package co.hypw;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Tile extends Rectangle {
    private Type type;
    private int id;
    public static ArrayList<Tile> tiles = new ArrayList<>();


    public Tile(int x, int y, int width, int height, int id) {
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
        //this.setFill(Color.TRANSPARENT);
        this.setStroke(Color.BLACK);
        this.id = id;
        tiles.add(this);
    }

    public enum Type {
        ENEMY,
        FRIENDLY,
        BARRIER,
        NORTH,
        WEST,
        SOUTH,
        EAST
    }


    public void setType(Type t) {
        this.type = t;
    }

    public Type getType() {
        return this.type;
    }

    public int getTileId() {
        return this.id;
    }

    public static Tile getTileWithId(int id) {
        for(Tile tile: tiles) {
            if (tile.getTileId() == id) {
                return tile;
            }
        }
        return null;
    }
}
