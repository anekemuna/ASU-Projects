// Assignment #:  8
//         Name:  Munachimso Aneke
//   Student ID:  1215028815
//      Lecture:  TTh 9:00am (CSE 205)
//  Description:  Describes the attributes of a restaurant like name, location, cuisine, review...

import java.io.Serializable;

public class Restaurant implements Serializable
{
    // Data Attributes
    private static final long serialVersionUID = 205L;
    private String restaurantName;
    private int stars;
    private String review;
    private int priceRange;
    private String location;
    private Cuisine cuisine;

    // Constructor- Creates a restaurant object
    public Restaurant(String name, int stars, String review, int price, String location, Cuisine cuisine)
    {
        this.restaurantName = name;
        this.stars = stars;
        this.review = review;
        this.priceRange = price;
        this.location = location;
        this.cuisine = cuisine;
    }

    // Getter methods
    public String getRestaurantName()
    {
        return this.restaurantName;
    }

    public int getStars()
    {
        return stars;
    }

    public String getReview()
    {
        return review;
    }

    public int getPriceRange()
    {
        return priceRange;
    }

    public String getLocation()
    {
        return location;
    }

    public Cuisine getCuisine()
    {
        return cuisine;
    }

    // toString(): returns data as a string
    @Override
    public String toString()
    {
        String priceString ="", starString = ""; // priceString = dollar signs, starString = stars

        for(int i = 0; i < getPriceRange(); i++)
        {
            priceString += "$";
        }
        for(int i = 0; i < getStars(); i++)
        {
            starString += "*";
        }


        return String.format("%s restaurant\n%s\t\t%s\n%sLocation: %s\nReview:\t%s\n\n", restaurantName,starString,priceString,
                cuisine.toString(),location, review);
    }
}
