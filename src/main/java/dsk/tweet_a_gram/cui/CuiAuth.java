package dsk.tweet_a_gram.cui;

import javax.inject.Inject;

import dsk.tweet_a_gram.core.delegates.AuthDelegate;
import dsk.tweet_a_gram.cui.utils.CuiUtils;

public class CuiAuth implements AuthDelegate {
	private CuiUtils cuiUtils;

	@Inject
	public CuiAuth(CuiUtils cuiUtils) {
		super();
		this.cuiUtils = cuiUtils;
	}

	@Override
	public String doAuthTwitter(String url) {
		return this.cuiUtils.inputConsole(String.format(
				"URLよりPINコードを取得し、入力してください。\n%s", url));
	}
}
