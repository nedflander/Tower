package co.hypw.Towers;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;

public class Tower extends Rectangle {
    Weapon weapon;
    int points, cost, health;
    Type type;
    Image image;

    public Tower(int cost, Type type) {
        this.cost = cost;
        this.type = type;
        setProperties();
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
                    break;
            }
            ImagePattern bg = new ImagePattern(image);
            this.setFill(bg);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

}
