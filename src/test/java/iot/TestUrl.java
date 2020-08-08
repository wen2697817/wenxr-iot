package iot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class TestUrl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://121.40.104.147/iot/monitor-Monitor-loadMonitor.action?userCode=1112&equipmentCode=bianhao1";
		try {
			URL oracle = new URL(url);
			URLConnection conn = oracle.openConnection();// 或HttpURLConnection connect = (HttpURLConnection)
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine = null;
			while ((inputLine = br.readLine()) != null) {
				System.out.println(inputLine);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
