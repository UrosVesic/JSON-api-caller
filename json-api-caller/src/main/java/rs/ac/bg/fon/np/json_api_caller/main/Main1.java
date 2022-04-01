package rs.ac.bg.fon.np.json_api_caller.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import rs.ac.bg.fon.np.json_api_caller.domain.Country;
import rs.ac.bg.fon.np.json_api_caller.domain.Language;

public class Main1 {
	public static String ACCESS_KEY = "66c6b844be0dce06b2b5dc66aaf4ba5f";
	public static String IP = "178.148.120.167";
	
	public static void main(String[] args) {
		try {
			URL url = new URL("http://api.ipstack.com/"+IP+"?access_key="+ACCESS_KEY);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			HttpURLConnection con2 = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			con2.setRequestMethod("GET");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			BufferedReader in2 = new BufferedReader(new InputStreamReader(con2.getInputStream()));

			Gson gson = new GsonBuilder().create();
			Country country = gson.fromJson(in, Country.class);
			
			JsonObject jsonResult = (JsonObject)gson.fromJson(in2, JsonObject.class);
			JsonObject location = (JsonObject) jsonResult.get("location");
			Language[] languages = gson.fromJson(location.get("languages"), Language[].class);
			
			
			country.setLanguages(languages);
			System.out.println(country);
			
			in.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
