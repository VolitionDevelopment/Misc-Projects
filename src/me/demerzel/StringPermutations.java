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
                System.out.println("FYI, I generated a permutation of the original String.");
            }

            permutations.add(perm);
            writer.println(perm);
        }

        writer.close();
    }

    private static String generate(String str){
        Random r = new Random();

        if(str.length() > 0){
            String c = Character.toString(str.charAt(r.nextInt(str.length())));
            str = str.replaceFirst(c, "");

            return c + generate(str);
        }

        return "";
    }

    private static long factorial(long num){
        if(num == 0){
            return 1;
        }

        return num * factorial(num - 1);
    }

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