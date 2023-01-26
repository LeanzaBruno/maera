package core;

/**
 * @author Bruno Leanza
 * @version 1.0
 */

public enum Airport{
	SABE("Aeroparque Jorge Newbery", FIR.EZE, true, true),
	SAZA("Azul", FIR.EZE),
	SAZB("Bahía blanca", FIR.EZE, true),
	SAZS("Bariloche", FIR.EZE, true),
	SADO("Campo de mayo", FIR.EZE),
	SAZY("Chapelco", FIR.EZE, true),
	SAAC("Concordia", FIR.EZE),
	SADP("El Palomar", FIR.EZE, true),
	SAEZ("Ezeiza", FIR.EZE, true),
	SAZG("General Pico", FIR.EZE),
	SAAG("Gualeguaychú", FIR.EZE),
	SAAJ("Junin", FIR.EZE),
	SAZM("Mar del Plata", FIR.EZE, true),
	SADJ("Mariano Moreno", FIR.EZE),
	SADM("Moron", FIR.EZE),
	SAZN("Neuquén", FIR.EZE, true),
	SAAP("Paraná", FIR.EZE, true),
	SAAR("Rosario", FIR.EZE, true),
	SADF("San Fernando", FIR.EZE, true),
	SAZR("Santa Rosa", FIR.EZE, true),
	SAAV("Sauce Viejo", FIR.EZE, true),
	SAZT("Tandil", FIR.EZE),
	
	SACO("Ing. Ambrosio Taravella", FIR.CBA, true, true),
	SANC("Catamarca", FIR.CBA, true),
	SACE("Escuela de aviación", FIR.CBA),
	SASJ("Jujuy", FIR.CBA, true),
	SANL("La Rioja", FIR.CBA, true),
	SAOC("Río cuarto", FIR.CBA, true),
	SASA("Salta", FIR.CBA, true),
	SAOS("Santa Rosa del Conlara", FIR.CBA),
	SANE("Santiago del Estero", FIR.CBA, true),
	SANR("Termas de Río Hondo", FIR.CBA, true),
	SANT("Tucumán", FIR.CBA, true),
	
	SAME("El Plumerillo", FIR.DOZ, true, true),
	SAMM("Malargüe", FIR.DOZ), 
	SANU("San Juan", FIR.DOZ, true), 
	SAOU("San Luis", FIR.DOZ, true),
	SAMR("San Rafael", FIR.DOZ, true), 
	SAOR("Villa Reynolds", FIR.DOZ),
	
	SARE("Resistencia", FIR.SIS, true, true),
	SARC("Corrientes", FIR.SIS, true),
	SARF("Formosa", FIR.SIS, true),
	SARI("Iguazú", FIR.SIS, true),
	SARL("Paso de los Libres", FIR.SIS),
	SARP("Posadas", FIR.SIS, true),
	SATR("Reconquista", FIR.SIS),
	
	SAVC("Comodoro Rivadavia", FIR.CVR, true, true),
	SAWC("El Calafate", FIR.CVR, true),
	SAVE("Esquel", FIR.CVR, true),
	SAWP("Perito Moreno", FIR.CVR),
	SAVY("Puerto Madryn", FIR.CVR),
	SAWG("Río Gallegos", FIR.CVR, true),
	SAWE("Río Grande", FIR.CVR, true),
	SAWJ("San Julián", FIR.CVR), 
	SAWU("Santa Cruz", FIR.CVR), 
	SAVT("Trelew", FIR.CVR, true),
	SAWH("Ushuaia", FIR.CVR, true),
	SAVV("Viedma", FIR.CVR, true),
	
	SAWB("Base Marambio", FIR.ANT, true, true);
	
	String name;
	FIR fir;
	boolean issuesTAF = false;
	boolean issuesPRONAREA = false;
	METAR metar;
	TAF taf;

	Airport(String name, FIR fir) {
		this.name = name;
		this.fir = fir;
	}

	Airport(String name, FIR fir, boolean issuesTAF ) {
		this.name = name;
		this.fir = fir;
		this.issuesTAF = issuesTAF;
	}

	Airport(String name, FIR fir, boolean issuesTAF, boolean issuesPRONAREA) {
		this.name = name;
		this.fir = fir;
		this.issuesTAF = issuesTAF;
		this.issuesPRONAREA = issuesPRONAREA;	
	}
};
