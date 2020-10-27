package edu.tamuc.csci.topics.reflection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TestClassTest {

    @Test
    @DisplayName("Test (1): Access private method")
    void testReflectionPrivateMethod() throws Exception {
        //1. get class instance
        TestClass testClass = new TestClass();
        Class mClass = testClass.getClass();

        //2. access private method
        // parameter list:
        // 1) private method name declared
        // 2) (multiple) method parameters' classes
        Method privateMethod =
                mClass.getDeclaredMethod("privateMethod", String.class, int.class);

        //3. operate on obtained private methods
        if (privateMethod != null) {
            //open access level (will not change the original access)
            privateMethod.setAccessible(true);

            //use invoke to call the private methods
            privateMethod.invoke(testClass, "Java Reflect ", 666);
        }
    }

    @Test
    @DisplayName("Test (2) Access private attribute")
    void testModifyPrivateAttribute() throws Exception {
        //1. get class instance
        TestClass testClass = new TestClass();
        Class mClass = testClass.getClass();

        //2. access private field
        Field privateField = mClass.getDeclaredField("attribute");

        //3. operate private field
        if (privateField != null) {
            //set access level
            privateField.setAccessible(true);

            //before modify private field
            System.out.println("Before Modify：attribute = " + privateField.get(testClass));

            //modify
            privateField.set(testClass, "Private Attribute (Updated)");

            //after modify
            System.out.println("After Modify：attribute = " + privateField.get(testClass));
        }
    }

    @Test
    void testArrayListInitialization() throws  Exception {
        ArrayList<Integer> arr0 = new ArrayList<>(); //init arraylist by default

        ArrayList<Integer> arr1 = new ArrayList<>(0); //init arraylist by 0 capacity
        ArrayList<Integer> arr2 = new ArrayList<>(arr1); //init arraylist by collection with 0 capacity

        Class arrayListClass = arr0.getClass(); //get class instance of ArrayList
        Field elementDataField = arrayListClass.getDeclaredField("elementData");

        if(elementDataField != null) {
            elementDataField.setAccessible(true);

            System.out.println(elementDataField.get(arr0));
            System.out.println(elementDataField.get(arr1));
            System.out.println(elementDataField.get(arr2));

            assertTrue(elementDataField.get(arr0) != elementDataField.get(arr1));
            assertTrue(elementDataField.get(arr1) == elementDataField.get(arr2));
        }
    }

}