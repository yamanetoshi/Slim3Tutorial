package jp.shuri.slim3.firsttutorial.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.shuri.slim3.firsttutorial.model.Tweet;

import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TwitterServiceTest extends AppEngineTestCase {

    private TwitterService service = new TwitterService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
    
    @Test
    public void tweet() throws Exception {
        Map<String, Object> input = new HashMap<String, Object>();
        input.put("content", "Hello");
        Tweet tweeted = service.tweet(input);
        assertThat(tweeted, is(notNullValue()));
        Tweet stored = Datastore.get(Tweet.class, tweeted.getKey());
        assertThat(stored.getContent(), is("Hello"));
    }
    
    @Test
    public void getTweetList() throws Exception {
        Tweet tweet = new Tweet();
        tweet.setContent("Hello");
        Datastore.put(tweet);
        List<Tweet> tweetList = service.getTweetList();
        assertThat(tweetList.size(), is(1));
        assertThat(tweetList.get(0).getContent(), is("Hello"));
    }
}
