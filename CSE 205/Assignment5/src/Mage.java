// Assignment #: 5
//         Name: Munachimso Aneke
//    StudentID: 1215028815
//      Lecture: TTh 9:00am (CSE 205)
//  Description: Subclass of PlayerEntity, Mage describes players who cast spells

import java.text.DecimalFormat;

public class Mage extends PlayerEntity
{
    private double mana; // healing power

    // Constructor
    public Mage(double health, String name, int stamina, int attack, double mana)
    {
        // calls parent constructor & initialize mana
        super(health, name, stamina, attack);
        this.mana = mana;

    }

    // computeCombatPower(): calculates combat points for mage hero
    public void computeCombatPower()
    {
        combatPoints = (int) ((attack +health) * (1 + mana));
    }

    // toString(): returns values of class as string
    public String toString()
    {
        String pattern = "#%";
        DecimalFormat num = new DecimalFormat(pattern);
        String mana_percent = num.format(mana);
        return "\nMage Hero:\n" + super.toString() + String.format("Mana:\t\t\t%s\n",mana_percent);
    }
}
