package jp.ac.kcg.E19C4019;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.heartrails.HeartRails;
import com.heartrails.Response;

public class HRJson {
	public static Response search(String key) {
		String params = null;
		if (key.matches("\\d{7}")) {
			params = "method=searchByPostal&postal=" + key;
		} else {
			key = URLEncoder.encode(key, Charset.defaultCharset());
			params = "method=suggest&matching=like&keyword=" + key;
		}

		Response response = null;

		try {
			URL url = new URL("http://geoapi.heartrails.com/api/json?"
					+ params);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			InputStream in = conn.getInputStream();
			BufferedReader br = new BufferedReader(
					new InputStreamReader(in, "utf-8"));
			Gson gson = new Gson();
			JsonReader jr = new JsonReader(br);
			HeartRails obj = gson.fromJson(jr, HeartRails.class);

			return obj.getResponse();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return response;

	}
}