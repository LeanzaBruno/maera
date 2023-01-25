package core;

/**
 * Represents an airport
 * @author kertz
 * @version 1.0
 */


public class Airport {
	private String name;
	private char[] icao;
	private boolean issuesMETAR, issuesTAF, issuesPRONAREA;
	private String METAR, TAF, PRONAREA;

	public Airport(String name, char[] icao, boolean issuesMETAR, boolean issuesTAF, boolean issuesPRONAREA) {
		this.name = name;
		this.icao = icao;
		this.issuesMETAR = issuesMETAR;
		this.issuesTAF = issuesTAF;
		this.issuesPRONAREA = issuesPRONAREA;	
	}
	
	enum RETURN_TYPE{
		UPDATED,
		NOT_UPDATED,
		DOESNT_ISSUE
	}
	
	public String name() {
		return name;
	}
	
	public char[] code(){
		return icao;
	}
	
	public boolean issuesMETAR() {
		return issuesMETAR;
	}
	
	public boolean issuesTAF() {
		return issuesTAF;
	}
	
	public boolean issuesPRONAREA() {
		return issuesPRONAREA;
	}
	
	public RETURN_TYPE updateMETAR(String metar) {
		if(issuesMETAR) {
			METAR = metar;
			return RETURN_TYPE.UPDATED;
		}
		return RETURN_TYPE.DOESNT_ISSUE;
	}

	public boolean updateTAF(String taf) {
		if(issuesTAF) {
			TAF = taf;
			return true;
		}
		return false;
	}
	
	
};
