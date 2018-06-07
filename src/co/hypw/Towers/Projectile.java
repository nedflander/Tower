package co.hypw.Towers;

import co.hypw.Enemies.Enemy;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;

public class Projectile extends Rectangle {
    int damage, pspeed;
    Weapon weapon;
    Enemy target;
    public ArrayList<Enemy> dead = new ArrayList<>();
    public boolean hit;

    public Projectile(int damage, Weapon weapon, Enemy target) {
        this.weapon = weapon;
        this.target = target;
        this.damage = damage;
        weapon.projectiles.add(this);
        weapon.projectileGroup.getChildren().add(this);
        setFill(Color.BLACK);
        move();
        setWidth(15);
        setHeight(10);
    }

    public void move() {
        TranslateTransition x = new TranslateTransition(Duration.seconds(0.2));
        x.setNode(this);
        x.setFromX(weapon.tower.x);
        x.setFromY(weapon.tower.y);
        x.setToX(target.getX()+20);
        x.setToY(target.getY()+20);
        x.setOnFinished(event -> { setX(getTranslateX()-getX());
        setY(getTranslateY() - getY()); handleDamage(); weapon.projectileGroup.getChildren().remove(this);
        });
        x.play();


    }

    public boolean handleDamage() {
        for(Enemy enemy : Enemy.enemies) {
            if(enemy.intersects(this.getLayoutBounds())) {
                hit=true;
                System.out.println("s");
                enemy.setHealth(enemy.getHealth()-damage);
                if(enemy.getHealth()<=0) {
                    System.out.println("f");
                    dead.add(enemy);
                }
                return true;
            }
        }
        return false;
    }
}
