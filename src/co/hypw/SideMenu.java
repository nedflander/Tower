package co.hypw;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.util.ArrayList;

public class SideMenu extends Pane {

    private Selected selected = Selected.GUY;

    public static ArrayList<Button> buttons = new ArrayList<>();
    public static ArrayList<Tile> sideTiles = new ArrayList<>();
    public Image guy, sniper;
    private EventHandler handler1, handler2;
    private Rectangle uno, dos;


    public SideMenu() {
        setLayoutX(685);
        setLayoutY(45);
        Rectangle square = new Rectangle(160,660,Color.BLUEVIOLET);
        Rectangle menutop = new Rectangle(160,170,Color.HOTPINK);
        Button sidemenubutton = new Button(0,  0,  160,  30,  20, Color.FORESTGREEN, "MENU",  "menu");
        buttons.add(sidemenubutton);

        handler1 = event -> {
            setSelected(Selected.GUY);
            System.out.println("x");
        };
        handler2 = event -> {
            setSelected(Selected.SNIPER);
            System.out.println("y");
        };
        getChildren().addAll(square,menutop,sidemenubutton);
        gen();
        addImages();



    }

    public void gen() {
        int count = 0;
        for(int i = 0; i<3; i++) {
            for(int j=0; j<2; j++) {
                count++;
                Tile tile = new Tile(j*80, 170+i*80, 80, 80);
                sideTiles.add(tile);
                getChildren().add(tile);
            }
        }
    }

    public void addImages() {
        try {
            guy = new Image(new FileInputStream("tower.png"), 850, 750, true, true);
            sniper = new Image(new FileInputStream("sniper.png"), 850, 750, true, true);
            uno = new Rectangle(sideTiles.get(0).getX()+5, sideTiles.get(0).getY()+5, 70, 70);
            dos = new Rectangle(sideTiles.get(1).getX()+5, sideTiles.get(1).getY()+5, 70, 70);
            uno.setOnMouseClicked(handler1);
            dos.setOnMouseClicked(handler2);
            uno.toFront();
            dos.toFront();
            ImagePattern bg = new ImagePattern(guy);
            uno.setFill(bg);
            bg = new ImagePattern(sniper);
            dos.setFill(bg);
            this.getChildren().addAll(uno, dos);
        } catch (Exception e) { }
    }

    public Selected getSelected() {
        return selected;
    }

    public void setSelected(Selected selected) {
        this.selected = selected;
    }

    public enum Selected {
        GUY,
        SNIPER
    }
}