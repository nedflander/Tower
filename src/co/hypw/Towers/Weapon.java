package co.hypw.Towers;

import javafx.scene.Group;

import java.util.ArrayList;

public class Weapon {
    ArrayList<Projectile> projectiles = new ArrayList<>();
    Group projectileGroup = new Group();
    int range, level, damage;
    Tower tower;

    public Weapon(int range, int damage, Tower tower) {
        this.range = range;
        this.damage = damage;
        this.tower = tower;
    }

    public void shoot() {
        new Projectile(damage, this);
        for(Projectile projectile : projectiles) {
            projectile.handleDamage();
        }
    }
}
