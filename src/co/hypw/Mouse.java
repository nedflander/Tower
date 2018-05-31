package co.hypw;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Mouse implements EventHandler<MouseEvent> {

    GameApplication app;

    public Mouse(GameApplication app) {
        this.app = app;
    }

    @Override
    public void handle(MouseEvent event) {
        if(event.getEventType() == MouseEvent.MOUSE_CLICKED) {
            for(Button button : Menu.buttons) {
                if(button.r.intersects(event.getX(),event.getY(), 1, 1)) {
                    if(button.returnID().equals("play")) {
                        app.removeMenu();
                        app.drawBoard();
                    }
                }
            }
        }
         if(event.getEventType() == MouseEvent.MOUSE_MOVED) {
            for(Button button : Menu.buttons) {
                if(button.r.intersects(event.getX(),event.getY(), 1, 1)) {
                    button.r.setFill(Color.RED);
                } else {
                    button.r.setFill(Color.FORESTGREEN);
                }
            }
        }
    }




}
