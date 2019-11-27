package sample;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Game {
    Level level;
    Parent pane;
    Scene gameScene;

    Game(Level level, ActionEvent event) {
        this.level = level;
        this.pane = this.level.getPane();
        gameScene = new Scene(pane);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(gameScene);
        window.show();
    }
}
