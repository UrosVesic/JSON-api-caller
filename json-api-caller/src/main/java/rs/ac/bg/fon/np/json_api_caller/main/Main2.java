package rs.ac.bg.fon.np.json_api_caller.main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import rs.ac.bg.fon.np.json_api_caller.domain.Country;
import rs.ac.bg.fon.np.json_api_caller.domain.Language;

public class Main2 {

	public static void main(String[] args) {
		
		
		Country c1 = new Country("MNE", "Montenegro");
		Country c2 = new Country("BiH", "Bosnia and Herzegovina");
		Country c3 = new Country("CRO", "Croatia");
		
		Country[] countries = {c1,c2,c3};
		
		Language l1 = new Language("rs", "Serbian", "Српски");
		Language l2 = new Language("cro", "Croatian", "hrvatski");
		Language l3 = new Language("mne", "Montenegrin", "црногорски");
		Language l4 = new Language("bos", "Bosnian", "bosanski");
		
		Language[] languages1 = {l1,l3};
		Language[] languages2 = {l1,l2,l4};
		Language[] languages3 = {l1,l2};
		
		c1.setLanguages(languages1);
		c2.setLanguages(languages2);
		c3.setLanguages(languages3);
		
		try(PrintWriter pw = new PrintWriter(new FileWriter("niz_objekata.json"))){
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			pw.print(gson.toJson(countries));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
