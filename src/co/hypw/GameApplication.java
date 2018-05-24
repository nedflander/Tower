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
        primaryStage.setTitle("Shitty Bloons TD 5");
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, new Mouse());
        drawBoard();



        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                game();
            }
        }.start();
    }

    private void game() {
        for(Enemy enemy: Enemy.enemies) {
            enemy.move();
        }

    }

    public void drawBoard() {
        Board board = new Board();
        root.getChildren().add(board);
    }

    public void drawMenu() {
        Menu menu = new Menu();
        root.getChildren().add(menu);
    }
}
