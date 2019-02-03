import java.util.*;
public class Pokemon
{
    private String name;
    private int health;
    private int fullHealth;
    private ArrayList<Move> moves;
    private String image;
    private static final int MAX_HEALTH = 300;
    private static final int MAX_MOVES = 4;
    private PokemonImages images = new PokemonImages();


    // Write your Pokemon class here
    public Pokemon(String name, int fullHealth, ArrayList<Move> moves)
    {
        this.name = name;
        this.moves = moves;
        
        if(fullHealth > MAX_HEALTH)
        {
            this.fullHealth = MAX_HEALTH;
            health = this.fullHealth;
        }
        else 
        {
            this.fullHealth = fullHealth;
            health = fullHealth;
        }
    }
    
    public Pokemon(String name, String image)
    {
        this.name = name;
        this.image = image;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public int getFullHealth()
    {
        return fullHealth;
    }
    
    public boolean hasFainted()
    {
        if(health <= 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean canLearnMoreMoves()
    {
        if(moves.size() < 4)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean learnMove(Move move)
    {
        if(moves.size() < 4)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void forgetMove(Move move)
    {
        for(int i = 0; i < moves.size(); i++)
        {
            if((moves.get(i)).equals(move))
            {
                moves.remove(i);
            }
        }
    }
    
    public void setImage(String image)
    {
        this.image = image;
    }
    
    public String getImage()
    {
        return image;
    }
    
    public ArrayList<Move> getMoves()
    {
        return moves;
    }
    
    public boolean knowsMove(Move move)
    {
        if(moves.indexOf(move) < 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public boolean attack(Pokemon opponent, Move move)
    {
        if(knowsMove(move) == true)
        {
            if(opponent.health - move.getDamage() >= 0)
            {
                opponent.health -= move.getDamage();
            }
            else
            {
                opponent.health = 0;
            }
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void addMove(Move move)
    {
        moves.add(move);
    }
    
    public String toString()
    {
        return images.getPokemonImage(name) + "\n" + name + " (Health: " + health + "/" + fullHealth + ")"; 
    }
    
}
