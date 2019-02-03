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
        
        ArrayList<Pokemon> cpuPKMN = new ArrayList<Pokemon>();
        ComputerTrainer ash = new ComputerTrainer("Ash", cpuPKMN);
            
        battle(p1, ash);
        
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
    
    public void battle(PokemonTrainer p1, ComputerTrainer ash)
    {
        System.out.println("\n\n\n" + p1 + " Challenges Ash!!");
        pressA();
        System.out.println(p1 + " sent out \n");
        System.out.println(p1.getNextPokemon());
        pressA();
        System.out.println("Ash sent out \n");
        System.out.println(ash.getNextPokemon());
        for(int i = 0; i < (p1.getPKMNList()).size(); i++)
        {
            if(p1.getNextPokemon() == null)
            {
                System.out.println("\nAsh has defeated " + p1 + "!!!");
                System.out.println(p1 + " rushed to the nearest Pokemon Center...");
                System.out.println("......");
                System.out.println(p1 + " blacked out!!");
                break;
            }
            else if(ash.getNextPokemon() == null)
            {
                System.out.println("\n" + p1 + " has defeated Ash!!!");
                System.out.println("Ash: sugoyidesu!!");
                System.out.println(p1 + " got $10,000 for winning!");
                break;
            }
            else
            {
                turns(p1.getNextPokemon(), ash.getNextPokemon(), p1, ash);
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
    
    public void turns(Pokemon x, Pokemon y, PokemonTrainer p1, ComputerTrainer ash)
    {
        for(int i = 0; i > -1; i++)
        {
            int rand = Randomizer.nextInt(0, 1);
            if(rand == 1)
            {
                p1Turn(x, y);
                if(y.hasFainted() == true)
                {
                    System.out.println(y + " has fainted!");
                    pressA();
                    if(ash.getNextPokemon() != null)
                    {
                        System.out.println("\nAsh sent out \n" + ash.getNextPokemon() + "!!");
                    }
                    break;
                }
                ashTurn(x, y);
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
                ashTurn(x, y);
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
                    System.out.println("\n" + ash + " sent out " + ash.getNextPokemon() + "!!");
                    break;
                }
            }
        }
    }
    
    public void p1Turn(Pokemon x, Pokemon y)
    {
        System.out.println("\n" + x.getName() + " vs. " + y.getName());
        System.out.println("What will " + x.getName() + " do? ");
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
    
    public void ashTurn(Pokemon x, Pokemon y)
    {
        System.out.println("\n" + x.getName() + " vs. " + y.getName());
        pressA();
        int a = Randomizer.nextInt(0, //length of move arr - 1);
        
        Move a1 = (y.getMoves()).get(a);
        boolean b = y.attack(x, a1);
        if(b == true)
        {
            System.out.println("\n" + y.getName() + " used " + a1 + "!!");
            System.out.println(x.getName() + " 's health: " + x.getHealth() + "/" + x.getFullHealth() + "\n");
        }
    }
    
    public void conclusion()
    {
        System.out.println("\n\nThanks for playing!");
    }
}
