// Assignment #: 5
//         Name: Munachimso Aneke
//    StudentID: 1215028815
//      Lecture: TTh 9:00am (CSE 205)
//  Description: Abstract class containing the basic attributes for any player


public abstract class PlayerEntity
{
    protected double health;       // health of player
    protected String entityName;   // name of player
    protected int stamina;         // strength of player
    protected int attack;          // attack damage of player
    protected int combatPoints;    // combat points

    // Constructor
    public PlayerEntity (double health, String name, int stamina, int attack)
    {
        // Initialize instance variables
        this.health = health;
        this.entityName = name;
        this.stamina = stamina;
        this.attack = attack;
        this.combatPoints = 0;
    }

    //  getCombatPoints(): returns combatPoints
    public int getCombatPoints()
    {
        return combatPoints;
    }

    // computeCombatPower(): calculates combat power
    public abstract void computeCombatPower();

    // toString(): returns a string of the values
    public String toString()
    {
        return String.format("Hero name:\t\t%s" +
                "\nCurrent Health:\t\t%.1f" +
                "\nStamina:\t\t%d" +
                "\nAttack Damage:\t\t%d" +
                "\nCurrent Combat Points:\t%d\n", entityName, health, stamina, attack, combatPoints);
    }
}
