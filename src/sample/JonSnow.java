package sample;

public class JonSnow implements Plant{

    private float health = 100;
    private float damage = 10;
    private final String img = "src/sample/johnSnow.png";

    public float getHealth() {
        return this.health;
    }
    public void setHealth(float health) {
        this.health = this.health - health;
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
}
