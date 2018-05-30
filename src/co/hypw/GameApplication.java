package co.hypw;

import co.hypw.Enemies.Enemy;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameApplication extends Application  {

    public static Rectangle r;
    private Group root;
    private Scene scene;
    private Board board;
    private SideMenu sidemenu;

    Image stl;


    @Override
    public void start(Stage primaryStage) throws Exception {


        root = new Group();
        scene = new Scene(root, 850, 750);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setTitle("Shitty Bloons TD 5");
        primaryStage.setOnCloseRequest(event -> board.getTimer().cancel());
        //scene.setFill(bg);

        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, new Mouse());

        //drawMenu();

        drawBoard();
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                game();
            }
        }.start();

    }

    private void game() {
        board.makeWave();
        for(Enemy enemy: Enemy.enemies) {
            enemy.move();
        }

    }

    public void drawBoard() {
        board = new Board();
        root.getChildren().add(board);

    }



    public void drawMenu() throws FileNotFoundException {
        Menu menu = new Menu();
        root.getChildren().add(menu);
    }

    EventHandler buttonColorChange = new EventHandler(){
        @Override
        public void handle(Event event) {
            Rectangle source = (Rectangle) event.getSource();
            source.setFill(Color.RED);
        }
    };

    EventHandler buttonColorChangeBack = new EventHandler() {
        @Override
        public void handle(Event event) {
            Rectangle source = (Rectangle) event.getSource();
            source.setFill(Color.FORESTGREEN);
        }
    };
}
