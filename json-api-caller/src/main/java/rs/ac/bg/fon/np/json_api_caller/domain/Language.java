package rs.ac.bg.fon.np.json_api_caller.domain;

import com.google.gson.annotations.SerializedName;

public class Language {
	
	private String code;
	private String name;
	@SerializedName("native")
	private String lnative;
	
	
	public Language(String code, String name, String lnative) {
		super();
		this.code = code;
		this.name = name;
		this.lnative = lnative;
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

	public String getLnative() {
		return lnative;
	}

	public void setLnative(String lnative) {
		this.lnative = lnative;
	}

	@Override
	public String toString() {
		return "Language [code=" + code + ", name=" + name + ", lnative=" + lnative + "]";
	}
	
	
	
}
