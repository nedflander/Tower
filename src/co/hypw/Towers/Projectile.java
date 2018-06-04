package co.hypw.Towers;

import co.hypw.Enemies.Enemy;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Projectile extends Rectangle {
    int damage, pspeed;
    Weapon weapon;

    public Projectile(int damage, Weapon weapon) {
        this.weapon = weapon;
        weapon.projectiles.add(this);
        weapon.projectileGroup.getChildren().add(this);
        setWidth(15);
        setHeight(10);
    }

    public void move() {
    }

    public void handleDamage() {
        ArrayList<Enemy> dead = new ArrayList<>();
        for(Enemy enemy : Enemy.enemies) {
            if(this.intersects(enemy.getLayoutBounds())) {
                enemy.setHealth(enemy.getHealth()-damage);
                if(enemy.getHealth()<=0) {
                    dead.add(enemy);
                }
            }
        }

        Enemy.enemies.remove(dead);
        weapon.projectiles.remove(this);
        weapon.projectileGroup.getChildren().remove(this);
    }
}
