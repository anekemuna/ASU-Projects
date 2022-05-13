// Assignment #:  8
//         Name:  Munachimso Aneke
//   Student ID:  1215028815
//      Lecture:  TTh 9:00am (CSE 205)
//  Description:  Defines a signature dish of a type of cuisine

import java.io.Serializable;

public class Cuisine implements Serializable {
    // The serialVersionUID is used to verify compatibility of senders and
    // receivers. See the document for more details:
    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
    private static final long serialVersionUID = 205L; 
    private String signatureDish;
    private String name;

    public Cuisine(String signatureDish, String name) {
        this.name = name;
        this.signatureDish = signatureDish;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " Cuisine\n" +
                "Signature Dish:\t" + signatureDish + '\n';
    }
}
