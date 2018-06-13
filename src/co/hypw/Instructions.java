package co.hypw;

import javafx.scene.Group;
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

public class Instructions extends Group {
    public static ArrayList<Button> buttons = new ArrayList<>();
    Image stlImage;

    public Instructions() throws FileNotFoundException {
        stlImage = new Image(new FileInputStream("stl.png"), 875, 775, true, true);
        ImagePattern bg = new ImagePattern(stlImage);

        Button backButton = new Button(10, 10, 250, 75, 50, Color.FORESTGREEN, "< BACK", "back");

        Text instruct = new Text("Place towers on wooden tables to eliminate" +
                " enemies and gain points. Points can be used to" +
                " purchase more towers and to upgrade existing" +
                " towers. If enemies reach the end you lose health.");
        instruct.setWrappingWidth(850);
        instruct.setTextAlignment(TextAlignment.CENTER);
        instruct.setTranslateY(200);
        instruct.setFont(Font.font(null, FontWeight.BOLD, 50));
        instruct.setStroke(Color.WHITE);
        instruct.setStrokeWidth(1);


        Rectangle rect = new Rectangle(875,775);
        rect.setFill(bg);

        buttons.add(backButton);
        this.getChildren().addAll(rect, backButton, instruct);
    }





}
