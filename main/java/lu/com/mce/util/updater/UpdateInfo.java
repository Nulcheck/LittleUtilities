package lu.com.mce.util.updater;

import java.io.InputStream;
import java.net.URL;

public class UpdateInfo {
	public static int thisVersion = 2;
	public static final String versionURL = "https://docs.google.com/document/d/1OmMBVciFnmQJn98AQHk-aGgaQTBT3QJlTPP9sMRSRBM/pub";

	public static String getLatestVersion() throws Exception {
		String data = getData("https://docs.google.com/document/d/1OmMBVciFnmQJn98AQHk-aGgaQTBT3QJlTPP9sMRSRBM/pub");
		return data.substring(data.indexOf("[version]") + 9, data.indexOf("[/version]"));
	}

	public static String getData(String address) throws Exception {
		URL url = new URL(address);
		InputStream html = null;
		html = url.openStream();

		int c = 0;
		StringBuffer buff = new StringBuffer("");
		while (c != -1) {
			c = html.read();
			buff.append((char) c);
		}
		return buff.toString();
	}
}
