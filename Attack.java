
/**
 * A Pokemon attack
 *
 * @author Linda Fernsel
 * @version 1
 */
public class Attack
{
    private String name;
    private int damage;
    private Type type;

    /**
     * Constructor for objects of class Attack
     */
    public Attack(String name, int damage, Type type)
    {
        this.name = name;
        this.damage = damage;
        this.type = type;
    }
    
    public int getDamage() {
        return this.damage;
    }
    
    public Type getType() {
        return this.type;
    }
}
