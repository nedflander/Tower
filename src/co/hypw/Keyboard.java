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
        if(event.getEventType() == KeyEvent.KEY_PRESSED) {
            if(event.getCode() == KeyCode.ESCAPE) {
                if(app.inGame) {
                    app.removeBoard();
                    app.drawMenu();
                }
            }
        }
    }
}
