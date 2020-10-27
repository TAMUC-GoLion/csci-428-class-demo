package edu.tamuc.csci.topics.reflection;

/**
 * @author ruby_
 * @create 2020-10-27-3:10 PM
 *
 * Demonstration of Java Reflection
 */

public class TestClass {

    private String attribute = "Private attribute (Original)";

    private void privateMethod(String msg , int i){
        System.out.print("Private method call_" + i + ":" + msg);
    }

    public String getAttribute() {
        return attribute;
    }
}
