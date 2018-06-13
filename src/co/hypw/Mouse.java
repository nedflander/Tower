package co.hypw;

import co.hypw.Towers.First;
import co.hypw.Towers.Sniper;
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
                        if (button.returnID().equals("inst")) {
                            app.removeMenu();
                            app.drawInstructions();
                        }
                    }
                }
            }
            if(app.inCredits) {
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
                placeMonkey((int)event.getX(), (int)event.getY());
            }

            if(app.inSideMenu) {
                for (Button button : SideMenu.buttons) {
                    if (button.r.intersects(event.getX() - 685, event.getY()-45, 1, 1)) {
                        if (button.returnID().equals("menu")) {
                            app.removeBoard();
                            app.drawMenu();
                        }
                    }
                }
            }

            if (app.inInstuctions) {
                for (Button button : Instructions.buttons) {
                    if (button.r.intersects(event.getX(), event.getY(), 1, 1)) {
                        if (button.returnID().equals("back")) {
                            app.removeInstructions();
                            app.drawMenu();
                        }
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
            for(Button button : Credits.buttons) {
                if(button.r.intersects(event.getX(), event.getY(), 1, 1)) {
                    button.r.setFill(Color.RED);
                } else {
                    button.r.setFill(Color.FORESTGREEN);
                }
            }

            for (Button button : SideMenu.buttons) {
                if (button.r.intersects(event.getX(), event.getY(), 1, 1)) {
                    button.r.setFill(Color.RED);
                } else {
                    button.r.setFill(Color.FORESTGREEN);
                }
            }

            if(app.inGame) {
                for(Tile tile : Tile.tiles) {
                    if(tile.contains(event.getX(), event.getY())) {
                        if (tile.getType() == Tile.Type.ENEMY) {
                            tile.setStroke(Color.YELLOW);
                        }
                    } else {
                        tile.setStroke(Color.TRANSPARENT);
                    }
                }
            }
             if (app.inInstuctions) {
                 for (Button button : Instructions.buttons) {
                     if (button.r.intersects(event.getX(), event.getY(), 1, 1)) {
                         button.r.setFill(Color.RED);
                     } else {
                         button.r.setFill(Color.FORESTGREEN);
                     }
                 }
             }
             if(app.inSideMenu) {
                 for (Button button : SideMenu.buttons) {
                     if (button.r.intersects(event.getX() - 685, event.getY()-45, 1, 1)) {
                         button.r.setFill(Color.RED);
                     } else {
                         button.r.setFill(Color.FORESTGREEN);
                     }
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
                            if (tower.intersects(x, y, 50, 50)) {
                                return;
                            }
                        }
                    }
                    Sniper newtower = new Sniper((int)tile.getX(), (int)tile.getY());
                    //First newtower = new First(x, y);
                    app.board.getChildren().add(newtower.getGroup());
                }
            }
        }
    }


}
