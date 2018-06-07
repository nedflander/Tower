package co.hypw.Towers;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class First extends Tower {
    public First(int x, int y) {

        super(Type.FIRST, x, y);
        int radius = 80;
        this.cost = 20;

        weapon = new Weapon(2, 1, this);
        bounds = new Circle(this.getX()+25, this.getY()+25, radius, Color.TRANSPARENT);
        bounds.setStroke(Color.BLACK);
    }
}
