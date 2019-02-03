import java.util.*;
public class ComputerTrainer extends PokemonTrainer
{
    // private constants
    // Possible pokemon names and move names to generate random Pokemon
    private static final String[] POKEMON_NAMES = {"Pikachu", "Bulbasaur", "Charmander", "Squirtle"};
	private static final String[] MOVE_NAMES = {"Secret Power", "Slash", "Rock Smash", "Thrash", "Quick Attack"};
	private static final int MAX_DAMAGE = 25;
	private static final int MAX_MOVES = 4;
	private static final int MAX_POKEMON = 2;
	private String name = "Ash";
    private ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();
    private ArrayList<Move> arr = new ArrayList<Move>();
	private PokemonImages images = new PokemonImages();

    // Write your ComputerTrainer class here!
    
    // Write a Constructor that sets the name of the ComputerTrainer
    // and adds 2 randomly generated Pokemon to itself
    public ComputerTrainer(String name, ArrayList pokemon)
    {
        super(name, pokemon);
        //write the randomizer thing here
        //randomize pkmn and moves
    }
    

}

