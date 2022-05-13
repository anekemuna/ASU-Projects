// Assignment #:  8
//         Name:  Munachimso Aneke
//   Student ID:  1215028815
//      Lecture:  TTh 9:00am (CSE 205)
//  Description:  Compares restaurant objects based on the ratings

import java.util.Comparator;

public class ReviewRatingComparator implements Comparator<Restaurant>
{
    @Override
    public int compare(Restaurant o1, Restaurant o2)
    {
        if(o1.getStars() == o2.getStars()) // if number of stars are equal, compare restaurant name
        {
            if(o1.getRestaurantName().compareToIgnoreCase(o2.getRestaurantName()) == 0) // if name is the same, compare, location
            {
                if(o1.getLocation().compareToIgnoreCase(o2.getLocation()) == 0)  // if location is the same, compare review
                {
                    if(o1.getReview().compareToIgnoreCase(o2.getReview()) == 0) // if the review is the same, return 0
                    {
                        return 0;
                    }
                    else if(o1.getReview().compareToIgnoreCase(o2.getReview()) < 0)
                    {
                        return -1;
                    }
                    else
                    {
                        return 1;
                    }
                }
                else if(o1.getLocation().compareToIgnoreCase(o2.getLocation()) < 0)
                {
                    return -1;
                }
                else
                {
                    return 1;
                }
            }
            else if(o1.getRestaurantName().compareToIgnoreCase(o2.getRestaurantName()) < 0)
            {
                return -1;
            }
            else
            {
                return 1;
            }
        }
        else // if num of stars are different, return the difference between the stars
        {
            return o1.getStars()-o2.getStars();
        }
    }
}
