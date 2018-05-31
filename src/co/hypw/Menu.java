package co.hypw;

import javafx.scene.Group;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Menu extends Group {

    Image stlImage;

    public static ArrayList<Button> buttons = new ArrayList<>();

    public Menu() throws FileNotFoundException {
        stlImage = new Image(new FileInputStream("stl.png"), 875, 775, true, true);
        ImagePattern bg = new ImagePattern(stlImage);

        Rectangle rect = new Rectangle(875,775);
        rect.setFill(bg);

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

        Button playButton = generateButton(225, 300, 400,75, "PLAY", "play");
        Button instructionButton = generateButton(225, 425, 400, 75, "INSTRUCTIONS", "inst");
        Button creditButton = generateButton(225, 550, 400, 75, "CREDITS", "credits");

        buttons.add(playButton);
        buttons.add(instructionButton);
        buttons.add(creditButton);

        this.getChildren().addAll(rect, title, playButton, instructionButton, creditButton);
    }

    public Button generateButton(int x, int y, int width, int height, String text, String id) {
        Button button = new Button(x, y, width, height, text, id);
        return button;
    }
}
