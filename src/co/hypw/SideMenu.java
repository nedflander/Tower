package co.hypw;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class SideMenu extends Pane {

    public static ArrayList<Button> buttons = new ArrayList<>();


    public SideMenu() {
        setLayoutX(685);
        setLayoutY(45);
        Rectangle square = new Rectangle(160,660,Color.BLUEVIOLET);
        Rectangle menutop = new Rectangle(160,170,Color.HOTPINK);
        Button sidemenubutton = new Button(0,  0,  160,  30,  20, Color.FORESTGREEN, "MENU",  "menu");
        buttons.add(sidemenubutton);


        getChildren().addAll(square,menutop,sidemenubutton);
        gen();


    }

    public void gen() {

        for(int i = 0; i<3; i++) {
            for(int j=0; j<2; j++) {
                Tile tile = new Tile(j*80, 170+i*80, 80, 80);
                getChildren().add(tile);
            }
        }



    }
}