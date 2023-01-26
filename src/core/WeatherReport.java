package core;

/**
 * WeatherReport represents a weather observation(e.g. METAR) or forecast(e.g. TAF)
 * @author Bruno Leanza
 * @version 1.0
 */

public class WeatherReport {
	private String airportName;
	private String dateTime;
	private String unparsedReport;

	public WeatherReport(String airportName, String dateTime, String unparsedReport){
		this.airportName = airportName;
		this.dateTime = dateTime;
		this.unparsedReport = unparsedReport;
	}
	
	public String getAirportName() { return airportName; }
	public String getDateAndTime() { return dateTime; }
	public String getReport() { return unparsedReport; }
}
