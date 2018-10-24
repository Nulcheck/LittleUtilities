package mce.lu.common.util;

import java.io.InputStream;
import java.net.URL;

public class UsernameHandler {
	public static String getUsernames() throws Exception {
		String data = getData(
				"https://gist.githubusercontent.com/MCE626/6dad0b6d4429d52e7a8698440793cbe2/raw/");
		return data.substring(data.indexOf("[")+1, data.indexOf("]"));
	}

	private static String getData(String address) throws Exception {
		URL url = new URL(address);
		InputStream html = null;
		html = url.openStream();

		int c = 0;
		StringBuffer buffer = new StringBuffer("");
		while (c != -1) {
			c = html.read();
			buffer.append((char) c);
		}
		return buffer.toString();
	}
}
