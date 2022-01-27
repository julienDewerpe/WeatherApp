package datatype;

public record WeatherType (String weather, String desc){
	public WeatherType() {
		this("", "");
	}
	
	public WeatherType(String weather, String desc) {
		this.weather = weather;
		this.desc = desc;
	}
	
	
	
}
