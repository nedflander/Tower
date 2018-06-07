package co.hypw.Towers;

import co.hypw.GameApplication;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Tower extends Rectangle {
    public Weapon weapon;
    int points, cost, health, x, y, frequency;
    Type type;
    Image image;
    public Circle bounds;
    public static ArrayList<Tower> towers = new ArrayList<>();

    public Tower(Type type, int x, int y, int frequency) {
        this.frequency = frequency;
        this.type = type;
        this.x = x;
        this.y = y;
        setWidth(50);
        setHeight(50);
        setX(x);
        setY(y);
        setProperties();
        towers.add(this);
    }

    public int getHealth() {
        return health;
    }

    public void shoot() {
        this.weapon.shoot();
    }

    public enum Type {
        FIRST,
        SNIPER
    }

    private void setProperties() {
        try {
            switch (type) {
                case FIRST:
                    image = new Image(new FileInputStream("tower.png"), 850, 750, true, true);

                    break;
                case SNIPER:
                    image = new Image(new FileInputStream("sniper.png"), 850, 750, true, true);
                    break;
            }
            ImagePattern bg = new ImagePattern(image);
            this.setFill(bg);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public Group getGroup() {
        Group group = new Group();
        group.getChildren().addAll(this, bounds, weapon.projectileGroup);
        return group;
    }

}
