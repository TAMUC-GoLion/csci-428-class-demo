package edu.tamuc.csci.topics.zootopia;

/**
 * @author ruby_
 * @create 2020-09-30-2:22 PM
 */

public class Sloth extends Citizen {

    @Override
    public void selfie() {
        System.out.println("I'm chubby but still handsome");
    }

    public Sloth(String name, Job job, String species) {
        super(name, job, species);
    }

    public void say() {
        System.out.println("Hi, I'm " + getName() + " and I'm a " + species + " and my dream is to be a");
    }
}
