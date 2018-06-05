package co.hypw.Towers;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Weapon {
    ArrayList<Projectile> projectiles = new ArrayList<>();
    public Group projectileGroup = new Group();
    private int radius, level, damage;
    private Tower tower;

    public Weapon(int range, int damage, Tower tower) {
        this.radius = range;
        this.damage = damage;
        this.tower = tower;
    }

    public void shoot() {
        getRange();
        new Projectile(damage, this);
        for(Projectile projectile : projectiles) {
            projectile.handleDamage();
        }
    }

    private void getRange() {
        Circle range = new Circle(tower.getX()+28, tower.getY()+28, radius, Color.BLACK);


    }
}
