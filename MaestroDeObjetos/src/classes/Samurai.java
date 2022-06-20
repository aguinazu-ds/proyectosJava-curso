package classes;

import races.Human;

public class Samurai extends Human {
    private static int counter;
    {
        counter++;
    }
    public Samurai() {
        super();
        this.health = 200;
    }
    public void deathBlow(Human human) {
        human.setHealth(0);
        this.health = this.health/2;
    }
    public void meditate() {
        this.health = this.health + this.health/2;
    }
    public static void howMany() {
        System.out.println("Hay " + counter + " samurai.");
    }
}
