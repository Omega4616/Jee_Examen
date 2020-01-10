package be.BiscontiLagneau.Enum;

public enum Specialisation {
	Cardiologie("cardiologie"),
	Generale("generale"),
	Pneumologie("pneumologie"),
	Neurologie("neurologie"),
	Ophtalmologie("ophtalmologie"),
	Psychiatre("psychiatre"),
	Dermatologie("dermatologie"),
	Gynecologie("gynécologie");
	
	private String spec;
	
	Specialisation(String s){
		this.spec = s;
	}
	
	public String getSpec() {
		return this.spec;
	}
	
	public static Specialisation fromString(String text) {
		for (Specialisation s : Specialisation.values()) {
            if (s.spec.equals(text)) {
                return s;
            }
        }
        return null;
	}
}
