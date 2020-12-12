package edu.tamuc.csci.topics.zootopia;

/**
 * @author ruby_
 * @create 2020-09-30-2:20 PM
 */

public class Main {

    public static void main(String[] args) {
        Rabbit judy = new Rabbit("Judy", new PoliceOfficier(), "Rabbit");
        judy.say();
        judy.selfie();
        judy.getJob().doJobs();

        Fox nick = new Fox("Nick", null, "Fox");
        nick.say();
        nick.selfie();

        Sloth flash = new Sloth("Flash", new DMVOfficier(), "Sloth");
        flash.say();
        flash.selfie();
        flash.getJob().doJobs();
    }
}
