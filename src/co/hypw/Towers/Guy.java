package co.hypw.Towers;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Guy extends Tower {
    public Guy(int x, int y) {

        super(Type.FIRST, x, y, 45);
        int radius = 80;
        this.cost = 20;

        weapon = new Weapon(2, this);
        bounds = new Circle(this.getX()+25, this.getY()+25, radius, Color.TRANSPARENT);
        bounds.setStroke(Color.BLACK);
    }


}
