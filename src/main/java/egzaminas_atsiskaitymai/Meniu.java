package egzaminas_atsiskaitymai;

public enum Meniu {

	Klientai("/klientai")
	, Ataskaita("/ataskaita");

	private final String itemurl;

	Meniu( String url ) {
		this.itemurl = url;
	}

	public String itemurl() {
		return this.itemurl;
	}
}