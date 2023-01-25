package core;
import java.io.IOException;
import java.util.LinkedList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * This class is in charge of download and retrieving the reports from SMN page
 * @author Bruno
 * @version 1.0
 */
public final  class ReportsHandler{
	 public enum REPORT_TYPE{
		METAR("https://ssl.smn.gob.ar/mensajes/index.php?observacion=metar&operacion=consultar&tipoEstacion=OACI&CODIGO="),
		TAF("https://ssl.smn.gob.ar/mensajes/index.php?observacion=taf&operacion=consultar&tipoEstacion=OACI&CODIGO="), 
		PRONAREA("https://ssl.smn.gob.ar/mensajes/index.php?observacion=pronarea&operacion=consultar&tipoEstacion=OACI&CODIGO=");
		public final String url;
		REPORT_TYPE(String url){ this.url = url; }
	}
	
	private static ReportsHandler instance;
	
	private ReportsHandler(){ }
	
	public static ReportsHandler getInstance() {
		if(instance == null) {
			instance = new ReportsHandler();
			return instance;
		}
		else
			return instance;
	}
	
	public LinkedList<WeatherReport> downloadReports(String [] codes, REPORT_TYPE type) {
		final String url = makeURL(codes, type);
		LinkedList<WeatherReport> reports = new LinkedList<>();
		final Document page = downloadHTML(url);
		final Elements tables = getTablesFromPage(page);
		for(Element table : tables) {
			WeatherReport report = createWeatherReport(table);
			reports.add(report);
		}
		return reports;
	}
	
	private Document downloadHTML(String url) {
		Document page = null;
		try { page = Jsoup.connect(url).get(); }
		catch(Exception e) { System.out.println("Error!" + e.getMessage()); }
		return page;
	}
	
	private Elements getTablesFromPage(Document page) {
		final Elements forms = page.select("form[name='imprimir']");
		final Elements tables = forms.select("table");
		return tables;
	}
	
	private WeatherReport createWeatherReport(Element table) {
		final String airport_name = table.select("td[colspan]").text();
		final String datetime = table.select("td[nowrap]").text();
		final String message = table.select("td[width]").text();
		return new WeatherReport(new Airport(airport_name), datetime, message);
	}
	
	private String makeURL(String[] codes, REPORT_TYPE type) {
		String url = type.url;
		for(String code : codes ) url += "+" + code;
		return url;
	}
}
