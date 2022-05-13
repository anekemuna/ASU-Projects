//***********************************************************
// Name: Munachimso Aneke
// Title: CardList.java
// Lab Section: H
// Description: CardList class for manipulating cards.
// Time Spent: 2hrs
// Date: 11/9/2021
//**********************************************************

/*
PART 1

a. public int[] swapEnds(int[] nums)
    {
        int temp = nums[0];
        nums[0] = nums[nums.length -1];
        nums[nums.length - 1] = temp;
        return nums;
    }

b.  public boolean commonEnd(int[] a, int[] b)
    {
      if(a[0] == b[0])
      {
        return true;
      }
      else if(a[a.length -1 ] == b[b.length -1])
      {
        return true;
      }
      else
      {
        return false;

      }
    }

c. public int countEvens(int[] nums)
    {
      int count = 0;

      for (int i = 0; i < nums.length; i++)
      {
        if (nums[i] % 2 == 0)
        {
          count++;
        }
      }

      return count;
    }

d. public int sum13(int[] nums)
    {
      int sum = 0;

      for(int i = 0; i < nums.length; i++)
      {
        if(nums[i] == 13)
        {
          i++;
        }
        else if (nums[i] != 13)
        {
        sum += nums[i];
        }

      }

      return sum;

    }

e. public int[] fix34(int[] nums)
    {
       for (int i = 0; i < nums.length; i++)
       {
        if (nums[i] == 3)
        {
          for (int j = 0; j < nums.length; j++)
          {
            if (nums[j] == 4)
            {
              if (j > 0 && nums[j-1] != 3) {
                int temp = nums[i+1];
                nums[i+1] = 4;
                nums[j] = temp;
              }
              else if (j == 0) {
                int temp = nums[i+1];
                nums[i+1] = 4;
                nums[j] = temp;
              }
            }
          }
        }
      }
      return nums;
    }

*/

import java.util.Arrays;

public class CardList
{
    // instance variables
    private char[] cards;
    private String history;

    // default constructor for the CardList transfer.
    public CardList (int numberOfCard)
    {
        String str = "A234567890JQK";
        cards = new char[numberOfCard];

        for (int i = 0; i < numberOfCard; i++)
        {
            int random = (int) (Math.random() * 13);
            cards[i] = str.charAt(random);
        }

        history = Arrays.toString(cards) + "\n";
    }

    // flip the cards array, (eg 1,2,3,4 -> 4,3,2,1)
    public void flip()
    {
        char[] card2 = new char[cards.length];
        for (int i = 0; i < cards.length; i++)
        {
            int j = cards.length - 1 - i;
            card2[j] = cards[i];
        }

        cards = card2;
        history += Arrays.toString(cards) + ": Flip\n";
    }

    // shift the position
    public void shift()
    {
        if(cards.length != 0)
        {
            char temp = cards[0];
            for (int i = 0; i < cards.length - 1; i++) {
                cards[i] = cards[i + 1];
            }
            cards[cards.length - 1] = temp;
        }
        history += Arrays.toString(cards) + ": Shift\n";
    }

    // Shuffles the cards based on the index from shuffleIndex()
    public  void shuffle ()
    {
        if(cards.length != 0)
        {
            int[] pos = shuffleIndex();
            char[] card2 = Arrays.copyOf(cards, cards.length);
            for (int i = 0; i < cards.length; i++) {
                cards[i] = card2[pos[i]];
            }
        }
        history += Arrays.toString(cards) + ": Shuffle\n";
    }

    // Changes the first num cards
    public void change(int num)
    {
        if(num > 0 && num < cards.length)
        {
            String str = "A234567890JQK";

            for (int i = 0; i < num; i++)
            {
                int random = (int) (Math.random() * 13);
                cards[i] = str.charAt(random);
            }

            history += Arrays.toString(cards) + ": Change\n";
        }

    }

    // produces an array of shuffled indexes
    private int [] shuffleIndex()
    {
        // initialize the output
        int [] output = new int[cards.length];

        for (int i = 0; i < cards.length; i++)
        {
            output[i] = i;
        }

        while (true)
        {
            boolean flag = false;
            for (int i = 0; i < output.length; i++)
            {
                if(output[i] == i)
                {
                    flag = true;
                    int r = (int) (Math.random() * output.length);

                    int temp = output[i];
                    output[i] = output[r];
                    output[r] = temp;

                    break;
                }

            }

            if(flag == false) {
                break;
            }

        }
        return output;
    }

    // Return the history
    public String getHistory()
    {
        return history;
    }



}
