package dsk.tweet_a_gram.cui;

import javax.inject.Inject;

import dsk.tweet_a_gram.core.delegates.MediaDelegate;
import dsk.tweet_a_gram.core.delegates.TweetDelegate;
import dsk.tweet_a_gram.cui.utils.CuiUtils;

public class CuiTweet implements TweetDelegate, MediaDelegate {
	private CuiUtils cuiUtils;

	@Inject
	public CuiTweet(CuiUtils cuiUtils) {
		super();
		this.cuiUtils = cuiUtils;
	}

	@Override
	public boolean isTweet() {
		return true;
	}

	@Override
	public String getTweet() {
		return this.cuiUtils.inputConsole("140文字以内でつぶやいてください。");
	}

	@Override
	public void setMediaPath(String path) {
		System.out.println(path);
	}

	@Override
	public String getMediaPath() {
		return this.cuiUtils.inputConsole("つぶやく画像のフルパスを入力してください。");
	}
}
