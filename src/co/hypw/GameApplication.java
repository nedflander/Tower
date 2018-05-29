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

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameApplication extends Application  {

    public static Rectangle r;
    private Group root;
    private Scene scene;
    Image stl = null;


    @Override
    public void start(Stage primaryStage) throws Exception {
        stl = new Image(new FileInputStream("stl.png"), 850, 750, true, true);
        ImagePattern bg = new ImagePattern(stl);

        root = new Group();
        scene = new Scene(root, 850, 750);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setTitle("Shitty Bloons TD 5");

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
        for(Enemy enemy: Enemy.enemies) {
            enemy.move();
        }

    }

    public void drawBoard() {
        Board board = new Board();
        root.getChildren().add(board);
    }

    public void drawMenu() throws FileNotFoundException {
        //Menu menu = new Menu();
        //oot.getChildren().add(menu);

        StackPane playLayout = new StackPane();
        StackPane instructionLayout = new StackPane();
        StackPane creditLayout = new StackPane();


        //text
        Text title = new Text();
        title.setCache(true);
        title.setText("STL CAF DEFENSE");
        title.setFill(Color.FORESTGREEN);
        title.setFont(Font.font(null, FontWeight.BOLD, 75));
        title.setWrappingWidth(850);
        title.setTextAlignment(TextAlignment.CENTER);
        title.setStroke(Color.BLACK);
        title.setStrokeWidth(5);
        Reflection r = new Reflection();
        r.setFraction(0.7);
        title.setEffect(r);
        title.setTranslateY(150);

        Text play = new Text("PLAY");
        play.setFont(Font.font(null,FontWeight.NORMAL, 50));
        Text instructions = new Text("INSTRUCTIONS");
        instructions.setFont(Font.font(null,FontWeight.NORMAL, 50));
        Text credits = new Text("CREDITS");
        credits.setFont(Font.font(null,FontWeight.NORMAL, 50));

        Rectangle playButton = new Rectangle(400, 75);
        playButton.setFill(Color.FORESTGREEN);
        playButton.setStroke(Color.BLACK);
        playButton.setStrokeWidth(5);
        Rectangle instructionButton = new Rectangle(400, 75);
        instructionButton.setFill(Color.FORESTGREEN);
        instructionButton.setStroke(Color.BLACK);
        instructionButton.setStrokeWidth(5);
        Rectangle creditButton = new Rectangle(400, 75);
        creditButton.setFill(Color.FORESTGREEN);
        creditButton.setStroke(Color.BLACK);
        creditButton.setStrokeWidth(5);

        playLayout.getChildren().addAll(playButton, play);
        playLayout.setLayoutX(225);
        playLayout.setLayoutY(300);
        instructionLayout.getChildren().addAll(instructionButton, instructions);
        instructionLayout.setLayoutX(225);
        instructionLayout.setLayoutY(425);
        creditLayout.getChildren().addAll(creditButton, credits);
        creditLayout.setLayoutX(225);
        creditLayout.setLayoutY(550);

        root.getChildren().addAll(title, playLayout, instructionLayout, creditLayout);


        playButton.setOnMouseEntered(buttonColorChange);
        instructionButton.setOnMouseEntered(buttonColorChange);
        creditButton.setOnMouseEntered(buttonColorChange);

        playButton.setOnMouseExited(buttonColorChangeBack);
        instructionButton.setOnMouseExited(buttonColorChangeBack);
        creditButton.setOnMouseExited(buttonColorChangeBack);
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
