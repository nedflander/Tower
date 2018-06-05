package co.hypw.Towers;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.util.ArrayList;

public class Tower extends Rectangle {
    Weapon weapon;
    int points, cost, health, x, y;
    Type type;
    Image image;
    public Circle bounds;
    public static ArrayList<Tower> towers = new ArrayList<>();

    public Tower(Type type, int x, int y) {
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
        FIRST
    }

    private void setProperties() {
        try {
            switch (type) {
                case FIRST:
                    image = new Image(new FileInputStream("tower.png"), 850, 750, true, true);
                    weapon = new Weapon(2, 10, this);
                    bounds = new Circle(this.getX()+25, this.getY()+25, 80, Color.TRANSPARENT);
                    bounds.setStroke(Color.BLACK);
                    this.cost = 20;

                    break;
            }
            ImagePattern bg = new ImagePattern(image);
            this.setFill(bg);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

}
