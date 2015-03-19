package statustwitter;

import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Clase para recobrar los twitts del morrazo
 *
 * @author damian
 */
//Recien cogido el proyecto
public class StatusTwitter {

    /**
     * @param args the command line arguments
     * @throws twitter4j.TwitterException
     */
    public static void main(String[] args) throws TwitterException {
        Twitter twitter;
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("A9lG3aReLbSgxke16e6Zlqtrx")
                .setOAuthConsumerSecret("ZQGC80ljltnq1XYqdLQC8E5Dd2uj5JQBuw71KjpvvyV1UkzZoa")
                .setOAuthAccessToken("2432074031-YEiRyUNTdCglMEoVr8kiZqwRYpTthT7bfz4bEfu")
                .setOAuthAccessTokenSecret("vQmq07FDPOhCVXkYIO0RJcGqazBS618Al2bJyypV7vQOW");
        twitter = new TwitterFactory(cb.build()).getInstance();

        Paging pagina = new Paging();

        Query query = new Query("#Cangas");
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
        }
    }

}
