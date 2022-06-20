package classes;

import races.Human;

public class Wizard extends Human {
    public Wizard(){
        super();
        this.health = 50;
        this.intelligence = 8;
    }
    public void heal(Human human) {
        human.setHealth(human.getHealth() + this.intelligence);
    }
    public void fireBall(Human human) {
        human.setHealth(human.getHealth() - 3*this.intelligence);
    }    
}
