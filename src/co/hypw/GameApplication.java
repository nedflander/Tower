package co.hypw;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GameApplication extends Application  {

    public static Rectangle r;
    private Group root;
    private Scene scene;


    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new Group();
        scene = new Scene(root, 850, 750);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setTitle("Shitty Bloons TD 6");
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, new Mouse());
        Menu menu = new Menu();
        root.getChildren().add(menu);

        generateGrid();
        drawGrid();


        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                game();
            }
        }.start();
    }

    private void game() {
        //r.setX(r.getX()+move);

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
            root.getChildren().add(tile);
        }
    }
}
