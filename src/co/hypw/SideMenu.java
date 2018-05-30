package co.hypw;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SideMenu extends Pane {

    public SideMenu() {
        setLayoutX(685);
        setLayoutY(45);
        Rectangle square = new Rectangle(160,660,Color.BLUEVIOLET);
        Rectangle menutop = new Rectangle(160,170,Color.HOTPINK);
        Rectangle menubottom = new Rectangle(0,420,160,300);

        getChildren().addAll(square,menutop,menubottom);
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