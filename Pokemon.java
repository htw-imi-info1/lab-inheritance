import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Abstract class Pokemon - It can not be instatiated directly, but specific Pokemon categories can inherit from it
 *
 * @author Linda Fernsel
 * @version 1
 */
public abstract class Pokemon
{
    protected HashMap<Integer, Attack> attacks;
    protected int currentLevel;
    protected int maxHealthPoints;
    protected int currentHealthPoints;

    public ArrayList<Attack> getAttacksAvailableAtCurrentLevel()
    {
        return attacks
        .entrySet()
        .stream()
        .filter(entry -> entry.getKey() <= currentLevel)
        .map(entry -> entry.getValue())
        .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public void levelUp() {
        this.currentLevel++;
        this.maxHealthPoints += this.currentLevel;
        this.currentHealthPoints += this.currentLevel;
        if (this.currentHealthPoints > this.maxHealthPoints) this.currentHealthPoints = this.maxHealthPoints;
    }
    
    public int getLevel() {
        return this.currentLevel;
    }
    
    public void attackWith(Attack attack) {
        this.currentHealthPoints -= attack.getDamage();
    }
    
    /* You would obviousely need more fields and methods for the real deal */ 
}
