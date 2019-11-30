package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;

public class Game {
    Level level;
    FXMLLoader loader;
    Parent pane;
    Scene gameScene;

    Game(Level level, ActionEvent event, int load) throws IOException {
        this.level = level;
        this.loader = this.level.getPane();
//
        pane = loader.load();
        gameScene = new Scene(pane);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(gameScene);
        window.show();
    }
}
