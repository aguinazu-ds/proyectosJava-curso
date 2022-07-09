package classes;

import interfaces.PokemonInterface;

public abstract class AbstractPokemon implements PokemonInterface {
    public Pokemon createPokemon(String name, Integer health, String type) {
        return new Pokemon(name, health, type);
    }
    public String pokemonInfo(Pokemon pokemon) {
        return "Pokemon: " + pokemon.getName() + ", Tipo: " + pokemon.getType() + ", HP: " + pokemon.getHealth(); 
    }
}
