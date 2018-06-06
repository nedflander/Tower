package co.hypw;

import co.hypw.Enemies.Enemy;
import co.hypw.Towers.Projectile;
import co.hypw.Towers.Tower;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GameApplication extends Application  {

    public static Rectangle r;
    private Group root;
    private Scene scene;
    public Board board;
    Menu menu;
    Credits credit;
    AnimationTimer timer;
    public boolean inMenu = true, inGame = false, inCredits = false;
    int count = 0;

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
        scene.addEventHandler(KeyEvent.KEY_PRESSED, keys);




        board = new Board();
        menu = new Menu();
        credit = new Credits();

        drawMenu();




    }

    private void game() {
        count++;
        board.makeWave();
        for(Enemy enemy: Enemy.enemies) {
            enemy.move();
        }
        for(Tower tower : Tower.towers) {
            if(count%60==0) {
                tower.shoot();
            }
            for(Projectile projectile: tower.weapon.projectiles) {
                if(projectile.hit) {
                    for(Enemy enemy: projectile.dead) {
                        board.getChildren().remove(enemy);
                        Enemy.enemies.remove(enemy);
                    }
                }
            }
        }

    }

    public void drawBoard() {
        inGame = true;
        root.getChildren().add(board);
        AnimationTimer exd = new AnimationTimer() {
            public void handle(long currentNanoTime) {
                game();
            }
        };
        exd.start();

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
