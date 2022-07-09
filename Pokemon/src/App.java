import classes.Pokedex;
import classes.Pokemon;

public class App {
    public static void main(String[] args) throws Exception {
        Pokedex pokedex = new Pokedex();
        Pokemon pokemon1 = pokedex.createPokemon("Pikachu", 100, "Electrico");
        Pokemon pokemon2 = pokedex.createPokemon("Charizard", 100, "Fuego");
        pokedex.listPokemon();
        pokemon1.attackPokemon(pokemon2);
        System.out.println(pokemon2.getHealth());
    }
}
