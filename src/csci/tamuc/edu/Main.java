package csci.tamuc.edu;

import java.util.Arrays;

/**
 * @author ruby_
 * @create 2020-10-05-2:57 PM
 */

public class Main {

    public static void main(String[] args) {
        Array<Character> a = new Array<>();

        for(int i = 1; i <= 8; i++) {
            a.append((char)(65 + i));
        }

        System.out.println(a.toString());
//        System.out.println(a.contains(-1));
//        System.out.println(a.contains(5));
//        System.out.println(a.find(6));
//        System.out.println(a.find(0));

        a.removeFirst();
        a.append((char)68);
        a.append((char)64);
        a.append((char)68);
        System.out.println(a.toString());

        a.removeElement((char)68);
        System.out.println(a.toString());

        a.removeAll((char)68);
        System.out.println(a.toString());
//        a.delete(3);
//        System.out.println(a.toString());
//
//        while(!a.isEmpty()) {
//            System.out.println(a.removeFirst());
//        }
    }
}
