package edu.tamuc.csci.topics.zootopia;

/**
 * @author ruby_
 * @create 2020-09-30-2:47 PM
 */

public class DMVOfficier implements Job {

    @Override
    public void doJobs() {
        takePictures();
    }

    private void takePictures() {

        talkJokes();
        System.out.println("I'm taking pictures");
    }

    private void talkJokes() {

        System.out.println("What do you call a three humped camel?");
        try {
            Thread.sleep(5000); //telling jokes...
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ha~ha~ha~ha");
    }
}
