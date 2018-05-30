package co.hypw;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Mouse implements EventHandler<MouseEvent> {


    @Override
    public void handle(MouseEvent event) {
        if(event.getEventType() == MouseEvent.MOUSE_CLICKED) {
            System.out.println("ds");
            for(Button button : Menu.buttons) {

            }
        }
        if(event.getEventType() == MouseEvent.MOUSE_MOVED) {

        }
    }




}
