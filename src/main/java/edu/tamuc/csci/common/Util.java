package edu.tamuc.csci.common;

/**
 * @author ruby_
 * @create 2020-10-12-2:36 PM
 */

public class Util {

    public static void swap(Object[] a, int i, int j) {
        Object tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void swap(int[] a, int i, int j) {
        if(i == j) return;

        a[i] ^= a[j]; // A ^= A ==> 0
        a[j] ^= a[i];
        a[i] ^= a[j];
    }
}
