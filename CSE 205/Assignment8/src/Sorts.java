// Assignment #:  8
//         Name:  Munachimso Aneke
//   Student ID:  1215028815
//      Lecture:  TTh 9:00am (CSE 205)
//  Description:  Used to sort restaurant objects based on different criteria using the selection sort algorithm

import java.util.ArrayList;
import java.util.Comparator;

public class Sorts
{
    public static void sort(ArrayList<Restaurant> reviewList, Comparator<Restaurant> xComparator)
    {
        // implemented using selection sort algorithm
        int min;

        for(int index = 0; index < reviewList.size()-1; index++)
        {
            min = index;

            for(int scan = index + 1; scan < reviewList.size(); scan++)
            {
                if(xComparator.compare(reviewList.get(scan),reviewList.get(min)) < 0)
                {
                    min = scan;
                }
            }
            swap(reviewList,min, index);
        }
    }

    public static void swap(ArrayList <Restaurant> reviewList, int i1, int i2) // used to swap to elements in arrayList
    {
        Restaurant obj = reviewList.get(i1);
        reviewList.set(i1,reviewList.get(i2));
        reviewList.set(i2,obj);

    }
}
