public class Gorilla extends Mammal{
    public Gorilla(){
    }
    public void throwSomething() {
        System.out.println("El Gorila lanzó una piedra!!");
        this.energyLevel = this.energyLevel - 5;        
    }

    public void eatBananas() {
        System.out.println("El Gorila se comió una Banana!!");
        this.energyLevel = this.energyLevel + 10;
    }

    public void climb() {
        System.out.println("El Gorila trepó la cima de un árbol!!");
        this.energyLevel = this.energyLevel - 10;
    }
}
