package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Plant implements Serializable {
    protected float health = 100;
    protected float damage = 10;
    protected String img;
    protected int cost = 50;
    public int xCord;
    public int yCord;
    public double X;
    public double Y;
    public ImageView imageViewX = new ImageView();
    int isShooter;
    //ArrayList<Sword> swords = new ArrayList<Sword>();

    public Plant() {
    }

    public void setCoordinates(int z, int y){

        if (y==0){
            imageViewX.setX((double) 110);
            X = (double) 110;
        }
        else if (y==1){
            imageViewX.setX((double)180);
            X = (double) 180;
        }
        else if (y==2){
            imageViewX.setX((double)250);
            X = (double) 250;
        }
        else if (y==3){
            imageViewX.setX((double)330);
            X = (double) 330;
        }
        else if (y==4){
            imageViewX.setX((double)410);
            X = (double) 410;
        }
        else if (y==5){
            imageViewX.setX((double)490);
            X = (double) 490;
        }

        if (z==0){
            imageViewX.setY((double) 90);
            Y = (double) 90;
        }
        else if (z==1){
            imageViewX.setY((double) 148);
            Y = (double) 148;
        }
        else if(z==2){
            imageViewX.setY((double) 213);
            Y = (double) 213;
        }
        else if(z==3){
            imageViewX.setY((double) 271);
            Y = (double) 271;
        }
        else{
            imageViewX.setY((double) 331);
            Y = (double) 331;
        }
        //System.out.println(imageViewX.getY());
    }

    public float getHealth() {
        return this.health;
    }
    public void setHealth(float health) {
        this.health = health;
    }
    public void attack(Zombies Z) {
        Z.setHealth(damage);
    }
    public float getDamage() {
        return this.damage;
    }
    public void setDamage(float damage) {
        this.damage = damage;
    }
    public String getName() {
        return this.img;
    }
    public int getCost(){
        return this.cost;
    }

    public void setXCord(int i) {
        this.xCord = i;
    }

    public void setYCord(int z){
        this.yCord = z;
    }

    public ImageView getImage() {
        String img_url = null;
        Image image = null;
        img_url = this.getName();
        try {
            File file = new File(img_url);

            img_url = file.toURI().toURL().toExternalForm();
            //System.out.println(img_url);
            image = new Image(img_url);
        }
        catch(Exception e) {
            //do nothing
        }
        imageViewX.setImage(image);
        imageViewX.setFitHeight(66);
        imageViewX.setFitWidth(40);
        return imageViewX;
    }

    public ImageView getImageView(){
        return this.imageViewX;
    }

    public int getFlag(){
        return isShooter;
    }
}
