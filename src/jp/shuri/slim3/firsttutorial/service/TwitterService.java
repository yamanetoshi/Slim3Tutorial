package jp.shuri.slim3.firsttutorial.service;

import java.util.List;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Transaction;

import jp.shuri.slim3.firsttutorial.meta.TweetMeta;
import jp.shuri.slim3.firsttutorial.model.Tweet;


public class TwitterService {
    
    private TweetMeta t = new TweetMeta();
    
    public Tweet tweet(Map<String, Object> input) {
        Tweet tweet = new Tweet();
        BeanUtil.copy(input, tweet);
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(tweet);
        tx.commit();
        return tweet;
    }
    
    public List<Tweet> getTweetList() {
        return Datastore.query(t).sort(t.createdDate.desc).asList();
    }
}
