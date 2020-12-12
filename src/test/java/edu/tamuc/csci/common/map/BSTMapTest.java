package edu.tamuc.csci.common.map;

import edu.tamuc.csci.common.Util;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class BSTMapTest {

    @Test
    void test() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(Util.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

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

        System.out.println();
    }
}