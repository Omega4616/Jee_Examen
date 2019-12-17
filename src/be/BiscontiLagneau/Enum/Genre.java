package be.BiscontiLagneau.Enum;

public enum Genre {
	Homme("Homme"),
	Femme("Femme");
	
	private String genre;
	
	Genre(String g){
		this.genre = g;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public static Genre fromString(String text) {
		for (Genre g : Genre.values()) {
            if (g.genre.equals(text)) {
                return g;
            }
        }
        return null;
	}
}
