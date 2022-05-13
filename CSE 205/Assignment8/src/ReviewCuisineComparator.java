import java.util.Comparator;

// Assignment #:  8
//         Name:  Munachimso Aneke
//   Student ID:  1215028815
//      Lecture:  TTh 9:00am (CSE 205)
//  Description:  Compares restaurant object based on the price range of a particular cuisine
public class ReviewCuisineComparator implements Comparator<Restaurant>
{
    @Override
    public int compare(Restaurant o1, Restaurant o2)
    {
        if(o1.getCuisine().getName().compareToIgnoreCase(o2.getCuisine().getName()) == 0) // if cuisine the same, compare price range
        {
            if(o1.getPriceRange() == o2.getPriceRange())  // if price range is equal, compare name
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
            else
            {
                return o1.getPriceRange() - o2.getPriceRange();
            }
        }
        else if(o1.getCuisine().getName().compareToIgnoreCase(o2.getCuisine().getName()) < 0)
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }
}
