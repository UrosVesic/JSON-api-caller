package rs.ac.bg.fon.np.json_api_caller.domain;

import java.util.Arrays;

import com.google.gson.annotations.SerializedName;

public class Country {
	@SerializedName("country_code")
	private String code;
	@SerializedName("country_name")
	private String name;
	
	@SerializedName("languages")
	private Language[] languages;
	
	
	
	
	
	public Country(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	
	
	
	public Language[] getLanguages() {
		return languages;
	}



	public void setLanguages(Language[] languages) {
		this.languages = languages;
	}



	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	



	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name+", languages="
				+ Arrays.toString(languages) + "]";
	}
	
	
	
	
}
