
package main;

import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import java.io.*;
import java.net.URI;

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

    private Twitter twitter;
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
        br.close();
        instantiateTwitter();
        accessToken = new AccessToken(token, tokenSecret);
        twitter.setOAuthAccessToken(accessToken);
    }
    
	public Twitter getTwitter() {
		return twitter;
	}

	public void instantiateTwitter() {
    	twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(consumerKey, consumerSecret);
	}
	public URI getAuthorizationURL() {
        try {
			requestToken = getTwitter().getOAuthRequestToken();
	        return new URI(requestToken.getAuthorizationURL());
		} catch (Exception e) {
			return null;
		}
	}



}

