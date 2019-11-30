package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class NormalZombie2 extends Zombies{

    public NormalZombie2(int x) {
        super(x);
        this.speed = 9;
        this.health = 250;
        this.damage = 15;
        this.imgL1 = "src/images/chars/nightKingArmy2.png";
        this.imgL2 = "src/images/chars/dannyArmy3.png";
        this.imgL3 = "src/images/chars/cersieArmy3.png";


    }

    @Override
    public float getDamage() {
        return super.getDamage();
    }

    @Override
    public float getHealth() {
        return super.getHealth();
    }

    @Override
    public ImageView getImage(int z) {
        return super.getImage(z);
    }

    @Override
    public double getX() {
        return super.getX();
    }

    @Override
    public double getY() {
        return super.getY();
    }

    @Override
    public String getName() {

        return super.getName();
    }

    @Override
    public void attack(Plant P) {
        super.attack(P);
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void setHealth(float health) {
        super.setHealth(health);
    }

    @Override
    public void setDamage(float damage) {
        super.setDamage(damage);
    }

    @Override
    public void setX(int a) {
        super.setX(a);
    }

    @Override
    public void setY(int a) {
        super.setY(a);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public ImageView getImageView() {
        return super.getImageView();
    }

    @Override
    public void setFlag(boolean t) {
        super.setFlag(t);
    }

    @Override
    public boolean getFlag() {
        return super.getFlag();
    }
}
