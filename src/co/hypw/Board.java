package co.hypw;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Board  extends Group {
    public Board() {
        generateGrid();
        drawGrid();
        makeEnemy();
    }

    private void makeEnemy() {
        MyYute yute = new MyYute(1, 1, 1, 28, 665);
        MyYute yute2 = new MyYute(1, 1, 1, 28, 740);
        this.getChildren().addAll(yute, yute2);
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
                tile.setFill(Color.GREEN);
            } else if (tile.getType()==Tile.Type.BARRIER) {
                tile.setFill(Color.BLACK);
            } else if (tile.getType()==Tile.Type.ENEMY) {
                tile.setFill(Color.RED);
            } else if (tile.getType()==Tile.Type.NORTH|| tile.getType()==Tile.Type.SOUTH || tile.getType()==Tile.Type.WEST || tile.getType()==Tile.Type.EAST) {
                tile.setFill(Color.GREEN);
            }
            this.getChildren().add(tile);
        }
    }
}
