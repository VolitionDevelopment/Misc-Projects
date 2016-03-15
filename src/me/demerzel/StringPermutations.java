package me.demerzel;


import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;

public class StringPermutations {
    static ArrayList<String> permutations = new ArrayList<>();
    static PrintWriter writer;

    public static void main(String[] args) {
        String input = "Apple";
        System.out.println("Permutations for '" + input + "': [" + getNumberOfPermutations(input) + "]");

        try {
            writer = new PrintWriter("Output.txt", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        while(permutations.size() < getNumberOfPermutations(input)){
            String perm = generate(input);

            if(permutations.contains(perm)){
                continue;
            }

            if(perm.equals(input)){
                System.out.println("FYI, the original input String has been randomly generated.");
            }

            permutations.add(perm);
            writer.println(perm);
        }

        writer.close();
    }

    /** This method recursively generates a String based on the input. The generation is a completely random permutation of the original String.
     * It first selects a random character from the input and uses that as it's first character. Repeat the process until the String is empty.
     *
     * @param str User input
     * @return Randomly generated String based on input String
     */
    private static String generate(String str){
        Random r = new Random();

        if(str.length() > 0){
            String c = Character.toString(str.charAt(r.nextInt(str.length())));
            str = str.replaceFirst(c, "");

            return c + generate(str);
        }

        return "";
    }

    /** A simple factorial method
     *
     * @param num User input
     * @return Factorial of num (num!)
     */
    private static long factorial(long num){
        if(num == 0){
            return 1;
        }

        return num * factorial(num - 1);
    }

    /** This method returns the number of UNIQUE permutations that a given String has. For more information on the formula I used: http://goo.gl/0mHznk
     *
     * @param str Input String
     * @return The number of unique permutations of the String
     */
    private static int getNumberOfPermutations(String str){
        int denominator = 1;
        for(char c = 'A'; c <= 'z'; c++){
            if(str.contains(Character.toString(c))){
                denominator *= factorial(StringUtils.countMatches(str, Character.toString(c)));
            }
        }

        return (int) factorial(str.length()) / denominator;
    }
}