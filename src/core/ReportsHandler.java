package core;
import java.util.LinkedList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * This class is in charge of download, parsing and retrieving the reports from SMN page
 * @author Bruno Leanza
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
	private REPORT_TYPE reportType;
	 
	public LinkedList<WeatherReport> getReport(LinkedList<String> icaoCodes, REPORT_TYPE reportType) {
		this.reportType = reportType;
		final Downloader downloader = new Downloader();
		final Document page = downloader.getPage(icaoCodes);
		
		final Parser parser = new Parser();
		final Elements resultTables = parser.getTables(page);
		
		LinkedList<WeatherReport> reports = new LinkedList<>();
		for(Element table : resultTables) {
			WeatherReport report = parser.createWeatherReport(table);
			reports.add(report);
		}
		return reports;
	}
	
	public LinkedList<WeatherReport> getMetar(LinkedList<String> icaoCodes){
		return getReport(icaoCodes, REPORT_TYPE.METAR);
	}
	
	public LinkedList<WeatherReport> getTaf(LinkedList<String> icaoCodes){
		return getReport(icaoCodes, REPORT_TYPE.TAF);
	}
	
	

	private class Downloader {
		Document getPage(LinkedList<String> icaoCodes) {
			Document page = null;
			String url = makeURL(icaoCodes);
			try { page = Jsoup.connect(url).get(); }
			catch(Exception e) { e.printStackTrace(); }
			return page;
		}
		
		private String makeURL(LinkedList<String> icaoCodes) {
			String url = reportType.url;
			for(String code: icaoCodes) url += "+" + code; 
			return url;
		}
	}
	

	private class Parser{
		private final String FORM_TAG = "form[name='imprimir']";
		private final String TABLE_TAG = "table";
		private final String AIRPORT = "td[colspan]";
		private final String DATETIME = "td[nowrap]";
		private final String REPORT =  "td[width]";
				
		Elements getTables(Document page) {
			final Elements forms = page.select(FORM_TAG);
			final Elements tables = forms.select(TABLE_TAG);
			return tables;
		}

		WeatherReport createWeatherReport(Element table) {
			final String airportName = table.select(AIRPORT).text();
			final String dateTime = table.select(DATETIME).text();
			final String report = table.select(REPORT).text();
			switch(reportType) {
				case METAR: return new METAR(airportName, dateTime, report);
				case TAF: return new TAF(airportName, dateTime, report);
				default: return null;
			}
		}
	}
}
