package co.hypw.Towers;

import co.hypw.Enemies.Enemy;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Projectile extends Rectangle {
    int damage, pspeed;
    Weapon weapon;
    Enemy target;
    public ArrayList<Enemy> dead = new ArrayList<>();
    public boolean hit;
    Image eraser;


    public Projectile(int damage, Weapon weapon, Enemy target) {
        this.weapon = weapon;
        this.target = target;
        this.damage = damage;
        weapon.projectiles.add(this);
        weapon.projectileGroup.getChildren().add(this);

        move();
        setWidth(15);
        setHeight(10);
        try {
            eraser = new Image(new FileInputStream("Eraser.png"), 15, 10, true, true);
        } catch (Exception e) { }
        ImagePattern eraserIP = new ImagePattern(eraser);
        setFill(eraserIP);
    }

    public void move() {
        TranslateTransition x = new TranslateTransition(Duration.seconds(0.2));
        x.setNode(this);
        x.setFromX(weapon.tower.x+20);
        x.setFromY(weapon.tower.y+20);
        x.setToX(target.getX());
        x.setToY(target.getY());
        x.setOnFinished(event -> { setX(getTranslateX()-getX());
        setY(getTranslateY() - getY()); handleDamage(); weapon.projectileGroup.getChildren().remove(this);
        });
        x.play();


    }

    public boolean handleDamage() {
        System.out.println(this.getX());
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
