

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CharmanderTest.
 *
 * @author  Linda Fernsel
 * @version 1
 */
public class CharmanderTest
{
    /**
     * Default constructor for test class CharmanderTest
     */
    public CharmanderTest()
    {
    }

    private Charmander charmander;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        this.charmander = new Charmander();
    }

    @Test
    public void initializes() {
        assertEquals(1, this.charmander.currentLevel);
        assertEquals(11, this.charmander.maxHealthPoints);
        assertEquals(11, this.charmander.currentHealthPoints);
        assertEquals(true, this.charmander.isVulnerableAgainst(Type.WATER));
    }
    
    @Test
    public void levelsUp() {
        int previousLevel = this.charmander.getLevel();
        this.charmander.levelUp();
        assertEquals(previousLevel + 1, this.charmander.getLevel());
    }
    
    @Test
    public void canBeAttacked() {
        int previousHealthPoints = this.charmander.currentHealthPoints;
        this.charmander.attackWith(new Attack("Tackle", 40, Type.NORMAL));
        assertEquals(previousHealthPoints - 40, this.charmander.currentHealthPoints);
    }
    
    @Test
    public void canBeAttackedMoreGravelyIfVulnerable() {
        int previousHealthPoints = this.charmander.currentHealthPoints;
        this.charmander.attackWith(new Attack("Whirlpool", 35, Type.WATER));
        assertEquals(previousHealthPoints - (35 + 35/2), this.charmander.currentHealthPoints);
    }
}
