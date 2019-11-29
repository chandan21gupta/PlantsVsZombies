package sample;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.net.URISyntaxException;
import java.nio.file.Path;


class InvalidArguement extends Exception{
    public InvalidArguement(String message){super(message);}
}

public class Level_One_Controller extends AnimationTimer  {
    @FXML
    public GridPane gridX;
    int zombieCount = 20;
    String current_plant = null;
    public void generatePlant(MouseEvent event) {
       current_plant = event.getPickResult().getIntersectedNode().getId();
       System.out.println(current_plant);
       this.startAnimation();
    }



    public void addPlant(MouseEvent event) throws URISyntaxException {
        if (current_plant == null)
            return;
        String img_url = null;
        Image image = null;
        if (current_plant.equals("jonSnow")) {
            Plant jonSnow = new JonSnow();
            img_url = jonSnow.getName();
//            System.out.println(img_url);
        }
        try {
            File file = new File(img_url);
            img_url = file.toURI().toURL().toExternalForm();
//            System.out.println(img_url);
            image = new Image(img_url);
            System.out.println(image.getUrl());
//            System.out.println(img_url);
            System.out.println(image.getHeight());
        }
        catch(Exception e) {
            //do nothing
        }

//        imageView.setImage(image);
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            System.out.println(imageView.getImage());
            int[] value;
            try {
                value = getBox(event.getX(), event.getY());
                double x = event.getX();
                double y = event.getY();
                System.out.println(value[0] + " " + value[1]);
                System.out.println(x + " " + y);
//            imageView.setX(value[0]);
//            imageView.setY(value[1]);
                imageView.setFitHeight(60);
                imageView.setFitWidth(30);
                System.out.println(gridX);
                gridX.add(imageView, value[0], value[1]);

//            current_plant = null;
            } catch (InvalidArguement invalidArguement) {
                System.out.println("error");
            }

            current_plant = null;
        }


        public int[] getBox ( double x, double y) throws InvalidArguement {
            int cordX = 0;
            int cordY = 0;
            int[] vals = new int[2];

            if (y <= 56.0 & y > 0.0) {
                cordY = 0;
            } else if (y <= 120.0) {
                cordY = 1;
            } else if (y <= 180.0) {
                cordY = 2;
            } else if (y <= 240.0) {
                cordY = 3;
            } else if (y < 300.0) {
                cordY = 4;
            } else {
                throw new InvalidArguement("Invalid");
            }

            if (x <= 71.0 & x > 0.0) {
                cordX = 0;
            } else if (x <= 151.0) {
                cordX = 1;
            } else if (x <= 228.0) {
                cordX = 2;
            } else if (x <= 303.0) {
                cordX = 3;
            } else if (x <= 378.0) {
                cordX = 4;
            } else if (x <= 445.0) {
                cordX = 5;
            } else throw new InvalidArguement("Invalid");

            vals[0] = cordX;
            vals[1] = cordY;
            return vals;
        }

    public void startAnimation() {
        this.start();
    }

    public void handle(long now) {
        generateZombies();
    }

    public void generateZombies() {
        if(this.zombieCount <= 20 && this.zombieCount >=19) {
            Zombies zombie = new NormalZombie(1);
            TranslateTransition trans = new TranslateTransition(Duration.seconds(2));
            trans.setFromX(345);
            trans.setToX(35.6);
            trans.setCycleCount(TranslateTransition.INDEFINITE);
            trans.play();
            zombieCount--;
        }
        else {
            this.stop();
        }
    }
}

