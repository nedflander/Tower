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
import java.io.IOException;


public class Menu extends Group {

    Image stlImage = null;

    public Menu() throws FileNotFoundException {

        Text title = new Text();
        title.setCache(true);
        title.setText("STL CAF DEFENSE");
        title.setFill(Color.FORESTGREEN);
        title.setFont(Font.font(null, FontWeight.BOLD, 75));
        title.setWrappingWidth(850);
        title.setTextAlignment(TextAlignment.CENTER);

        Reflection r = new Reflection();
        r.setFraction(0.7);
        title.setEffect(r);
        title.setTranslateY(100);

        this.getChildren().addAll(title);
    }
}
