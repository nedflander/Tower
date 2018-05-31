package co.hypw;

import java.util.ArrayList;

public class Weapon {
    ArrayList<Projectile> projectiles = new ArrayList<>();
    int range, level, damage;
    Tower tower;

    public Weapon(int range, int level, int damage, Tower tower) {
        this.range = range;
        this.damage = damage;
        this.level = level;
        this.tower = tower;
    }

    public void shoot() {
        Projectile projectile = new Projectile(damage, this);
        projectiles.add(projectile);
    }
}
