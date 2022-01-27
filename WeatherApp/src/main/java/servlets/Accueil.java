package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

import org.json.JSONException;
import org.json.JSONObject;

import UOM.UOMTemperature;
import beans.rapportMeteo;
import beans.requestAPI;
import datatype.DateType;
import datatype.HumidityType;
import datatype.LocationType;
import datatype.TemperatureType;
import datatype.WeatherType;
import datatype.WindType;

/**
 * Servlet implementation class Accueil
 */
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accueil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ville = request.getParameter("ville");
	
		JSONObject json = new JSONObject();
		json = requestAPI.getRapport(ville);
		
		rapportMeteo rapport = new rapportMeteo(json);
		
		try {
			HumidityType humidityType = rapport.getInJsonHumidity();
			double humidity = humidityType.humidity();
			request.setAttribute("humidity", humidity);
			
			TemperatureType temperature = rapport.getInJsonTemperature();
			double kelvin = temperature.temperature();
			double celcius = temperature.temp();
			double feelsK = temperature.feelsK();
			double feelsC = temperature.feelsC();
			request.setAttribute("kelvin", kelvin);
			request.setAttribute("celcius", celcius);
			request.setAttribute("feelsK", feelsK);
			request.setAttribute("feelsC", feelsC);
			
			String C = UOMTemperature.CELSIUS.toString();
			String K = UOMTemperature.KELVIN.toString();
			request.setAttribute("C", C);
			request.setAttribute("K", K);
			
			DateType laDate = rapport.getDate();
			String date = laDate.getCurrentDate();
			request.setAttribute("date", date);
			
			WindType wind = rapport.getInJsonWind();
			double speed = wind.speed();
			String direction = WindType.getDirection();
			request.setAttribute("speed", speed);
			request.setAttribute("direction", direction);
			
			LocationType location = rapport.getInJsonLocation();
			String name = location.name();
			String country = location.country();
			double lon = location.lon();
			double lat = location.lat();
			request.setAttribute("name", name);
			request.setAttribute("country", country);
			request.setAttribute("lon", lon);
			request.setAttribute("lat", lat);
			
			WeatherType weather = rapport.getInJsonWeather();
			String main = weather.weather();
			String desc = weather.desc();
			String icon = weather.icon();
			request.setAttribute("main", main);
			request.setAttribute("desc", desc);
			request.setAttribute("icon", icon);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
