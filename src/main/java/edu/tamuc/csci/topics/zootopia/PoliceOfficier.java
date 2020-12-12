package edu.tamuc.csci.topics.zootopia;

/**
 * @author ruby_
 * @create 2020-09-30-2:45 PM
 */

public class PoliceOfficier implements Job {
    @Override
    public void doJobs() {
        partrol();
        giveTickets();
        fightCriminal();
    }

    private void partrol() {
        System.out.println("I'm partroling");
    }

    private void giveTickets() {
        System.out.println("Im giving out tickets");
    }

    private void fightCriminal() {
        System.out.println("I'm fighting against criminals");
    }
}
