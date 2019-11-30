package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class SpecialZombie extends Zombies{

    public SpecialZombie(int x) {
        super(x);
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
}
