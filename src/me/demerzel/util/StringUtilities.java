package me.demerzel.util;

import me.demerzel.util.NumberUtilities;

/**
 * Created by Jackson on 3/15/16.
 */
public class StringUtilities {

    /** This method returns the number of UNIQUE permutations that a given String has. For more information on the formula I used: http://goo.gl/0mHznk
     *
     * @param str Input String
     * @return The number of unique permutations of the String
     */
    public static int getNumberOfPermutations(String str){
        int denominator = 1;
        for(char c = 'A'; c <= 'z'; c++){
            if(str.contains(Character.toString(c))){
                denominator *= NumberUtilities.factorial(org.apache.commons.lang3.StringUtils.countMatches(str, Character.toString(c)));
            }
        }

        return (int) NumberUtilities.factorial(str.length()) / denominator;
    }
}
