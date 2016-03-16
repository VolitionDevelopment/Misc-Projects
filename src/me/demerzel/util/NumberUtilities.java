package me.demerzel.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Jackson on 3/15/16.
 */
public class NumberUtilities {
    /** A simple factorial method
     *
     * @param num User input
     * @return Factorial of num (num!)
     */
    public static long factorial(long num){
        if(num == 0){
            return 1;
        }

        return num * factorial(num - 1);
    }

    public static int gcd(int a, int b){
        if(a == 0 || b == 0){
            return Math.abs(Math.max(Math.abs(a), Math.abs(b)));
        }

        int r = a % b;
        if(r == 0){
            return Math.abs(b);
        }else{
            return gcd(b, r);
        }
    }

    public static boolean coprime(int a, int b){
        return gcd(a, b) == 1;
    }

    public static boolean primeProbability(int p){
        int b = 2;
        while(!coprime(p, b)){
            b++;
        }

        return (Math.pow(b, p - 1) % p) == 1;
    }

    public static boolean isPrime(int p){
        if(p < 2) return false;
        if(p == 2 || p == 3) return true;
        if(p % 2 == 0 || p % 3 == 0) return false;

        double sqrt = Math.sqrt(p) + 1;

        for(int i = 6; i < sqrt; i++){
            if(p % (i - 1) == 0 || p % (i + 1) == 0) return false;
        }

        return true;
    }

    public static int[] sieveOfEratosthenes(int upperBound){
        int upperSqrt = (int) Math.sqrt(upperBound);

        HashMap<Integer, Boolean> composite = new HashMap<>();
        ArrayList<Integer> primes = new ArrayList<>();

        for(int i = 2; i <= upperSqrt; i++){
            if(composite.get(i) == null){
                primes.add(i);
                for(int m = i * i; m <= upperBound; m += i){
                    composite.put(m, true);
                }
            }
        }

        for(int i = upperSqrt; i <= upperBound; i++){
            if(composite.get(i) == null){
                primes.add(i);
            }
        }

        return convertIntegers(primes);
    }

    //Thanks StackOverflow
    private static int[] convertIntegers(List<Integer> integers) {
        int[] ret = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = iterator.next();
        }
        return ret;
    }
}
