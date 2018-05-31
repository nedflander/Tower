package co.hypw;

import javafx.scene.shape.Rectangle;

public class Projectile extends Rectangle {
    int damage, timeout;
    Weapon weapon;

    public Projectile(int damage, Weapon weapon) {
        this.weapon = weapon;
        setWidth(15);
        setHeight(10);
    }
}
