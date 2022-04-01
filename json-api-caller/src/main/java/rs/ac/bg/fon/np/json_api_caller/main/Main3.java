package rs.ac.bg.fon.np.json_api_caller.main;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import rs.ac.bg.fon.np.json_api_caller.domain.Country;

public class Main3 {
	public static void main(String[] args) {
		try (FileReader in = new FileReader("niz_objekata.json")) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Type collectionType = new TypeToken<LinkedList<Country>>() {
			}.getType();
			List<Country> countries = gson.fromJson(in, collectionType);

			for (Country country : countries) {
				System.out.println(country);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
