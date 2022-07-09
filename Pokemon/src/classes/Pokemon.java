package classes;
public class Pokemon {
    public String name;
    public Integer health;
    public String type;
    public static int count = 0;

    public Pokemon(String name, Integer health, String type) {
        this.name = name;
        this.health = health;
        this.type = type;
        count++;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealth() {
        return this.health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void attackPokemon(Pokemon pokemon) {
        pokemon.setHealth(pokemon.getHealth() - 10);
    }
}
