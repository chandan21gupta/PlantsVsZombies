package sample;

import javafx.animation.TranslateTransition;
//import javafx.application.Application;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.animation.AnimationTimer;
//import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
//import java.io.FileInputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
//import java.nio.file.Path;

class WinnerException extends Exception {
    public WinnerException(String s) {
        super(s);
    }
}

class LoserException extends Exception {
    public LoserException(String s) {
        super(s);
    }
}

class MyTimer implements java.lang.Runnable{

    int level;
    ArrayList<Zombies> zombies = new ArrayList<Zombies>();
    MyTimer(int level,ArrayList<Zombies> zombies) {
        this.level = level;
        this.zombies = zombies;
    }

    @Override
    public void run() {
        this.runTimer();
    }

    public void runTimer(){
        int i = 0;
        if(this.level == 1) {
            i = 2;
        }
        else if(this.level == 2) {
            i = 120;
        }
        else if(this.level == 3) {
            i = 180;
        }
        else if(this.level == 4) {
            i = 240;
        }
        else {
            i = 300;
        }
        while (i>0){
            //System.out.println("Remaining: "+i+" seconds");
            try {
                i--;
                Thread.sleep(1000L);    // 1000L = 1000ms = 1 second
                if(i == 0 && zombies.size() == 0) {
                    throw new WinnerException("You Won");
                }
                else if(i == 0 && zombies.size() > 0) {
                    throw new LoserException("You Lose");
                }
            }
            catch (WinnerException e) {
                //I don't think you need to do anything for your particular problem
            }
            catch (LoserException e) {
                System.out.println(e.getMessage());
            }
            catch(InterruptedException e) {
                //do nothing
            }
        }
    }

}

class InvalidArguement extends Exception
{
    public InvalidArguement(String message){super(message);}
}

public class Level_One_Controller extends Application implements Initializable, Runnable, Serializable {
//    Level_One_Controller x;
    private static final long serialVersionUID = 6529685098267757690L;
    Level_One_Controller x = this;
    @FXML
    public GridPane gridX;
    @FXML
    public AnchorPane gameScreen;

    @FXML
    public Label scoreX;

    Timer t;
    boolean flag;
    int timerX = 0;
    int seconds = 5;
    transient int deserialized;
    int counter;
    int level;

    public Level_One_Controller(int a, int level){
        this.deserialized = a;
        this.level = level;
    }

    public ArrayList<Zombies> zombies = new ArrayList<>();
    public ArrayList<Advice> advices = new ArrayList<>();
    public ArrayList<Sword> swords = new ArrayList<>();
    public ArrayList<Plant> plants = new ArrayList<>();

    HashMap<Double,Double> zombies_coordinates = new HashMap<>();
    HashMap<Double,Double> plants_coodrdinates = new HashMap<>();
    HashMap<Double,Double> swords_coordinates = new HashMap<>();
    HashMap<Double,Double> advices_coordinates = new HashMap<>();

    private String current_plant = null;
    private Random r = new Random();


    public void generatePlant(MouseEvent event) {
       current_plant = event.getPickResult().getIntersectedNode().getId();
       System.out.println(current_plant);
//       this.startAnimation();
    }

    public void onClickX(MouseEvent event){
        //System.out.println("x: " + event.getX());
        //System.out.println("y: "+ event.getY());
    }

    public void generateSword(int x,int y) {
        Sword sword = new Sword(5);
        ImageView imageViewSw = sword.getImage(x,y);
        swords.add(sword);
        gameScreen.getChildren().add(imageViewSw);
    }

    public void addPlant(MouseEvent event) throws URISyntaxException {
        int price = 0;
        if (current_plant == null)
            return;
        String img_url = null;
        Image image = null;
        Plant plt = new JonSnow();
        //double x = 0;
        //double y = 0;
        if (current_plant.equals("jonSnow")) {
            plt = new JonSnow();
            price = plt.getCost();
            img_url = plt.getName();

//            System.out.println(img_url);
        } else if (current_plant.equals("shield")) {
            plt = new Shield();
            price = plt.getCost();
            img_url = plt.getName();
            System.out.println(img_url);
        } else if (current_plant.equals("arya")) {
            plt = new Arya();
            price = plt.getCost();
            img_url = plt.getName();
            System.out.println(img_url);
        } else if (current_plant.equals("tyrion")) {
            plt = new Tyrion();
            price = plt.getCost();
            img_url = plt.getName();
            System.out.println(img_url);
        } else if (current_plant.equals("danny")) {
            plt = new Danny();
            price = plt.getCost();
            img_url = plt.getName();
            System.out.println(img_url);
        }
        if (price > Integer.parseInt(scoreX.getText())) {
            counter = counter;
        } else {
            try {
                File file = new File(img_url);
                img_url = file.toURI().toURL().toExternalForm();
                image = new Image(img_url);
//            System.out.println(image.getUrl());
//            System.out.println(image.getHeight());
            } catch (Exception e) {
                //do nothing
            }

            ImageView imageView = new ImageView();
            imageView.setImage(image);
            //System.out.println(imageView.getImage());
            int[] value;
            try {
                value = getBox(event.getX(), event.getY());
                plt.setXCord(value[1]);
                plt.setYCord(value[0]);
                plt.setCoordinates(value[1], value[0]);
                double x = event.getX();
                double y = event.getY();
                //System.out.println(value[0] + " " + value[1]);
                //System.out.println(x + " " + y);
                imageView.setFitHeight(60);
                imageView.setFitWidth(30);
                //System.out.println(gridX);
//            gameScreen
                gridX.add(imageView, value[0], value[1]);
//            generateSword(value[1]);
            } catch (InvalidArguement invalidArguement) {
                System.out.println("error");
            }
            plants.add(plt);
            ScoreCounter(-price);
            current_plant = null;
        }
    }

    public void checkPlantHealth() {
        Iterator<Plant> i = plants.iterator();
        while(i.hasNext()) {
            Plant plant = i.next();
            if(plant.getHealth()<=0) {
                System.out.println("Plant's Health: "+plant.getHealth());
                //plant.getImageView().setImage(null);
//                System.out.println(plant.xCord);
//                System.out.println(plant.yCord);
                getNodeByRowColumnIndex(plant.xCord,plant.yCord,gridX);
//                gridX.getChildren().remove(plant.xCord,plant.yCord);
                //System.out.println(plant);
                i.remove();
            }
        }
    }
    public void getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                childrens.remove(node);
                break;
            }
        }
    }

    public void checkZombieHealth() throws InvalidArguement {
        Iterator<Zombies> j = zombies.iterator();
        while (j.hasNext()) {
            Zombies zombie = j.next();
            if (zombie.getHealth() <= 0) {
                //System.out.println("zombie's health "+zombie.getHealth());
                gameScreen.getChildren().remove(zombie.getImageView());
                j.remove();
            }
            else{
                if (zombie.speed==0){
//                    zombie.setHealth(zombie.getHealth()-50);
                    System.out.println(zombie.getHealth());
                    zombie.setSpeed(-1);
                }
            }
        }
    }


    public void checkPlantCollision() {
        for(int i = 0; i < plants.size(); i++)
        {
            Plant plant = plants.get(i);
            for(int j = 0; j < zombies.size(); j++)
            {

                Zombies zombie = zombies.get(j);

                if(Math.abs(plant.X - zombie.getImageView().getX()) < 30 && (plant.Y == zombie.getImageView().getY()))
                {
                    if (!zombie.canMove) {
                        zombie.setSpeed(0);
                    }
                    plant.setHealth(plant.getHealth()-zombie.getDamage());
                    System.out.println(plant.getHealth());
                    if (plant.getHealth()<=0){
                        zombie.canMove = true;
                        checkPlantHealth();
                        zombie.setSpeed(-1);

                    }
//                    zombie.setHealth(zombie.getHealth()-plant.getDamage());
//                    plant.setHealth(plant.getHealth()-zombie.getDamage());
//                    zombie.setFlag(false);
                    break;
                }
            }
        }
    }

    public void checkSwordCollision() {

        for(int i = 0; i < swords.size(); i++)
        {   Sword sword = swords.get(i);

            for(int j = 0; j < zombies.size(); j++)
            {
                Zombies zombie = zombies.get(j);

                if((Math.abs(sword.getX()- zombie.getImageView().getX())<20 )&& (sword.getY() == zombie.getImageView().getY()))
                {   if (!sword.flag)
                    {
                        System.out.println(zombie);
                        System.out.println(sword);
                        System.out.println("Zombie's health before " + zombie.getHealth());
                        zombie.setHealth(zombie.getHealth() - sword.getDamage());
                        //zombie.setFlag(false);
                        gameScreen.getChildren().remove(sword.getImageView());
                        System.out.println("Zombie's health after " + zombie.getHealth());
                        //System.out.println("remove sword");
                        //System.exit(1);
                        sword.flag = true;
                        break;
                    }
                }
            }
        }
    }

    private int[] getBox(double x, double y) throws InvalidArguement {
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

    private Zombies generateZombies(int a) {
        String img_url = null;
        ImageView image = null;
        Zombies zombie;
        if (a==0){
            zombie = new NormalZombie(level);
        }
        else if (a==1){
            zombie = new NormalZombie1(level);
        }
        else{
            zombie = new NormalZombie2(level);
        }

        if (timerX >=110 & !flag){
            zombie = new SpecialZombie(level);
            flag = true;
        }

//        ImageView imageView = zombie.getImage();
//        System.out.println(imageView.getImage());
        int z = r.nextInt(5);
        image = zombie.getImage(z);
        gameScreen.getChildren().add(image);
        zombies.add(zombie);
        //System.out.println("zombie");
        return zombie;

    }

    private void generateAdvice() {
        String img_url = null;
        Image image = null;
        Advice advice = new Advice();
        ImageView imageView = advice.getImageView();
        imageView.setFitHeight(60);
        imageView.setFitWidth(30);
        int z = r.nextInt(5);
        if (z==0){
            imageView.setX(212);
            imageView.setY(15);
        }
        else if (z==1){
            imageView.setX(286);
            imageView.setY(15);
        }
        else if (z==2){
            imageView.setX(362);
            imageView.setY(15);
            //gridX.add(imageView,3,0);
        }
        else if (z==3){
            imageView.setX(371);
            imageView.setY(15);
            //gridX.add(imageView,4,0);
        }
        else{
            imageView.setX(508);
            imageView.setY(15);
            //gridX.add(imageView,5,0);
        }
        gameScreen.getChildren().add(imageView);

        advices.add(advice);
        TranslateTransition translate = new TranslateTransition();
        translate.setDuration(Duration.seconds(5));
        translate.setToY(400);
        translate.setNode(imageView);
        translate.setByY(imageView.getY());
        //translate.setToX();
        //translate.setCycleCount(500);
        //System.out.println("Translating...");
        translate.play();
        imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Advices clicked");
                gameScreen.getChildren().remove(imageView);
                ScoreCounter(50);
                event.consume();

            }
        });
    }

    public void ScoreCounter(int val){
        counter = Integer.valueOf(scoreX.getText())+val;
        scoreX.setText(Integer.toString(counter));
    }

    private void genPlant(double x, double y){
        String img_url = null;
        Image image = null;

        Plant plt =new JonSnow();
        img_url = plt.getName();
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
        plt.setXCord((int)x);
        plt.setYCord((int) y);
        plt.setCoordinates((int)x,(int)y);
        imageView.setFitHeight(60);
        imageView.setFitWidth(30);
        //System.out.println(gridX);
//            gameScreen
        gridX.add(imageView, (int)x,(int) y);
//        p.setCoordinates((int)x,(int)y);
        plants.add(plt);
    }

    public void desearlize(){
        ObjectInputStream in = null;
        String fileName = "filesave.txt";
        try {
            Level_One_Controller data = (Level_One_Controller) ResourceManager.load(fileName);
            this.zombies_coordinates = data.zombies_coordinates;
            this.advices_coordinates = data.advices_coordinates;
            this.swords_coordinates = data.swords_coordinates;
            this.plants_coodrdinates = data.plants_coodrdinates;
            this.timerX = data.timerX;
            this.flag = data.flag;
            this.seconds = data.seconds;
//            this.gameScreen = data.gameScreen;
//            this.gridX = data.gridX;
            System.out.println("Success");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void serialize(){
        Level_One_Controller data = new Level_One_Controller(this.deserialized,this.level);
        data.timerX = this.timerX;
        data.flag = this.flag;
        data.seconds = this.seconds;
        Iterator i = zombies.iterator();
        while(i.hasNext()) {
            Zombies z = (Zombies)(i.next());
            zombies_coordinates.put(z.getImageView().getX(),z.getImageView().getY());
        }
        Iterator j = swords.iterator();
        while(j.hasNext()) {
            Sword s = (Sword)(j.next());
            swords_coordinates.put(s.getImageView().getX(),s.getImageView().getY());
        }
        Iterator z = plants.iterator();
        while(z.hasNext()) {
            Plant p = (Plant)(z.next());
            plants_coodrdinates.put((double)p.yCord,(double)p.xCord);
        }
        Iterator k = advices.iterator();
        while(k.hasNext()) {
            Advice a = (Advice)(k.next());
            advices_coordinates.put(a.getImageView().getX(),a.getImageView().getY());
        }
        data.zombies_coordinates = zombies_coordinates;
        data.plants_coodrdinates = plants_coodrdinates;
        data.swords_coordinates = swords_coordinates;
        data.advices_coordinates = advices_coordinates;
        try {
            ResourceManager.save(data, "filesave.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Serialized");
//        System.out.println(data.plants.size());
//        System.out.println(data.advices.size());
//        System.out.println(data.zombies.size());
//        System.out.println(data.swords.size());
        System.out.println(plants_coodrdinates.size());
        System.out.println(data.timerX);
        System.out.println(data.seconds);
        System.out.println(data.flag);
        System.out.println(data.gridX);
        System.out.println(data.gameScreen);
        exit();
    }

    public void exit(){
        System.exit(1);
    }

    public void generateAdvices(int x, int y){
        String img_url = null;
        Image image = null;
        Advice advice = new Advice();
        ImageView imageView = advice.getImageView();
        imageView.setFitHeight(30);
        imageView.setFitWidth(25);
        advice.setCoordinates(x,y);
        imageView.setX(advice.getX());
        imageView.setY(advice.getY());
        gameScreen.getChildren().add(imageView);
        advices.add(advice);
        imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Advices clicked");
                gameScreen.getChildren().remove(imageView);
                ScoreCounter(25);
                event.consume();

            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Thread thread = new Thread(new MyTimer(level,zombies));
        thread.start();

        if (deserialized==1){
            desearlize();
            zombies_coordinates.forEach((k,v) -> {
                double x = (double) k;
                double y = (double) v;
                Zombies z = generateZombies(2);
                z.setX((int)x);
                z.setY((int)y);
            });
            plants_coodrdinates.forEach((k,v)->{
                double x = (double) k;
                double y = (double) v;
                genPlant(x,y);

            });
        }

//        int seconds = 0;
        t = new Timer();
//        seconds = 10;
//        int finalSeconds = seconds;

        //Generates Zombies
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
                        //System.out.println(timerX);
                        System.out.println(seconds);
                        int a = r.nextInt(3);
                        generateZombies(a);
//                        generateAdvice();
//                        generateZombies();
                    }

                });
            }
        }, 5000, (seconds+6)*1000);

        //Makes the Zombies Move
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()->{
                    int i=0;
                    while(i<zombies.size()){
//                        System.out.println(gameScreen.getChildren().get(i).getBoundsInLocal());
                        Zombies z = zombies.get(i);
                        z.move();
                        z.getImageView().setX(z.getX());
                        i+=1;
                    }
                });

            }
        }, 1000, 4*100);

        //Generate Sword
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()->{
                    int i = 0;
                    while(i<swords.size()){
//                        System.out.println("hi");
                        Sword s = swords.get(i);
                        s.move();
                        s.getImageView().setX(s.getX());
                        i+=1;
                    }

                });
            }
        }, 0, 1*100);

        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()->{
                    int i = 0;
                    while(i<plants.size()){
//                        System.out.println("hi");
                        Plant p = plants.get(i);
                        if (p.getFlag()==1) {
                            generateSword(p.xCord, p.yCord);
                        }
                        i+=1;
                    }

                });
            }
        }, 0, 1*1000);

        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    checkSwordCollision();
                    checkPlantCollision();
//                    checkSwordCollision();
//                    checkPlantCollision();
                    try {
                        checkZombieHealth();
                    } catch (InvalidArguement invalidArguement) {
                        invalidArguement.printStackTrace();
                    }
                    checkPlantHealth();
                });
            }
        },0,100);

        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()->{
                    int z = 0;
                    while (z<plants.size()){
                        Plant p = plants.get(z);
                        if(p.getFlag()==2){
                            System.out.println("here");
                            generateAdvices(p.xCord,p.yCord);
                        }
                        z+=1;
                    }

                });
            }
        }, 4000, 7*1000);

        t.schedule(new TimerTask() {
            @Override
            public void run() {
            Platform.runLater(()->{
                generateAdvice();
            });
        }
        },5000,4000);
    }

    @Override
    public void run() {

    }

    @Override
    public void start(Stage stage) throws Exception {
        //TranslateTransition translate = new TranslateTransition();
    }
}

