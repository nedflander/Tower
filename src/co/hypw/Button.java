package co.hypw;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class Button extends Pane {
    Rectangle r;
    int x, y, width, height;
    String text;

    public Button(int x, int y, int width, int height, String text) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;

        r = new Rectangle(width, height);
        r.setFill(Color.FORESTGREEN);
        r.setStroke(Color.BLACK);
        r.setStrokeWidth(5);
        r.setX(x);
        r.setY(y);

        Text word = new Text(text);
        word.setFont(Font.font(null,FontWeight.NORMAL, 50));
        word.setY(r.getY()+55);
        word.setX(r.getX());
        word.setWrappingWidth(width);
        word.setTextAlignment(TextAlignment.CENTER);

        this.getChildren().addAll(r, word);
    }
}
