package co.hypw;

import co.hypw.Towers.Tower;
import javafx.event.Event;
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
            if(app.inMenu) {
                for (Button button : Menu.buttons) {
                    if (button.r.intersects(event.getX(), event.getY(), 1, 1)) {
                        if (button.returnID().equals("play")) {
                            app.removeMenu();
                            app.drawBoard();
                        }
                        if (button.returnID().equals("credits")) {
                            app.removeMenu();
                            app.drawCredits();
                        }
                    }
                }
                for (Button button : Credits.buttons) {
                    if (button.r.intersects(event.getX(), event.getY(), 1, 1)) {
                        if (button.returnID().equals("back")) {
                            app.removeCredits();
                            app.drawMenu();
                        }
                    }
                }
            }
            if(app.inGame) {
                placeMonkey((int)event.getX() - 20, (int)event.getY() - 20);
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
            for(Button button : Credits.buttons) {
                if(button.r.intersects(event.getX(), event.getY(), 1, 1)) {
                    button.r.setFill(Color.RED);
                } else {
                    button.r.setFill(Color.FORESTGREEN);
                }
            }
        }
    }

    private void placeMonkey(int x, int y) {
        for(Tile tile: Tile.tiles) {
            if (tile.getType() == Tile.Type.ENEMY) {
                if(tile.intersects(x, y, 1, 1)) {
                    if(Tower.towers.size() != 0) {
                        for (Tower tower : Tower.towers) {
                            System.out.println("l");
                            if (tower.intersects(x, y, 50, 50)) {
                                System.out.println("j");
                                return;
                            }
                        }
                    }
                    Tower newtower = new Tower(Tower.Type.FIRST, x, y);
                    app.board.getChildren().add(newtower);
                    app.board.getChildren().add(newtower.bounds);
                }
            }
        }
    }


}
