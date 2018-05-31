package co.hypw;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Mouse implements EventHandler<MouseEvent> {


    @Override
    public void handle(MouseEvent event) {
        if(event.getEventType() == MouseEvent.MOUSE_CLICKED) {
            System.out.println("x");
            for(Button button : Menu.buttons) {
                if(button.r.intersects(event.getX(),event.getY(), 1, 1)) {
                    System.out.println("g");
                }
            }
        }
        if(event.getEventType() == MouseEvent.MOUSE_MOVED) {

        }
    }




}
