package co.hypw;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MyYute extends Enemy {

    public MyYute(int health, int speed) {
        super(health, speed);
        setFill(Color.RED);
        enemies.add(this);
    }
}

