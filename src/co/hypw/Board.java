package co.hypw;

import co.hypw.Enemies.Choch;
import co.hypw.Enemies.Enemy;
import co.hypw.Enemies.MyYute;
import javafx.scene.Group;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Timer;

public class Board  extends Group {

    int count = 0;
    ArrayList<Enemy> que = new ArrayList<>();
    private Timer timer;

    public Board() {
        generateGrid();
        drawGrid();
        makeEnemy();
    }

    private void makeEnemy() {
        timer = new Timer();
        timer.schedule(
                new java.util.TimerTask() {
                    public void run() {
                        count++;
                        System.out.println(count);
                        Enemy enemy;
                        if(count%2==0) {
                            enemy = new MyYute(1, 1, 1, 28, 665);
                        } else {
                            enemy = new Choch(1, 1, 1, 28, 665);
                        }
                        que.add(enemy);
                    }
                },
                0, 1000
        );
    }

    public void generateGrid() {
        for(int i = 0; i<12; i++) {
            for(int j=0; j<12; j++) {
                new Tile(20+j*55, 45+i*55, 55, 55, i*12+j);
            }
        }
        new PrepareMap();
    }

    public void drawGrid() {
        for(Tile tile: Tile.tiles) {
            if (tile.getType()==Tile.Type.FRIENDLY) {
                tile.setFill(Color.MEDIUMAQUAMARINE);
            } else if (tile.getType()==Tile.Type.BARRIER) {
                tile.setFill(Color.BLACK);
            } else if (tile.getType()==Tile.Type.ENEMY) {
                tile.setFill(Color.RED);
            } else if (tile.getType()==Tile.Type.NORTH|| tile.getType()==Tile.Type.SOUTH || tile.getType()==Tile.Type.WEST || tile.getType()==Tile.Type.EAST) {
                tile.setFill(Color.YELLOW);
            }
            this.getChildren().add(tile);
        }
    }

    public void makeWave() {
            for(Enemy enemy: que) {
                this.getChildren().add(enemy);
            }

        que.clear();
    }

    public Timer getTimer() {
        return timer;
    }
}
