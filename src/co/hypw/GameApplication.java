package co.hypw;

import co.hypw.Enemies.Enemy;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GameApplication extends Application  {

    public static Rectangle r;
    private Group root;
    private Scene scene;
    Board board;
    Menu menu;
    Credits credit;
    AnimationTimer timer;
    boolean inMenu = true, inGame = false, inCredits = false;

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
        Mouse mouse = new Mouse(this);
        Keyboard keys = new Keyboard(this);

        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, mouse);
        scene.addEventHandler(MouseEvent.MOUSE_MOVED, mouse);
        scene.addEventHandler(KeyEvent.KEY_TYPED, keys);




        board = new Board();
        menu = new Menu();
        credit = new Credits();

        drawMenu();




    }

    private void game() {
        board.makeWave();
        for(Enemy enemy: Enemy.enemies) {
            enemy.move();
        }

    }

    public void drawBoard() {
        inGame = true;
        root.getChildren().add(board);
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                game();
            }
        }.start();

    }

    public void removeBoard() {
        inGame = false;
        root.getChildren().remove(board);
    }

    public void drawMenu() {
        inMenu = true;
        root.getChildren().add(menu);
    }

    public void removeMenu() {
        inMenu = false;
        root.getChildren().remove(menu);
    }

    public void drawCredits() {
        inCredits = true;
        root.getChildren().add(credit);
    }

    public void removeCredits() {
        inCredits = false;
        root.getChildren().remove(credit);
    }


    public Group getRoot() {
        return this.root;
    }
}
