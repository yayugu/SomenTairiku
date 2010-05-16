package main;

import twitter4j.*;

public class SomenTairiku {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });

        System.setProperty("twitter4j.debug", "true");
        Data data = Data.getInstance();
        try{
            data.loadData();
        }catch(Exception e){
            data.twitter = new TwitterFactory().getInstance();
            data.twitter.setOAuthConsumer(data.consumerKey, data.consumerSecret);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new AuthWindow().setVisible(true);
                }
            });
        }
    }
}
