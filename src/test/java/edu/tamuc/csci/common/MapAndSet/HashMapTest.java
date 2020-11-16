package edu.tamuc.csci.common.MapAndSet;

import edu.tamuc.csci.common.Util;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {
    @Test
    void test() {
        System.out.println("Pride and Prejudice");

        // Test BST
        long startTime = System.currentTimeMillis();
        ArrayList<String> words = new ArrayList<>();
        if (Util.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size() + "\n");

            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.put(word, map.get(word) + 1);
                else
                    map.put(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        long elapsed = System.currentTimeMillis() - startTime;
        System.out.println("BST time: " + elapsed + "ms\n");

        // Test HashMap
        startTime = System.currentTimeMillis();

        HashMap<String, Integer> hashMap = new HashMap<>(12289); //todo: change the init capacity, can you figure out a way to make our customized hash table more efficient?
        for (String word : words) {
            if (hashMap.contains(word))
                hashMap.put(word, hashMap.get(word) + 1);
            else
                hashMap.put(word, 1);
        }

        System.out.println("Total different words: " + hashMap.getSize());
        System.out.println("Frequency of PRIDE: " + hashMap.get("pride"));
        System.out.println("Frequency of PREJUDICE: " + hashMap.get("prejudice"));

        elapsed = System.currentTimeMillis() - startTime;
        System.out.println("HashMap time: " + elapsed + "ms");
    }

}