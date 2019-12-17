package be.BiscontiLagneau.Enum;

public enum Prise {
	Matin("Matin"),
	Midi("Midi"),
	Soir("Soir");
	
	private String prise;
	
	Prise(String p){
		this.prise = p;
	}
	
	public String getGenre() {
		return this.prise;
	}
	
	public static Prise fromString(String text) {
		for (Prise p : Prise.values()) {
            if (p.prise.equals(text)) {
                return p;
            }
        }
        return null;
	}
}
