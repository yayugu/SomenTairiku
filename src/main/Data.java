
package main;

import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import java.io.*;

/**
 *
 * @author yayugu
 * singleton class
 */
final class Data {
    private static final Data instance = new Data();
    private Data(){};
    public static Data getInstance(){
        return Data.instance;
    }

    public Twitter twitter;
    public RequestToken requestToken;
    public AccessToken accessToken = null;
    public String consumerKey = "jzRAY2WOMGOzquTTxtvfQ";
    public String consumerSecret = "DGlj0qwupf9KcqkbzUMnmbeo9HKpophBXJUT4rphk";

    public void saveData(){
        try{
            BufferedWriter bw =
                new BufferedWriter(
                    new OutputStreamWriter(
                        new FileOutputStream("data.dat"), "UTF-8"));
            bw.write(accessToken.getToken() + "\r\n");
            bw.write(accessToken.getTokenSecret() + "\r\n");
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void loadData() throws IOException {
        BufferedReader br =
            new BufferedReader(
                new InputStreamReader(
                    new FileInputStream("data.dat"),"UTF-8"));
        String token = br.readLine();
        String tokenSecret = br.readLine();
        accessToken = new AccessToken(token, tokenSecret);
        twitter = new TwitterFactory().getInstance(accessToken);
        br.close();
    }



}

