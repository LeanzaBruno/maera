package core;

/**
 * WeatherReport represents a weather observation(e.g. METAR) or forecast(e.g. TAF)
 * Both has same values as the airport who has emitted the report, 
 * @author Bruno
 * @version 1.0
 */

public class WeatherReport {
	private Airport airport;
	private String emission_datetime;
	private String message;
	
	public WeatherReport(Airport airport, String emission_datetime, String message){
		this.airport = airport;
		this.emission_datetime = emission_datetime;
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Aeropuerto: " + airport.name() + "\nEmisión: " + emission_datetime + "\n" + message + "\n";
	}
}
