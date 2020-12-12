package edu.tamuc.csci.topics.zootopia;

/**
 * @author ruby_
 * @create 2020-09-30-2:21 PM
 */

public class Fox extends Citizen{

    @Override
    public void selfie() {
        System.out.println("I'm a skinny and handsome guy!");
    }

    public Fox(String name, Job job, String species) {
        super(name, job, species);
    }
}
