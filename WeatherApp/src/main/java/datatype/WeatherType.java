package datatype;

public record WeatherType (String weather, String desc, String icon){
	public WeatherType() {
		this("", "", "");
	}
	
	public WeatherType(String weather, String desc, String icon) {
		this.weather = weather;
		this.desc = desc;
		this.icon = icon;
	}
	
	
	
}
