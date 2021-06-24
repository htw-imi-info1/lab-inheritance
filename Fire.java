import java.util.ArrayList;
import java.util.HashMap;

/**
 * Fire is a category of Pokemon
 *
 * @author Linda Fernsel
 * @version 1
 */
public class Fire extends Pokemon
{
    private ArrayList<Type> vulnerableAgainst;
    
    /**
     * Constructor for objects of class Fire
     */
    public Fire()
    {
        this.vulnerableAgainst = new ArrayList();
        this.vulnerableAgainst.add(Type.WATER);
        
        // add fire attacks
        Type ownType = Type.FIRE;
        this.attacks = new HashMap();
        this.attacks.put(4, new Attack("Ember", 40, ownType));
        this.attacks.put(17, new Attack("Fire Fang", 65, ownType));
        this.attacks.put(24, new Attack("Flamethrower", 90, ownType));
    }
    
    public void attackWith(Attack attack) {
        super.attackWith(attack);
        if(this.vulnerableAgainst.contains(attack.getType())) this.currentHealthPoints -= (attack.getDamage() / 2);
    }
    
    public boolean isVulnerableAgainst(Type type) {
        return this.vulnerableAgainst.contains(type);
    }
}
