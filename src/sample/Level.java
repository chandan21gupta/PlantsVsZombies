package sample;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Level {
    int level = 1;
    Parent gameScreen;
    Level(int level,Parent gameScreen) {
        this.level = level;
        this.gameScreen = gameScreen;
        if(this.level == 1) {
            JonSnow jon = new JonSnow();
            String url = jon.getName();
            try {
                Image image = new Image(new FileInputStream(url));
                ImageView imageView = new ImageView(image);
                imageView.setPreserveRatio(true);
            }
            catch(Exception e) {

            }

        }
        else if(this.level == 2) {

        }
        else if(this.level == 3) {

        }
        else if(this.level == 4) {

        }
        else if(this.level == 5) {

        }
    }

     Parent getPane() {
        return this.gameScreen;
    }
}
