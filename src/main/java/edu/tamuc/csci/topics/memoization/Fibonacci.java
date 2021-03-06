package edu.tamuc.csci.topics.memoization;

import java.math.BigInteger;

/**
 * Fibonacci number motivation case
 */

public class Fibonacci {

    public int fib(int n) { //n:    0  1 2 3 4 5 6 7..
        if(n < 2) return n; //fib:  0  1 1 2 3 5 8 13
        return fib(n - 1)  + fib(n - 2);
    }

    public long fib2(int n) {
        return fib2(n, new long[n + 1]);
    }

    private long fib2(int n, long[] memo) {
        if(n < 2) return n;
        if(memo[n] == 0) memo[n] = fib2(n - 2, memo) + fib2(n - 1, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();

        long start = System.currentTimeMillis();

        int n = 90; //n should be less than 100 (21 digits > 19 digits, 9 x 10^19 for Long.MAX_VALUE)
//        System.out.println("Fibonacci(" + n + ") = " + fib.fib(n));

        long elapsed = System.currentTimeMillis() - start;

        System.out.println("Time cost : " + elapsed + " ms");

        //use memoization
        start = System.currentTimeMillis();
        System.out.println("Fibonacci(" + n + ") = " + fib.fib2(n));

        elapsed = System.currentTimeMillis() - start;

        System.out.println("Time cost 2 : " + elapsed + " ms");
    }
}
