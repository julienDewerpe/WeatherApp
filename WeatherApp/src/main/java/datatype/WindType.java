package datatype;

import UOM.UOMWindDirection;
import exceptions.IllegalWindException;

public record WindType(double degree, double speed) {

	private static String direction;

	public WindType() {
		this(0,0);
	}
	
	public WindType(double degree, double speed) {
		if(isValidWindSpeed() && isValidWindDegree()) {
			WindType.direction = this.getDirectionByDegree(degree);
			this.degree = degree;
			this.speed = speed;
		}else {
			WindType.direction = "Nowhere";
			this.degree = -1;
			this.speed = -1;
		}
	}
	

	public boolean isValidWindSpeed() {
		if(speed > 0 || speed < 138.889) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isValidWindDegree() {
		if(degree < 360 || degree > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	private String getDirectionByDegree(double degree) {
		if(degree < 360 && degree > 0 && degree <= 45 && degree > 315) {
			return UOMWindDirection.NORTH.toString();
		}else if(degree < 360 && degree > 0 && degree > 135 && degree <= 225) {
			return UOMWindDirection.SOUTH.toString();
		}else if(degree < 360 && degree > 0 && degree > 45 && degree <= 135) {
			return UOMWindDirection.EAST.toString();
		}else if(degree < 360 && degree > 0 && degree > 225 && degree <= 315) {
			return UOMWindDirection.WEST.toString();
		}else {
			return "None";
		}
	}

	public static String getDirection() {
		return direction;
	}
	
}
