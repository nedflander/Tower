package co.hypw;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MyYute extends Enemy {

    public MyYute(int health, int speed, int damage) {
        super(health, speed, damage);
        setFill(Color.RED);
        enemies.add(this);
    }
}

