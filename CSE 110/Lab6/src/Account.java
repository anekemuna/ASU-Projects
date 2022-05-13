//---------------------------------------------------------------------------------------
// AUTHOR: Munachimso Aneke
// FILENAME: Account.java
// SPECIFICATION: This is a the Account class file for Lab 6
// LAB LETTER: H
// DATE: 10/1/2021
// START TIME: 12:20pm
// END TIME:   1:10pm
//-----------------------------------------------------------------------------------------

public class Account {
    private String name;
    private String accountNumber;
    private double balance;

    Account(String username, String accountNum, double curbalance)
    {
        name = username;
        accountNumber = accountNum;
        balance = curbalance;
    }

    //toString method
    public String toString()
    {
        return  String.format("Name is \t: %s\nAccount Number is \t\t: %s\nBalance is \t\t: $%.2f", name,
                                accountNumber, balance);
    }

    //setName method
    public void setName(String newName)
    {
        name = newName;
    }

    //toCredit method
    public void toCredit(Double depositAmount)
    {
        balance = balance + depositAmount;
    }

    public void toDebit(Double depositAmount)
    {
        balance = balance - depositAmount;
    }

}
