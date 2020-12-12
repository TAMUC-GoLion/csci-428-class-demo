package edu.tamuc.csci.topics.zootopia;

/**
 * @author ruby_
 * @create 2020-09-30-2:25 PM
 */

public abstract class Citizen {

    public abstract void selfie();

    private String name;
    private Job job;
    protected String species;

    public Citizen(String name, Job job, String species) {
        this.name = name;
        this.job = job;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void say() {
        System.out.println("Hi, my name is " + name +
                ", I'm a " + species +
                ", and my dream is to become a " + job);
    }
}
