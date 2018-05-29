package co.hypw;

public class MyYute extends Enemy {

    public MyYute(int health, int speed, int damage, int x, int y) {
        super(health, speed, damage, Type.MYYUTE, x, y);
        enemies.add(this);
    }
}

