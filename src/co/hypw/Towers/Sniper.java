package co.hypw.Towers;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Sniper extends Tower {

    public Sniper(int x, int y) {

        super(Tower.Type.SNIPER, x, y, 45);
        int radius = 400;
        this.cost = 20;

        weapon = new Weapon(2, this);
        bounds = new Circle(this.getX()+25, this.getY()+25, radius, Color.TRANSPARENT);
        bounds.setStroke(Color.BLACK);
    }
}
