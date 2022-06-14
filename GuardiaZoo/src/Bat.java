public class Bat extends Mammal {
    public Bat(){
        super();
        this.energyLevel = 300;
    }

    public void fly() {
        System.out.println("El murcielago comienza a  volar");
        this.energyLevel = this.energyLevel - 50;  
    }

    public void eatHumans() {
        System.out.println("Bueno, no importa");
        this.energyLevel = this.energyLevel + 25;
    }

    public void attackTown() {
        System.out.println("Ciudad en llamas!!");
        this.energyLevel = this.energyLevel - 100;
    }
}
