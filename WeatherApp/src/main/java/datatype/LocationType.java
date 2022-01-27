package datatype;

public record LocationType(String name, String country, double lon, double lat) {
	public LocationType() {
		this("", "", 0, 0);
	}
	
	public LocationType(String name, String country, double lon, double lat) {
		this.name = name;
		this.country = country;
		this.lon = lon; //verif possible
		this.lat = lat; //verif possible
	}
}