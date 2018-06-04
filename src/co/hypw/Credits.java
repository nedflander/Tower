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

public class Credits extends Group {

    public static ArrayList<Button> buttons = new ArrayList<>();
    Image stlImage;

    public Credits() throws FileNotFoundException {
        stlImage = new Image(new FileInputStream("stl.png"), 875, 775, true, true);
        ImagePattern bg = new ImagePattern(stlImage);

        Button backButton = new Button(10, 10, 250, 75, 50, Color.FORESTGREEN, "< BACK", "back");

        Text credit = new Text("STL CAF DEFENSE\n" +
                "~Created by~\n" +
                "Amir Afzali\n" +
                "Michael Diatlov\n" +
                "&\n" +
                "Hayden Meadows");

        credit.setWrappingWidth(850);
        credit.setTextAlignment(TextAlignment.CENTER);
        credit.setTranslateY(200);
        credit.setFont(Font.font(null, FontWeight.BOLD, 50));
        credit.setStroke(Color.WHITE);
        credit.setStrokeWidth(2);


        Rectangle rect = new Rectangle(875,775);
        rect.setFill(bg);

        buttons.add(backButton);
        this.getChildren().addAll(rect, backButton, credit);
    }



}
