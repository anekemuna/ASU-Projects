//***********************************************************
// Name: Munachimso Aneke
// Title: FiveCards.java
// Description: FiveCards class
// Date: 10/4/2021
// **********************************************************

public class FiveCards
{
    private String cards;
    private int score;
    private int changes;
    private String history;

    // default constructor
    public FiveCards()
    {
        cards = "";
        score = 0;
        changes = 0;
        history = "";
    }

    //setCards method
    public void setCards(String str)
    {
        cards = str;
        changes++;
    }

    //changeOne method
    public void changeOne(int pos)
    {
        //Replace one character of the given position [0,4]with a random letter from "1234567890JQK".
        String randString = "1234567890JQK";
        int i = (int)(Math.random() * 13 ); // randomize the index (0-12)
        //System.out.println("Random index no is " + i); //test

       // cards.charAt(pos) = randString.charAt(i);
        // test what happens when pos is 0 / pos is 4
        cards = cards.substring(0,pos) + randString.charAt(i) + cards.substring(pos+1);

        changes++;
    }

    //calculateScore method
   public void calculateScore()
    {
        String str = "1234567890JQK";
        int countPair = 0, countThrees = 0, countFour = 0;
        for(int i = 0; i < 13; i++) // for loop to iterate through each char
        {
            char c = str.charAt(i);
            int noPair = calculatePair(c);  // returns # of occurrences of a character

            if(noPair == 2)
            {
                countPair++; // if only 2 occurrences
            }
            else if( noPair == 3)
            {
                countThrees++; // if only 3 occurrences
            }
            else if(noPair == 4)
            {
                countFour++;   // if 4 occurrences
            }
        }

        if(countPair == 1 & countThrees == 0)
        {
            score = 1;
        }
        else if(countPair == 2 & countThrees == 0)
        {
            score = 2;
        }
        else if(countPair == 0 & countThrees == 1)
        {
            score = 3;
        }
        else if(countPair == 1 & countThrees == 1)
        {
            score = 4;
        }
        else if (countFour == 1)
        {
            score = 2;
        }
        else
        {
            score = 0;
        }
    }

    private int calculatePair(char c)
    {
        int pair = 0;

        for(int i = 0; i < cards.length(); i++ )
        {
            if(cards.charAt(i) == c)
            {
                pair++;
            }
        }
        return pair;
    }

    public String displayData()
    {
        if(history.equals(""))
        {
            history = "[Cards] [Score] [Changes]\n";
        }

        calculateScore();
        history += cards + "\t\t" + score + "\t\t" +changes + "\n";
        return history;
    }

  /*  public void calculateScore()
    {
        String cardSet = "1234567890JQK";
        int count = 0;

        for(int i = 0; i < 13; i++) // for loop to iterate through each char
        {
            char c = cardSet.charAt(i);
            int pair = calculatePair(c);  // returns # of occurrences of a character

            if(pair == 2)
            {
                count++;
            }
            else if( pair == 3)
            {
                count += 3;
            }
            else if(pair == 4)
            {
                count +=2;
            }

        }

        score = count;
    }*/
}

// Questions
// 1. Should the setCards update Changes
// 2. Check if the last 4 methods are correct
// 3. Output formatting
// 4. What happens if there four/ five of one letter
// 5. Is there any check for inputting wrong data value, i.e cards string, pos
// 6. Why use lineBreak in command B