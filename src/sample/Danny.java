package sample;

public class Danny extends Plant {

    public class JonSnow extends Plant{

        {
            this.cost = 200;
            this.health = 150;
            this.damage = 40;
            this.img = "src/sample/danny.png";
        }

        @Override
        public String getName() {
            return super.getName();
        }

        @Override
        public void setDamage(float damage) {
            super.setDamage(damage);
        }

        @Override
        public void setHealth(float health) {
            super.setHealth(health);
        }

        @Override
        public void attack(Zombies Z) {
            super.attack(Z);
        }

        @Override
        public float getHealth() {
            return super.getHealth();
        }

        @Override
        public float getDamage() {
            return super.getDamage();
        }

    }

}
