/*---------------------------------------------------------------------------
// AUTHOR:      Munachimso Aneke
// FILENAME:    PhoneBook.java
// SPECIFICATION:  PhoneBook class for Lab12.java
// LAB LETTER: H
//-------------------------------------------------------------------------*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
    private String filePath = "";
    private List<People> infoList = new ArrayList<People>();

    public PhoneBook(String path) {
        filePath = path;
    }

    public void add(String name, String number)
    {
        People p = new People(name,number);
        infoList.add(p);
    }

    public void delete(String name)
    {
        for(People p: infoList)
        {
            if (p.getName().equals(name))
            {
                infoList.remove(p);
                break;
            }
        }
    }

    public void save() {
        try {
            FileWriter writer = new FileWriter(filePath);
            //Stuff here
            for(People p: infoList)
            {
                writer.write(p.toString() + "\n");
            }

            writer.close();
            System.out.println("Save Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void read()
    {
        try {
            File file = new File(filePath);
            Scanner in = new Scanner(file);
            //Stuff here
            while (in.hasNext())
            {
                String info = in.nextLine();
                String [] splits = info.split("\t");
                People p = new People(splits[0], splits[1]);
                infoList.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show()
    {
        System.out.println("name" + "\t" + "number");
        for(People p: infoList)
        {
            System.out.println(p.toString());
        }
    }
}
