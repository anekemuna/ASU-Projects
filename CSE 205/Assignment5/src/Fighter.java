// Assignment #: 5
//         Name: Munachimso Aneke
//    StudentID: 1215028815
//      Lecture: TTh 9:00am (CSE 205)
//  Description: Subclass of PlayerEntity, Fighter describes players who are fighters

import java.text.DecimalFormat;

public class Fighter extends PlayerEntity
{
    private double armor; // armor of the fighter
    private int maxAttack; // max damage
    private boolean isRanged; // if the fighter attacks from a distance

    // Constructor
    public Fighter(double health, String name, int stamina, int attack, boolean isRanged)
    {
        // calls parent constructor & initialize instance variable
        super(health, name, stamina, attack);
        this.isRanged = isRanged;

        if(isRanged) // isRanged == true
        {
            armor = 0.25;
            maxAttack = 125;
        }
        else
        {
            armor = 0.5;
            maxAttack = 100;
        }

    }

    // computeCombatPower():  calculates combat points for fighter

    public void computeCombatPower()
    {
        if(maxAttack <= attack)
        {
            combatPoints = (int) ((maxAttack + health) * (1-armor));
        }
        else
        {
            combatPoints = (int) ((attack + health) * (1-armor));
        }

    }

    // toString: returns the values as a string
    public String toString()
    {
        String pattern = "#%";
        DecimalFormat num = new DecimalFormat(pattern);
        String armor_percent = num.format(armor);

        String result;

        if(isRanged) // isRanged == true
        {
           result = "\nFighter Hero:\t\tRanged Type\n";
        }
        else
        {
            result = "\nFighter Hero:\t\tMelee Type\n";
        }
        return result + super.toString() + String.format("Armor:\t\t\t%s\n",armor_percent);
    }
}