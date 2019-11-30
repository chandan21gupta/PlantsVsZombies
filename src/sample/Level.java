package sample;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Level {
    ArrayList<String> lev = new ArrayList<>();
    {
        lev.add("playScreen");
        lev.add("Level2");
        lev.add("Level3");
        lev.add("Level4");
    }
    int level = 1;
    Parent gameScreen;
    Level(int level,int load) {
        String name;
        if (load==1){
            name = lev.get(level-1)+"Load"+".fxml";
        }
        else{
            name = lev.get(level-1)+".fxml";
        }
        this.level = level;
        if(this.level == 1) {
            try {
                this.gameScreen = FXMLLoader.load(getClass().getResource(name));
            }
            catch(Exception e) {
                System.out.println("Nothing on ground level");
            }
        }
        else if(this.level == 2) {
            try {
                this.gameScreen = FXMLLoader.load(getClass().getResource(name));
            }
            catch(Exception e) {
                System.out.println("Nothing on level 2");
            }
        }
        else if(this.level == 3) {
            try {
                this.gameScreen = FXMLLoader.load(getClass().getResource(name));
            }
            catch(Exception e) {
                System.out.println("Nothing on level 3");
            }
        }
        else if(this.level == 4) {
            try {
                this.gameScreen = FXMLLoader.load(getClass().getResource(name));
            }
            catch(Exception e) {
                System.out.println("Nothing on level 4");
            }
        }
//        else if(this.level == 5) {
//
//        }
    }

     Parent getPane() {
        return this.gameScreen;
    }
}
