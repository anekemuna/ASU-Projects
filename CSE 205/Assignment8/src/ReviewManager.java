// Assignment #:  8
//         Name:  Munachimso Aneke
//   Student ID:  1215028815
//      Lecture:  TTh 9:00am (CSE 205)
//  Description:  Manages a set Restaurant objects

import java.io.Serializable;
import java.util.ArrayList;

public class ReviewManager implements Serializable {
    // The serialVersionUID is used to verify compatibility of senders and
    // receivers. See the document for more details:
    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
    private static final long serialVersionUID = 205L;

    ArrayList<Restaurant> reviewList;

    public ReviewManager()
    {
        reviewList = new ArrayList<>();
    }

    // restaurantExist(): returns the index of a specific restaurant
    public int restaurantExists(String name, String location)
    {
        for(int i = 0; i < reviewList.size(); i++) // loop through array list
        {
            if(reviewList.get(i).getRestaurantName().equals(name) && reviewList.get(i).getLocation().equals(location))
            {
                return i; // returns the index if found
            }
        }
        return -1; // returns -1 if not found
    }

    // cuisineExists(): returns and ArrayList of integers containing the index of restaurant objects with the same cuisine type
    public ArrayList<Integer> cuisineExists(String type)
    {
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < reviewList.size(); i++) // loop through array list
        {
            if(reviewList.get(i).getCuisine().getName().equals(type)) // if an object has the same name cuisine name
            {
                result.add(i); // add index of Restaurant object
            }
        }

        return result;
    }

    // getRestaurant(): returns a restaurant object at an index
    public Restaurant getRestaurant(int index)
    {
        return reviewList.get(index);
    }

    /**
     * Add a Restaurant object to the reviewList and return true if such an object
     * is added successfully. Otherwise, return false. Two restaurants are
     * considered duplicated if they have exactly the same restaurant name and
     * cuisine name.
     * 
     * @param  restaurantName the name of the restaurant
     * @param  stars the number of stars for the restaurant
     * @param  review   the restaurant review
     * @param  priceRange    the integer price range
     * @param  cuisineName  the Cuisine's name
     * @param  location   the restaurant location (street address)
     * @param  signatureDish  most famous dish
     * @return            true if the operation is successful; false otherwise
     */
    public boolean addReview(String restaurantName, int stars, String review, String priceRange, String cuisineName, String location, String signatureDish) {
        if (restaurantExists(restaurantName, location) == -1) {
            int price = priceRange.length();
            Cuisine newCuisine = new Cuisine(signatureDish, cuisineName);
            Restaurant newRestaurant = new Restaurant(restaurantName, stars, review, price, location, newCuisine);
            reviewList.add(newRestaurant);
            return true;
        }
        return false;
    }

    public boolean removeReview(String name, String location)
    {
        int i = restaurantExists(name, location); // = -1, if not found
        
        if(i != -1) // if restaurant exists
        {
            reviewList.remove(i); // remove restaurant
            return true;
        }
        return false;
    }

    // sortByRating(): sorts reviewList by ratings
    public void sortByRating()
    {
        Sorts.sort(reviewList, new ReviewRatingComparator());
    }

    // sortByCuisine(): sorts reviewList by cuisine
    public void sortByCuisine()
    {
        Sorts.sort(reviewList, new ReviewCuisineComparator());
    }

    // listReviews(): returns a string of all the reviews in the list
    public String listReviews()
    {
        String result = "";

        if(!reviewList.isEmpty())
        {
            for (int i = 0; i < reviewList.size(); i++) {
                result += getRestaurant(i).toString();
            }
        }
        else
        {
            result +="\n\nNo Reviews available";
        }
        return result;
    }

    // closeReviewManager(): empties list
    public void closeReviewManager()
    {
        reviewList.clear(); // clear list
    }

}
