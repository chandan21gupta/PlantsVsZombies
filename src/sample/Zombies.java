package sample;

public interface Zombies {
    public float getHealth();
    public void setHealth(float health);
    public float getDamage();
    public void setDamage(float damage);
    public String getName();
    public void attack(Plant P);
    public void move();
}
