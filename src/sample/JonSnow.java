package sample;

public class JonSnow implements Plant{

    private float health = 100;
    private float damage = 100;
    private final String img = "@../images/chars/johnSnow.png";

    public float getHealth() {
        return this.health;
    }
    public void setHealth(float health) {
        this.health = health;
    }
    public void attack() {

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
}
