package csci.tamuc.edu;

import java.util.Arrays;

/**
 * @author ruby_
 * @create 2020-10-05-2:57 PM
 */

public class Main {

    public static void main(String[] args) {
        Array a = new Array();

        for(int i = 1; i <= 8; i++) {
            a.append(i);
        }

        System.out.println(a.toString());
//        System.out.println(a.contains(-1));
//        System.out.println(a.contains(5));
        System.out.println(a.find(6));
        System.out.println(a.find(0));
    }
}
