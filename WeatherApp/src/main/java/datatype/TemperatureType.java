package datatype;

import exceptions.IllegalTemperatureExcpetion;

public record TemperatureType(double temperature, double temp, double feelsK, double feelsC) {

	public TemperatureType() {
		this(0,0,0,0);
	}
	
	public TemperatureType(double temperature, double temp, double feelsK, double feelsC) {
		if(isValidTemperature(temperature) && isValidTemperature(feelsK)) {
			this.temperature = temperature;
			this.temp = this.getTemperatureInCelcius(temp);
			this.feelsK = feelsK;
			this.feelsC = this.getTemperatureInCelcius(feelsK);
		}else {
			this.temperature = -404;
			this.temp = -404;
			this.feelsK = -404;
			this.feelsC = -404;
		}
	}
	
	private double getTemperatureInCelcius(double temperature) {
		double temp = Math.round((temperature - 273.15)*100.0)/100.0;
		return temp;
	}

	public boolean isValidTemperature(double temperature) {
		if(temperature < 333.15 || temperature > 173.15) {
			return true;
		}else {
			return false;
		}
	}
	
}
