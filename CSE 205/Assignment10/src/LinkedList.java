// Assignment #:  10
//         Name:  Munachimso Aneke
//   Student ID:  1215028815
//      Lecture:  TTh 9:00am (CSE 205)
//  Description:  LinkedList class, contains the methods to manipulate a wait list

public class LinkedList
{
    Table first;
    int size;
    public LinkedList()
    {
        first = null;
        size = 0;
    }

    public void add(int numberOfGuests, String name)
    {
        Table newGuest = new Table(numberOfGuests, name);
        if(first == null){
            first = newGuest;
        }
        else{
            Table pointer = first;
            while(pointer.next != null)
                pointer = pointer.next;

            pointer.next = newGuest;
        }
        size++;
    }

    // removeFirst(): removes first reservation from wait list
    public Table removeFirst()
    {
        // if list is not empty
        if(first != null)
        {
            Table pointer = first;
            // decrease size
            size--;
            first = first.next; // remove 1st reservation from the list
            return pointer;
        }
        // return an empty table if empty
        return new Table.EmptyTable();
    }

    // removeLast(): removes the last reservation from the wait list
    public Table removeLast()
    {
        // if not list is not empty
        if(first != null)
        {
            Table pointer = first;

            // check
            while(pointer.next.next != null)
            {
                pointer = pointer.next; // update pointer
            }

            Table pointer2 = pointer.next; // store 2nd to the last pointer to null
            pointer.next = null; // equate 2nd to the last pointer to null

            size--; // decrease size

            return pointer2; // returns the removed pointer
        }
        // if empty
        return new Table.EmptyTable();
    }

    // removeMiddle(): removes a reservation from the middle of the wait list (only handles cases in the middle i.e 3 cases)
    public Table removeMiddle(String name)
    {
        // if list is empty
        if( first != null)
        {
            Table pointer = first;

            if(pointer.name.equals(name)) // if name is the first on the list
            {
                return removeFirst();
            }
            else
            {
                boolean check = false;
                while(pointer.next != null)
                {
                    if(pointer.next.name.equals(name)) // check if name exists in list
                    {
                        check = true;
                        break;
                    }
                    pointer = pointer.next; // update pointer
                }

                if(check) // if name exists
                {
                    size--; // decrease the size
                    Table pointer2 = pointer.next;
                    pointer.next = pointer2.next; // update list by linking to next pointer
                    return pointer2;
                }
            }
        }
        return new Table.EmptyTable();
    }

    public Table removeGuest(String name)
    {
        if(first != null)
        {
            return removeMiddle(name);
        }
        return new Table.EmptyTable();
    }

    // getPosition(): return the position of a guest
    public int getPosition(String name)
    {
        // if the wait list is not empty
        if(first != null)
        {
            int count = 0;
            Table pointer = first;

            if(pointer.name.equals(name))
            {
                return count;
            }

            // iterate through list
            while(pointer.next != null)
            {
                pointer = pointer.next;
                count += 1;
                if(pointer.name.equals(name))
                {
                    return count;
                }

            }
        }
        return -1;
    }

    // getNumberOfParties(): return the number of existing party size
    public int getNumberOfParties(int num)
    {
        // if the wait list is empty
        if(first != null)
        {
            int result = 0;
            Table pointer = first;

            if(num == pointer.guests)
            {
                result++;
            }

            // iterate through list
            while(pointer.next != null)
            {
                pointer = pointer.next;
                if(num == pointer.guests)
                {
                    result++;
                }

            }

            // return result
            return result;
        }
        return 0;

    }

    // listReservations(): prints out the wait list and total number of reservation
    public String listReservations()
    {
        // if list is not empty
        if(first != null)
        {
            String result = "";

            Table pointer = first;
            result += pointer.toString(); // add first table info

            // iterate through list
            while (pointer.next != null)
            {
                pointer = pointer.next; // update pointer
                result += pointer.toString(); // update string
            }

            result = result + "\nTotal reservations: " + size + ".\n";
            return result;
        }
        return "No reservations in queue at this time.\n";
    }

}
