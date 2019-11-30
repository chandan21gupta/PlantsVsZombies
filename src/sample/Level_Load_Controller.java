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

import java.io.*;
//import java.io.FileInputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
//import java.nio.file.Path;



public class Level_Load_Controller extends Application implements Initializable, Runnable, Serializable {
    Level_One_Controller x;
    private static final long serialVersionUID = 6529685098267757690L;
    @FXML
    public GridPane gridX;
    @FXML
    public AnchorPane gameScreen;

    Timer t;
    boolean flag;
    int timerX = 0;
    int seconds = 5;

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
//       System.out.println(current_plant);
//       this.startAnimation();
    }

    public void onClickX(MouseEvent event){
        System.out.println("x: " + event.getX());
        System.out.println("y: "+ event.getY());
    }

    public void generateSword(int x,int y) {
        Sword sword = new Sword();
        ImageView imageViewSw = sword.getImage(x,y);
        swords.add(sword);
        gameScreen.getChildren().add(imageViewSw);
    }

    public void addPlant(MouseEvent event) throws URISyntaxException {
        if (current_plant == null)
            return;
        String img_url = null;
        Image image = null;
        Plant plt = new JonSnow();
        //double x = 0;
        //double y = 0;
        if (current_plant.equals("jonSnow")) {
            plt = new JonSnow();
            img_url = plt.getName();
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
            plt.setXCord(value[1]);
            plt.setYCord(value[0]);
            plt.setCoordinates(value[1],value[0]);
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
        }
        catch (InvalidArguement invalidArguement) {
            System.out.println("error");
        }
        plants.add(plt);
        current_plant = null;


    }

    public void checkPlantCollision() {
        for(int i = 0; i < plants.size(); i++)
        {
            for(int j = 0; j < zombies.size(); j++)
            {
                Plant plant = plants.get(i);
                Zombies zombie = zombies.get(j);

                if(plant.X == zombie.getImageView().getX() &&
                        plant.Y == zombie.getImageView().getY())
                {
                    //plants.remove(plant);
                    //gameScreen.getChildren().remove(plant.getImage());
                    System.out.println(plant.X + " " + zombie.getImageView().getX());
                    System.out.println(plant.Y+" "+zombie.getImageView().getY());
                    System.out.println("remove plant");
                    //System.exit(1);
                    continue;
                }
            }
        }
    }

    public void checkSwordCollision() {
        for(int i = 0; i < swords.size(); i++)
        {
            for(int j = 0; j < zombies.size(); j++)
            {
                Sword sword = swords.get(i);
                Zombies zombie = zombies.get(j);

                if((Math.abs(sword.getX()- zombie.getImageView().getX())<10 )&& (sword.getY() == zombie.getImageView().getY()))
                {
                    gameScreen.getChildren().remove(sword.getImageView());
                    System.out.println("remove sword");
                    //System.exit(1);
                    continue;
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

    private void generateZombies(int a) {
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

    private void generateAdvice() {
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

    public void desearlize(String name){
        ObjectInputStream in = null;
        String fileName = name +".txt";
//        try{
////            FileInputStream fis = new FileInputStream("student.ser");
//            in = new ObjectInputStream(new FileInputStream(fileName));
//            x = (Level_One_Controller) in.readObject();
//            this.plants = x.plants;
//            System.out.println(plants.size());
//            this.advices = x.advices;
//            System.out.println(advices.size());
//            this.zombies = x.zombies;
//            System.out.println(zombies.size());
//            this.swords = x.swords;
//            System.out.println(swords.size());
//            this.timerX = x.timerX;
//            System.out.println(timerX);
//            this.seconds = x.seconds;
//            System.out.println(seconds);
//            this.flag = x.flag;
//            System.out.println(flag);
//            this.gridX = x.gridX;
//            System.out.println(gridX);
//            this.gameScreen = x.gameScreen;
//            System.out.println(gameScreen);
//            System.out.println("deserialized");
//
//        }
//        catch (Exception e) {
//            x = new Level_One_Controller();
//            System.out.println(x);
//        }
        try {
            Level_Load_Controller data = (Level_Load_Controller) ResourceManager.load(fileName);
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
//        ObjectOutputStream out = null;
//        String fileName = "file" +".txt";
//        try{
//            System.out.println(fileName);
//            out = new ObjectOutputStream(new FileOutputStream(fileName));
//            out.writeObject(x);
//            out.close();
//            System.out.println("serialized");
//            System.out.println(x);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
        Level_One_Controller data = new Level_One_Controller();
//        data.zombies = this.zombies;
//        data.advices = this.advices;
//        data.swords = this.swords;
//        data.plants = this.plants;
        data.timerX = this.timerX;
        data.flag = this.flag;
        data.seconds = this.seconds;
//        data.gameScreen = this.gameScreen;
//        data.gridX = this.gridX;
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
            plants_coodrdinates.put(p.getImage().getX(),p.getImage().getY());
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
            ResourceManager.save(data, "savefile");
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        int seconds = 0;
        desearlize("file");



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
        }, 1000, 2*100);

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
                        generateSword(p.xCord,p.yCord);
//                        p.move();
//                        p.getImageView().setX(s.getX());
                        i+=1;
                    }

                });
            }
        }, 0, 4*1000);

        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    checkSwordCollision();
                    checkPlantCollision();
                    checkSwordCollision();
                });
            }
        },0,1);
    }

    @Override
    public void run() {

    }

    @Override
    public void start(Stage stage) throws Exception {
        //TranslateTransition translate = new TranslateTransition();
    }


}


