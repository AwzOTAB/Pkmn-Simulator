import java.util.*;
public class PokemonSimulation extends ConsoleProgram
{
    private PokemonImages images = new PokemonImages();
    
    public void run()
    {
        System.out.println("Welcome to the Pokemon Simulator!\n");
        System.out.println("Player 1");
        System.out.println("=================");
        
        ArrayList<Pokemon> arrPKMN = new ArrayList<Pokemon>();
        PokemonTrainer p1 = new PokemonTrainer("", arrPKMN);
        choosePKMN(p1);

        System.out.println("\n\nPlayer 2");
        System.out.println("=================");
            
        ArrayList<Pokemon> arrPKMN2 = new ArrayList<Pokemon>();
        PokemonTrainer p2 = new PokemonTrainer("", arrPKMN2);
        choosePKMN(p2);
            
        battle(p1, p2);
        
        conclusion();
    }
    
    public void choosePKMN(PokemonTrainer trainer)
    {
        System.out.println("Setting up Pokemon Trainer:");
        
        String x = readLine("Trainer, what is your name? ");
        System.out.println("Hello " + x + "!");
        trainer.setName(x);

        for(int i = 0; i < 2; i++)
        {
            if(i == 0)
            {
                System.out.println("\nChoose your first pokemon");
            }
            else
            {
                System.out.println("\nChoose your second pokemon");
            }
            String y = readLine("Enter the name of your pokemon: ");
            
            int z = readInt("How much HP does " + y + " have? ");
            System.out.println("You chose: ");
            
            ArrayList<Move> arr = new ArrayList<Move>();
            Pokemon pkmn = new Pokemon(y, z, arr);
            System.out.println(pkmn);
        
            chooseMove(pkmn.getName(), pkmn, trainer);
        }
    }
    
    public void chooseMove(String name, Pokemon pkmn, PokemonTrainer trainer)
    {
        for(int i = 0; i > -1; i++)
        {
            String x = readLine("\nWould you like to teach " + name + " a new move? ");
            if(x.equals("yes"))
            {
                if(pkmn.canLearnMoreMoves() == true)
                {
                    String y = readLine("Enter the name of the move: ");
                    int z = readInt("How much damage does this move do? ");
                    
                    Move move = new Move(z, y);
                    System.out.println(name + " learned " + move + "!");
                    
                    pkmn.addMove(move);
                    trainer.addPokemon(pkmn);
                }
                else
                {
                    System.out.println(name + " already learned 4 moves");
                    break;
                }
            }
            else if(x.equals("no"))
            {
                System.out.println(name + " has learned all of its moves");
                break;
            }
            else
            {
                System.out.println("Invalid input");
            }
        }
    }
    
    public void battle(PokemonTrainer p1, PokemonTrainer p2)
    {
        System.out.println("\n\n\n" + p1 + " Challenges " + p2 + "!!");
        pressA();
        System.out.println(p1 + " sent out \n");
        System.out.println(p1.getNextPokemon());
        pressA();
        System.out.println(p2 + " sent out \n");
        System.out.println(p2.getNextPokemon());
        for(int i = 0; i < (p1.getPKMNList()).size(); i++)
        {
            if(p1.getNextPokemon() == null)
            {
                System.out.println("\n" + p2 + " has defeated " + p1 + "!!!");
                break;
            }
            else if(p2.getNextPokemon() == null)
            {
                System.out.println("\n" + p1 + " has defeated " + p2 + "!!!");
                break;
            }
            else
            {
                turns(p1.getNextPokemon(), p2.getNextPokemon(), p1, p2);
            }
        }
    }
    
    public void pressA()
    {
        String x = readLine("Press A to Countinue ");
        if(x.equals("a")||x.equals("A"))
        {
            System.out.println("");
        }
    }
    
    public void turns(Pokemon x, Pokemon y, PokemonTrainer p1, PokemonTrainer p2)
    {
        for(int i = 0; i > -1; i++)
        {
            if(randomize() == 0)
            {
                p1Turn(x, y);
                if(y.hasFainted() == true)
                {
                    System.out.println(y + " has fainted!");
                    pressA();
                    if(p2.getNextPokemon() != null)
                    {
                        System.out.println("\n" + p2 + " sent out \n" + p2.getNextPokemon() + "!!");
                    }
                    break;
                }
                p2Turn(x, y);
                if(x.hasFainted() == true)
                {
                    System.out.println(x + " has fainted!");
                    pressA();
                    if(p1.getNextPokemon() != null)
                    {
                        System.out.println("\n" + p1 + " sent out \n" + p1.getNextPokemon() + "!!");
                    }
                    break;
                }
            }
            else
            {
                p2Turn(x, y);
                if(x.hasFainted() == true)
                {
                    System.out.println(x + " has fainted!");
                    System.out.println("\n" + p1 + " sent out " + p1.getNextPokemon() + "!!");
                    break;
                }
                p1Turn(x, y);
                if(y.hasFainted() == true)
                {
                    System.out.println(y + " has fainted!");
                    System.out.println("\n" + p2 + " sent out " + p2.getNextPokemon() + "!!");
                    break;
                }
            }
        }
    }
    
    public void p1Turn(Pokemon x, Pokemon y)
    {
        System.out.println("\n" + x.getName() + " vs. " + y.getName());
        System.out.println("What will " + x.getName() + " do? ");
        System.out.println("Be sure to keep the following information private");
        pressA();
        System.out.println(x.getName() + "'s move set: " + x.getMoves());
        int a = readInt("\nChoose move (enter 1 for the first move, 2 for the second etc.) ");
        Move a1 = (x.getMoves()).get(a - 1);
        boolean b = x.attack(y, a1);
        if(b == true)
        {
            System.out.println("\n" + x.getName() + " used " + a1 + "!!");
            System.out.println(y.getName() + " 's health: "  + y.getHealth() + "/" + y.getFullHealth() + "\n");
        }
    }
    
    public void p2Turn(Pokemon x, Pokemon y)
    {
        System.out.println("\n" + x.getName() + " vs. " + y.getName());
        System.out.println("What will " + y.getName() + " do? ");
        System.out.println("Be sure to keep the following information private");
        pressA();
        System.out.println(y.getName() + "'s move set: " + y.getMoves());
        int a = readInt("\nChoose move (enter 1 for the first move, 2 for the second etc.) ");
        Move a1 = (y.getMoves()).get(a - 1);
        boolean b = y.attack(x, a1);
        if(b == true)
        {
            System.out.println("\n" + y.getName() + " used " + a1 + "!!");
            System.out.println(x.getName() + " 's health: " + x.getHealth() + "/" + x.getFullHealth() + "\n");
        }
    }
    
    public int randomize()
    {
        //incomplete randomize
        return 0;
    }
    
    public void conclusion()
    {
        System.out.println("\nThanks for playing!");
    }
}

