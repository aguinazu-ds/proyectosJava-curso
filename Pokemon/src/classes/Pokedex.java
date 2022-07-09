package classes;

import java.util.ArrayList;

public class Pokedex extends AbstractPokemon {
    ArrayList<Pokemon> myPokemons = new ArrayList<Pokemon>();

    @Override
    public Pokemon createPokemon(String name, Integer health, String type) {
        Pokemon pokemon = super.createPokemon(name, health, type);
        this.myPokemons.add(pokemon);
        return pokemon;
    }

    public void listPokemon() {
        for (Pokemon pokemon : myPokemons) {
            System.out.println(pokemon.getName());
        }
    }
}
