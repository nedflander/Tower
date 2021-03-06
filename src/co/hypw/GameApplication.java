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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GameApplication extends Application  {

    public static Rectangle r;
    private Group root;
    private Scene scene;
    public Board board;
    Menu menu;
    Credits credit;
    Instructions instructions;
    AnimationTimer timer;
    public boolean inMenu = true, inGame = false, inCredits = false, inInstuctions = false, inSideMenu = false;
    public static int points = 50, health = 50;
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
        primaryStage.setOnCloseRequest(event -> onClose());
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
        instructions = new Instructions();

        drawMenu();




    }
    public void onClose() {
        board.getTimer().cancel();
        System.exit(1);
    }

    private void game() {
        count++;
        board.makeWave();
        ArrayList<Enemy> toRemove = new ArrayList<>();
        for(Enemy enemy: Enemy.enemies) {
            enemy.move();
            if(enemy.intersects(Tile.getTileWithId(143).getLayoutBounds())) {
                health-=enemy.getDamage();
                board.getChildren().remove(enemy);
                toRemove.add(enemy);
                board.smenu.update();
            }
        }
        Enemy.enemies.removeAll(toRemove);
        for(Tower tower : Tower.towers) {
            if(count%45==0) {
                tower.shoot();
            }
            for(Projectile projectile: tower.weapon.projectiles) {
                if(projectile.hit) {
                    for(Enemy enemy: projectile.dead) {
                        points += enemy.getPoints();
                        board.getChildren().remove(enemy);
                        Enemy.enemies.remove(enemy);
                        board.smenu.update();
                    }
                }
                projectile.dead.clear();
            }
        }
    }

    public void drawBoard() {
        inGame = true;
        inSideMenu = true;
        root.getChildren().add(board);
        AnimationTimer exd = new AnimationTimer() {
            public void handle(long currentNanoTime) {
                game();
                if (health == 0) {
                    gameOver();
                    stop();

                }
            }
        };
        exd.start();

    }

    public void removeBoard() {
        inGame = false;
        inSideMenu = false;
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

    public void removeInstructions() {
        inInstuctions = false;
        root.getChildren().remove(instructions);
    }

    public void drawInstructions() {
        inInstuctions = true;
        root.getChildren().add(instructions);
    }

    public Group getRoot() {
        return this.root;
    }

    public void gameOver() {
        Text over = new Text();
        over.setFont(Font.font(null, 100));
        over.setText("GAME OVER !");
        over.setWrappingWidth(850);
        over.setTextAlignment(TextAlignment.CENTER);
        over.setY(300);
        over.setFill(Color.RED);
        root.getChildren().remove(board);
        root.getChildren().add(over);
    }
}
