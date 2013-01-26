package dsk.tweet_a_gram.cui.modules;

import java.lang.reflect.Method;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.AbstractMatcher;
import com.google.inject.matcher.Matchers;

import dsk.common.logging.LogInterceptor;
import dsk.tweet_a_gram.core.delegates.AuthDelegate;
import dsk.tweet_a_gram.core.delegates.MediaDelegate;
import dsk.tweet_a_gram.core.delegates.TweetDelegate;
import dsk.tweet_a_gram.core.service.AuthService;
import dsk.tweet_a_gram.core.service.TweetService;
import dsk.tweet_a_gram.core.twitter.TweetTwitter;
import dsk.tweet_a_gram.core.twitter.TwitterAuthService;
import dsk.tweet_a_gram.cui.CuiAuth;
import dsk.tweet_a_gram.cui.CuiTweet;
import dsk.tweet_a_gram.cui.utils.CuiUtils;

public class CuiModule extends AbstractModule {

	@Override
	protected void configure() {
		this.bind(AuthDelegate.class).to(CuiAuth.class);
		this.bind(TweetDelegate.class).to(CuiTweet.class);
		this.bind(MediaDelegate.class).to(CuiTweet.class);
		this.bind(CuiUtils.class);
		this.bind(Twitter.class).toInstance(new TwitterFactory().getInstance());
		this.bind(new TypeLiteral<TweetService<Twitter>>() {
		}).to(TweetTwitter.class);
		this.bind(new TypeLiteral<AuthService<Twitter>>() {
		}).to(TwitterAuthService.class);

		this.bindInterceptor(Matchers.inSubpackage("dsk.tweet_a_gram.core"), new NoSyntheticMatcher(),
				new LogInterceptor());
	}

	private class NoSyntheticMatcher extends AbstractMatcher<Method> {
		@Override
		public boolean matches(Method method) {
			return !method.isSynthetic();
		}
	}
}
