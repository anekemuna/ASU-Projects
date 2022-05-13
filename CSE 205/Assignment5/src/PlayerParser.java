// Assignment #: 5
//         Name: Munachimso Aneke
//    StudentID: 1215028815
//      Lecture: TTh 9:00am (CSE 205)
//  Description: Creates a player object from a string

public class PlayerParser
{
    public static PlayerEntity parseNewPlayer(String lineToParse)
    {
        PlayerEntity result; // Declare object to be returned

        String [] stats = lineToParse.split("/"); // parse string

        // store parsed data
        double health = Double.parseDouble(stats[1]);
        String name = stats[2];
        int stamina = Integer.parseInt(stats[3]);
        int attack = Integer.parseInt(stats[4]);

        // Create object Mage or Fighter
        if (stats[0].equalsIgnoreCase("Mage"))
        {
            double mana = Double.parseDouble(stats[5]);
            result = new Mage(health, name, stamina, attack, mana);
        }
        else
        {
            boolean isRanged;
            isRanged = stats[5].equalsIgnoreCase("Range");
            result = new Fighter(health, name, stamina, attack, isRanged);
        }

        return result;
    }
}
