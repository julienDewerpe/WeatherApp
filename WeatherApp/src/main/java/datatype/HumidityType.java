package datatype;

import exceptions.IllegalHumidityException;

public record HumidityType(double humidity) {
	
	public HumidityType() {
		this(0);
	}
	
	public HumidityType(double humidity) {
		if(isValidHumidity(humidity)) {
			this.humidity = humidity;
		}else {
			this.humidity = -1; //code erreur de format
		}
		
	}

	public boolean isValidHumidity(double humidity) {
		if(humidity < 100 || humidity > 0) {
			return true;
		}else {
			return false;
		}
	}
}
