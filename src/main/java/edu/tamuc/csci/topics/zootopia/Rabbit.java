package edu.tamuc.csci.topics.zootopia;

/**
 * @author ruby_
 * @create 2020-09-30-2:17 PM
 */

public class Rabbit extends Citizen {

    @Override
    public void selfie() {
        System.out.println("I'm fluffy and cute");
    }

    public Rabbit(String name, Job job, String species) {
        super(name, job, species);
    }
}
