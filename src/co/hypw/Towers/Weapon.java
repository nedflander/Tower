package co.hypw.Towers;

import co.hypw.Enemies.Enemy;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Weapon {
    public ArrayList<Projectile> projectiles = new ArrayList<>();
    public Group projectileGroup = new Group();
    private int radius, level, damage;
    public Tower tower;

    public Weapon(int range, int damage, Tower tower) {
        this.radius = range;
        this.damage = damage;
        this.tower = tower;
    }

    public void shoot() {
        ArrayList<Enemy> inBounds = new ArrayList<>();
        Enemy target = null;
        for(Enemy enemy: Enemy.enemies) {
            if(enemy.intersects(tower.bounds.getLayoutBounds())){
                inBounds.add(enemy);
            }
        }

        double curr = 0;
        for(Enemy enemy: inBounds) {
            double dx = enemy.getX()-tower.getX();
            double dy = enemy.getY()-tower.getY();
            double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
            if(curr == 0) {
                curr = distance;
                target = enemy;
            } else if(curr > distance) {
                curr = distance;
                target = enemy;
            }
        }

        if(target!=null) {
            new Projectile(damage, this, target).move();
        }


    }
}
