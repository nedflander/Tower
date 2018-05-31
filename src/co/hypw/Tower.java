package co.hypw;

public class Tower {
    Weapon weapon;
    int points, cost, health;

    public Tower(int cost, Weapon weapon) {
        this.cost = cost;
        this.weapon = weapon;

    }

    public int getCost() {
        return cost;
    }

    public int getHealth() {
        return health;
    }

    public int getPoints() {
        return points;
    }

    public void shoot() {
        this.weapon.shoot();
    }

}
