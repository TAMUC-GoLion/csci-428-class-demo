package edu.tamuc.csci.topics.demo;

/**
 * Copy and past the following code segments (uncomment the sections) to
 *  https://coderpad.io/pads
 *  to review our class demonstration on:
 *  1) demo-1
 *  2) demo-2
 *  3) demo-3
 *  4) demo-4
 */

public class DemoCodeSamples {

    /* demo-1 */
//    public class Solution {
//
//        public static void main(String[] args) {
//            System.out.println("Father's age: " + Son.factor);    //入口
//        }
//    }
//
//    class Grandpa {
//        static {
//            System.out.println("Grandpa's static code segment");
//        }
//    }
//
//    class Father extends Grandpa {
//        static {
//            System.out.println("Father's static code segment");
//        }
//
//        public static int factor = 25;
//
//        public Father() {
//            System.out.println("I'm father");
//        }
//    }
//
//    class Son extends Father {
//        static  {
//            System.out.println("Son's static code segment");
//        }
//
//        public Son() {
//            System.out.println("I'm son");
//        }
//    }

    /* demo-2 */
//    public class Solution {
//
//        public static void main(String[] args) {
//
//            new Son();
//        }
//    }
//
//    class Grandpa {
//        static {
//            System.out.println("Grandpa's static code segment");
//        }
//
//        public Grandpa() {
//            System.out.println("I'm grandpa!");
//        }
//    }
//
//    class Father extends Grandpa {
//        static {
//            System.out.println("Father's static code segment");
//        }
//
//        public static int factor = 25;
//
//        public Father() {
//            System.out.println("I'm father!");
//        }
//    }
//
//    class Son extends Father {
//        static  {
//            System.out.println("Son's static code segment");
//        }
//
//        public Son() {
//            System.out.println("I'm son!");
//        }
//    }

    /* demo-3 */
//    public class Solution {
//
//        public static void main(String[] args)
//        {
//            staticMethod();
//        }
//
//        static Solution solution = new Solution();
//
//        static
//        {
//            System.out.println("Static code segment");
//        }
//
//        {
//            System.out.println("Normal code segment");
//        }
//
//        Solution()
//        {
//            System.out.println("Constructor");
//            System.out.println("Normal field value=" + fieldVal +", Static field value=" + staticFieldVal);
//        }
//
//        public static void staticMethod(){
//            System.out.println("static method");
//        }
//
//        int fieldVal = 110;
//        static int staticFieldVal = 112;
//    }

    /* demo-4 */
//    public class Solution {
//
//        public static void main(String[] args)
//        {
//            B b = new B();
//            B a = new A();
//
//            b.m(); //print 1
//            a.m(); //print -1, bc overriding
//            System.out.println(a.x); //print 1, note here.
//        }
//
//
//    }
//
//    class B {
//        int x = 1;
//
//        void m() {
//            System.out.println(x);
//        }
//    }
//
//    class A extends B {
//        int a = -1;
//        int x = -10; //this won't work if instantiate A from B
//
//        @Override
//        void m() {
//            System.out.println(a); //overriding still works even if instantiate A from B
//        }
//    }
}
