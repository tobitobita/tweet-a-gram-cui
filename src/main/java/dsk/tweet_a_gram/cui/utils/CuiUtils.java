package dsk.tweet_a_gram.cui.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.inject.Singleton;

@Singleton
public class CuiUtils {
	private BufferedReader console = new BufferedReader(new InputStreamReader(
			System.in));

	public String inputConsole(String displayStr) {
		String inputStr = null;
		try {
			do {
				System.out.println(displayStr);
			} while (null == (inputStr = console.readLine()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputStr;
	}
}
