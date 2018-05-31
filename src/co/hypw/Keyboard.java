package co.hypw;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Keyboard implements EventHandler<KeyEvent> {
    GameApplication app;

    public Keyboard(GameApplication app) {
        this.app = app;
    }

    @Override
    public void handle(KeyEvent event) {
        System.out.println("g");
        if(event.getEventType() == KeyEvent.KEY_TYPED) {
            if(event.getCode() == KeyCode.ESCAPE) {
                System.out.println("x");
                if(app.inGame) {
                    app.removeBoard();
                    app.drawMenu();
                }
            }
        }
    }
}
