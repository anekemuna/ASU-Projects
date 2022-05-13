//******************************************************
// Name:         Munachimso Aneke
// Title:        Dungeon.java
// Description:  The Dungeon class for  Assignment 8.
//               Allows manipulation of the board and Monster objects
// Date:         11/27/2021
//********************************************************

/*

PART 1

a.) Rect x y Width Height Rect x y Width Height
b.) 0 0 10 20 100 5 125 2 20 7 10 0
c.) 0 0 1 0 2 0 1 0 0 5 1 2 5 2 2 0 7 1 0 0
d.) Rect x       y       Width      Height
    Rect x    .  y    .  Width   .  Height   .
e.) in.useDelimiter("[^0-9.]+");


*/

public class Dungeon
{
    private Monster[][] monsters;
    static int gridWidth;
    static int gridHeight;

    public Dungeon(int width, int height)
    {
        monsters = new Monster[height][width];

        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                monsters[i][j] = new Monster();
            }
        }
        gridWidth = width;
        gridHeight = height;
    }

    public void updateMonster(int x , int y, Monster m)
    {
        if(x <= gridWidth-1 && y <= gridHeight-1)
        {
            Monster emp = new Monster();
            if(monsters[y][x].equals(emp))
            {
                //monsters[y][x].setName(m.getName());
                //monsters[y][x].setLevel(m.getLevel());
                monsters[y][x] = m;
            }
        }
    }

    private void swap(int x1, int y1, int x2, int y2)
    {
        Monster temp = monsters[y1][x1];
        monsters[y1][x1] = monsters[y2][x2];
        monsters[y2][x2] = temp;
    }

    public void shuffle()
    {
        for(int i = 0; i < gridHeight; i++)
        {
            for (int j = 0; j < gridWidth; j++)
            {
                int m = (int) (Math.random() * gridHeight);
                int n = (int) (Math.random() * gridWidth);
                swap(i,j,m,n);
            }
        }
    }

    public void shift(char command)
    {
        Monster[][] temp =  new Monster[gridHeight][gridWidth];

        // a (left)
        if(command == 'a')
        {
            // copy first columns
            for(int i = 0; i < gridHeight; i++)
            {
                temp[i][0] = monsters[i][0];
            }

            // shift other columns to the left
            for(int i = 0; i < gridHeight; i++)
            {
                for (int j = 0; j < gridWidth-1; j++)
                {
                    monsters[i][j] = monsters[i][j+1];
                }
            }

            // copy temp at the end
            for(int i = 0; i < gridHeight; i++)
            {
                monsters[i][gridWidth-1] = temp[i][0];
            }
        }
        else if (command == 'd') // d(right)
        {
            // copy last columns
            for(int i = 0; i < gridHeight; i++)
            {
                temp[i][gridWidth-1] = monsters[i][gridWidth-1];
            }

            // shift other columns to the right
            for(int i = 0; i < gridHeight; i++)
            {
                for (int j = 0; j < gridWidth-1; j++)
                {
                    monsters[i][gridWidth-1-j] = monsters[i][gridWidth-2-j];
                }
            }

            // copy temp at the first
            for(int i = 0; i < gridHeight; i++)
            {
                monsters[i][0] = temp[i][gridWidth-1];
            }
        }
        else if (command == 'w') // w(up)
        {
            // copy first row
            for(int i = 0; i < gridWidth; i++)
            {
                temp[0][i] = monsters[0][i];
            }

            // shift other rows to upward
            for(int i = 0; i < gridHeight-1; i++)
            {
                for (int j = 0; j < gridWidth; j++)
                {
                    monsters[i][j] = monsters[i+1][j];
                }
            }

            // copy temp at the bottom
            for(int i = 0; i < gridWidth; i++)
            {
                monsters[gridHeight-1][i] = temp[0][i];
            }
        }
        else if (command == 's') // s(down)
        {
            // copy last row
            for(int i = 0; i < gridWidth; i++)
            {
                temp[gridHeight-1][i] = monsters[gridHeight-1][i];
            }

            // shift other rows to downward
            for(int i = 0; i < gridHeight-1; i++)
            {
                for (int j = 0; j < gridWidth; j++)
                {
                    monsters[gridHeight-1-i][j] = monsters[gridHeight-2-i][j];
                }
            }

            // copy temp at top
            for(int i = 0; i < gridWidth; i++)
            {
                monsters[0][i] = temp[gridHeight-1][i];
            }
        }
    }

    public String printInfo()
    {
        String result = "\n\t";

        for(int i = 0; i < gridHeight; i++)
        {
            for(int j = 0; j < gridWidth; j++)
            {
                result += monsters[i][j].getInfo();
                result += "\t\t";
            }
            result += "\n\t";
        }

        return result;
    }
}

