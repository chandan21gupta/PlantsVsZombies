package sample;

import javafx.animation.TranslateTransition;
//import javafx.application.Application;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.animation.AnimationTimer;
//import javafx.scene.Node;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
//import java.io.FileInputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
//import java.nio.file.Path;


class InvalidArguement extends Exception
{
    public InvalidArguement(String message){super(message);}
}

public class Level_One_Controller extends Application implements Initializable, Runnable  {

    @FXML
    public GridPane gridX;
    @FXML
    public AnchorPane gameScreen;

    Timer timer;
    boolean flag;
    int timerX = 0;
    int seconds = 5;

    ArrayList<Zombies> zombies = new ArrayList<>();
    ArrayList<Advice> advices = new ArrayList<>();

    int zombieCount = 20;

    Iterator iterZombie = zombies.iterator();

    String current_plant = null;
    Random r = new Random();
    public void generatePlant(MouseEvent event) {
       current_plant = event.getPickResult().getIntersectedNode().getId();
//       System.out.println(current_plant);
//       this.startAnimation();
    }

    public void onClickX(MouseEvent event){
        System.out.println("x: " + event.getX());
        System.out.println("y: "+ event.getY());
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
            image = new Image(img_url);
//            System.out.println(image.getUrl());
//            System.out.println(image.getHeight());
        }
        catch(Exception e) {
            //do nothing
        }

        ImageView imageView = new ImageView();
        imageView.setImage(image);
        //System.out.println(imageView.getImage());
        int[] value;
        try {
            value = getBox(event.getX(), event.getY());
            double x = event.getX();
            double y = event.getY();
            //System.out.println(value[0] + " " + value[1]);
            //System.out.println(x + " " + y);
            imageView.setFitHeight(60);
            imageView.setFitWidth(30);
            //System.out.println(gridX);
//            gameScreen
            gridX.add(imageView, value[0], value[1]);
        }
        catch (InvalidArguement invalidArguement) {
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

    public void generateZombies(int a) {
        String img_url = null;
        ImageView image = null;
        Zombies zombie;
        if (a==0){
            zombie = new NormalZombie(1);
        }
        else if (a==1){
            zombie = new NormalZombie1(1);
        }
        else{
            zombie = new NormalZombie2(1);
        }

        if (timerX >=110 & !flag){
            zombie = new SpecialZombie(1);
            flag = true;
        }

//        ImageView imageView = zombie.getImage();
//        System.out.println(imageView.getImage());
        int z = r.nextInt(5);
        image = zombie.getImage(z);
        gameScreen.getChildren().add(image);
        zombies.add(zombie);
        System.out.println("zombie");

    }

    public void generateAdvice() {
        String img_url = null;
        Image image = null;
        Advice advice = new Advice();
        img_url = advice.getName();
        try {
            File file = new File(img_url);

            img_url = file.toURI().toURL().toExternalForm();
            //System.out.println(img_url);
            image = new Image(img_url);
        }
        catch(Exception e) {
            //do nothing
        }
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(60);
        imageView.setFitWidth(30);
        int z = r.nextInt(5);
        if (z==0){
            imageView.setX(212);
            imageView.setY(15);
        }
        else if (z==1){
            imageView.setX(286);
            imageView.setY(40);
        }
        else if (z==2){
            imageView.setX(362);
            imageView.setY(51);
            //gridX.add(imageView,3,0);
        }
        else if (z==3){
            imageView.setX(371);
            imageView.setY(47);
            //gridX.add(imageView,4,0);
        }
        else{
            imageView.setX(508);
            imageView.setY(42);
            //gridX.add(imageView,5,0);
        }
        gameScreen.getChildren().add(imageView);

        advices.add(advice);
        TranslateTransition translate = new TranslateTransition();
        translate.setDuration(Duration.seconds(5));
        translate.setToY(371);
        translate.setNode(imageView);
        translate.setByY(imageView.getY());
        //translate.setToX();
        //translate.setCycleCount(500);
        //System.out.println("Translating...");
        translate.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        int seconds = 0;
        Timer t = new Timer();
//        seconds = 10;
//        int finalSeconds = seconds;
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()->{

                    if (timerX >= 50){
                        seconds = 2;
                    }
                    timerX += seconds;
                    if (timerX>=150){

                        t.cancel();
//                    t.notifyAll();
                    }
                    else{
                        System.out.println(timerX);
                        System.out.println(seconds);
                        int a = r.nextInt(3);
                        generateZombies(a);
                        generateAdvice();
//                        generateZombies();
                    }
                });
            }
        }, 0, seconds*1000);
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()->{
                    int i=0;

                    while(iterZombie.hasNext()){
//                        System.out.println(gameScreen.getChildren().get(i).getBoundsInLocal());
                        Zombies z = (Zombies) iterZombie.next();
                        z.move();
                        z.getImageView().setX(z.getX());
                        i+=1;
                    }
                });

            }
        }, 0, 5*100);
    }

    @Override
    public void run() {

    }

    @Override
    public void start(Stage stage) throws Exception {
        //TranslateTransition translate = new TranslateTransition();
    }
}

