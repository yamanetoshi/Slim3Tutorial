package jp.shuri.slim3.firsttutorial.controller.twitter;

import java.util.List;

import jp.shuri.slim3.firsttutorial.model.Tweet;
import jp.shuri.slim3.firsttutorial.service.TwitterService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {
    
    private TwitterService service = new TwitterService();

    @Override
    public Navigation run() throws Exception {
        List<Tweet> tweetList = service.getTweetList();
        requestScope("tweetList", tweetList);
        return forward("index.jsp");
    }
}
