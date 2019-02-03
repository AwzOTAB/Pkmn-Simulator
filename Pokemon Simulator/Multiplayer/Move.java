public class Move
{
    private int damage;
    private String name;
    
    // Private constants
    private static final int MAX_DAMAGE = 250;
    
    public Move(int d, String n)
    {
        if(d > MAX_DAMAGE)
        {
            damage = MAX_DAMAGE;
        }
        else
        {
            damage = d;
        }
        name = n;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getDamage()
    {
        return damage;
    }
    
    public boolean equals(Move other)
    {
        if((other.name).equals(name))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void setDamage(int x)
    {
        damage = x;
    }
    
    public String toString()
    {
        return name + " (" + damage + " damage)"; 
    }
}


