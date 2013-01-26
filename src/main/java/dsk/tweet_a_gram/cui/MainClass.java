package dsk.tweet_a_gram.cui;

import twitter4j.Twitter;
import twitter4j.TwitterException;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Stage;
import com.google.inject.TypeLiteral;

import dsk.common.exception.DskException;
import dsk.tweet_a_gram.core.service.TweetService;
import dsk.tweet_a_gram.cui.modules.CuiModule;

public class MainClass {
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(Stage.PRODUCTION, new CuiModule());
		TweetService<Twitter> tweetService = injector.getInstance(Key.get(new TypeLiteral<TweetService<Twitter>>() {
		}));

		try {
			tweetService.deleteTweet(0L);
		} catch (TwitterException e) {
			e.printStackTrace();
		} catch (DskException e) {
			e.printStackTrace();
		}
	}
}
