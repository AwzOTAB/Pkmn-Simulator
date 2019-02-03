import java.util.*;
public class PokemonTrainer
{
    // private constants
    private static final int MAX_POKEMON = 2;
    private String name;
    private ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();
    
    public PokemonTrainer(String name, ArrayList<Pokemon> pokemon)
    {
        this.name = name;
        this.pokemon = pokemon;
    }
    
    public boolean addPokemon(Pokemon p)
    {
        pokemon.add(p);
        if(pokemon.size() > MAX_POKEMON)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public boolean hasLost()
    {
        boolean b = true;
        for(int i = 0; i < pokemon.size(); i++)
        {
            if((pokemon.get(i)).hasFainted() == true)
            {
                b = b;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
    
    public Pokemon getNextPokemon()
    {
        for(int i = 0; i < pokemon.size(); i++)
        {
            if((pokemon.get(i)).hasFainted() == true)
            {
                continue;
            }
            else
            {
                return pokemon.get(i);
            }
        }
        return null;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public Pokemon getPKMN(int x)
    {
        return pokemon.get(x);
    }
    
    public ArrayList<Pokemon> getPKMNList()
    {
        return pokemon;
    }
    
    public String toString()
    {
        return name;
    }
}
