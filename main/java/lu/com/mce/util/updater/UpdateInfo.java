package lu.com.mce.util.updater;

import java.io.InputStream;
import java.net.URL;

public class UpdateInfo {
	public static int thisVersion = 1;
	public static final String versionURL = "https://docs.google.com/document/d/e/2PACX-1vTgeBQrW16q4wwWF-CsKq2qKUB6hlUiSJNfzABL6kybN_paNMCo89Vpue6FKPR4N-UZYA3sKQpvxEZO/pub";
	
	public static String getLatestVersion() throws Exception {
		String data = getData("https://docs.google.com/document/d/e/2PACX-1vTgeBQrW16q4wwWF-CsKq2qKUB6hlUiSJNfzABL6kybN_paNMCo89Vpue6FKPR4N-UZYA3sKQpvxEZO/pub");
		return data.substring(data.indexOf("[v]") + 3, data.indexOf("[/v]"));
	}
	
	public static String getData(String address) throws Exception {
		URL url = new URL(address);
		InputStream html = null;
		html = url.openStream();
		
		int c = 0;
		StringBuffer buff = new StringBuffer("");
		while(c != -1){
			c = html.read();
			buff.append((char) c);
		}
		return buff.toString();
	}
}
