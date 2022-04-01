package rs.ac.bg.fon.np.json_api_caller.main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import rs.ac.bg.fon.np.json_api_caller.domain.Country;
import rs.ac.bg.fon.np.json_api_caller.domain.Language;

public class Main4 {

	public static void main(String[] args) {
		Country c2 = new Country("BiH", "Bosnia and Herzegovina");
		
		Language l1 = new Language("rs", "Serbian", "Српски");
		Language l2 = new Language("cro", "Croatian", "hrvatski");
		Language l3 = new Language("bos", "Bosnian", "bosanski");
		
		Language[] languages2 = {l1,l2,l3};
		
		c2.setLanguages(languages2);
		
		JsonObject country = new JsonObject();
		JsonArray languages = new JsonArray();
		JsonObject language1 = new JsonObject();
		JsonObject language2 = new JsonObject();
		JsonObject language3 = new JsonObject();
		
		country.addProperty("country_code", c2.getCode());
		country.addProperty("country_name", c2.getName());
		
		language1.addProperty("code", l1.getCode());
		language1.addProperty("name", l1.getName());
		language1.addProperty("native", l1.getLnative());
		
		language2.addProperty("code", l2.getCode());
		language2.addProperty("name", l2.getName());
		language2.addProperty("native", l2.getLnative());
		
		language3.addProperty("code", l3.getCode());
		language3.addProperty("name", l3.getName());
		language3.addProperty("native", l3.getLnative());
		
		languages.add(language1);
		languages.add(language2);
		languages.add(language3);
		
		country.add("languages", languages);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try(PrintWriter pw = new PrintWriter(new FileWriter("rucni_upis.json"))){
			pw.print(gson.toJson(country));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
