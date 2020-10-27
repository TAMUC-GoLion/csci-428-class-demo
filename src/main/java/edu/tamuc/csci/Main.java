package edu.tamuc.csci;

import edu.tamuc.csci.api.Stack;
import edu.tamuc.csci.common.AStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author ruby_
 * @create 2020-10-05-2:57 PM
 */

public class Main {

    //API: application programming interface
    public static String toString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("List: [");
        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if(i != list.size() - 1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    // java marker /tag interface
    // java reflection (advanced)
    public static void main(String[] args) {

        List<Integer> arr = new ArrayList<>();


        List<Integer> emptyArry0 = new ArrayList<>(0);
        List<Integer> emptyArry = new ArrayList<>(emptyArry0);

        System.out.println(emptyArry0.hashCode());
        System.out.println(emptyArry.hashCode());
        System.out.println(arr.hashCode());

//        long start = System.currentTimeMillis();
//        Random random = new Random();
//        for(int i = 0; i < 1000000; i++) {
//            arr.add(random.nextInt(Integer.MAX_VALUE));
//        }
//
//        long elapsed = System.currentTimeMillis() - start;
//        System.out.println("Adding 1000000 values to ArrayList takes " + elapsed + " ms");
//        int[] a = {2, 5, -1, 4, 2, 3}; //3rd biggest element nlog(n) quick sort
//
//        Stack<Integer> stack = new AStack<>();
//        for(int e : a) stack.push(e);
//
//        System.out.println(stack.toString());
//
//        System.out.println(stack.pop());
//        System.out.println(stack.toString());

//        new MergeSort().sort(a);
//        System.out.println(Arrays.toString(a));
//        System.out.println(new QuickSelect().kthLargest(a, 2));
//        System.out.println(new QuickSelect().kthLargest(a, 6));
//
//        new QuickSort().sort(a);
//        System.out.println(Arrays.toString(a));
//        QuickSort qs = new QuickSort();
//        qs.sort(a);
//
//        System.out.println(Arrays.toString(a));

//        Array<Integer> a = new Array<>();
//
//        long start = System.currentTimeMillis();
//        for(int i = 1; i <= 30000000; i++) {
////            a.append((char)(65 + i));
//            a.append(i);
//        }
//        long elapsed = System.currentTimeMillis() - start;
//        System.out.println("Grow to size: " + a.size() + " for " + elapsed + " ms");

//        System.out.println(a.toString());
//
//        a.append(-9);
//        a.append(-90);
//        a.append(-900);
//        System.out.println(a.toString());

//        System.out.println(a.contains(-1));
//        System.out.println(a.contains(5));
//        System.out.println(a.find(6));
//        System.out.println(a.find(0));
//
//        a.removeFirst();
//        System.out.println("remove first: " + a.toString());
//
//        while(!a.isEmpty()) {
//            System.out.println("remove last: " + a.removeLast());
//        }

//        a.append((char)68);
//        a.append((char)63);
//        a.append((char)68);
//        a.removeElement((char)68);
//        System.out.println(a.toString());
//
//        a.removeAll('D');
//        System.out.println(a.toString());
    }
}
