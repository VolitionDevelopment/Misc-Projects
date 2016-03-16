package me.demerzel;

import me.demerzel.util.NumberUtilities;

/**
 * Created by Jackson on 3/15/16.
 */
public class Tester {
    public static void main(String[] args) {
        for(int i : NumberUtilities.sieveOfEratosthenes(3000)){
            System.out.println(i);
        }
    }
}
