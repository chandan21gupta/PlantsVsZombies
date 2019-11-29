package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class NormalZombie2 implements Zombies{
    private float health = 250;
    private float damage = 22;
    private int speed = 14;
    private int X;
    private int Y;
    private int levelX;
    private final String imgL1 = "src/images/chars/nightKingArmy2.png";
    private final String imgL2 = "src/images/chars/dannyArmy3.png";
    private final String imgL3 = "src/images/chars/cersieArmy3.png";

    public NormalZombie2(int x){
        levelX = x;
    }

    public float getHealth() {
        return this.health;
    }

    public void setHealth(float health) {
        this.health = this.health - health;
    }

    public void attack(Plant P) {
        P.setHealth(damage);
    }

    @Override
    public void move() {
        setX(speed);
    }

    @Override
    public int getX() {
        return X;
    }

    @Override
    public void setX(int a) {
        X = X-a;
    }

    @Override
    public int getY() {
        return Y;
    }

    @Override
    public void setY(int a) {
        Y = Y-a;
    }

    public float getDamage() {
        return this.damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public String getName() {
        if (levelX==1){
            return this.imgL1;
        }
        else if (levelX==2){
            return this.imgL2;
        }
        else if (levelX==3){
            return this.imgL3;
        }
        else return this.imgL1;
    }

    public ImageView getImage(){
        String img_url = null;
        Image image = null;
        img_url = this.getName();
        try {
            File file = new File(img_url);

            img_url = file.toURI().toURL().toExternalForm();
            System.out.println(img_url);
            image = new Image(img_url);
        }
        catch(Exception e) {
            //do nothing
        }
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(70);
        imageView.setFitWidth(40);
        return imageView;
    }

}
