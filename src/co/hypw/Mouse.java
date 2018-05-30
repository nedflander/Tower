package co.hypw;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Mouse implements EventHandler<MouseEvent> {


    @Override
    public void handle(MouseEvent event) {
        if(event.getEventType() == MouseEvent.MOUSE_CLICKED) {
            System.out.println("ds");
            for(Button button : Menu.buttons) {
                System.out.println(event.getX());
                System.out.println(event.getY());
                System.out.println(button.x);
                System.out.println(button.y);
                System.out.println(button.width);
                System.out.println(button.height);
                if(button.contains(event.getSceneX(), event.getSceneY())) {
                    System.out.println("g");
                }
            }
        }
        if(event.getEventType() == MouseEvent.MOUSE_MOVED) {

        }
    }




}
