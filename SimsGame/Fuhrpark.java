package demo001.simgame;

public class Fuhrpark {
	
	private int anzahl_Fuhrwerke;
	
	private int kaufpreis_Fuhrwerk;
	
	
	
	public Fuhrpark(String Fuhrpark, int anzahl_Fuhrwerke) {
		this.anzahl_Fuhrwerke = anzahl_Fuhrwerke;
		this.kaufpreis_Fuhrwerk = 200;
	}
	
	
	
	public int getFuhrwerke() {
		return this.anzahl_Fuhrwerke;
	}
	
	public int FuhrwerkEntsenden(int anzahl) {
		return anzahl;
	}
	
	public int getkaufpreis() {
		return this.kaufpreis_Fuhrwerk;
	}
	
	
	public int FuhrwerkKaufen(int mengeKaufen) {
		this.anzahl_Fuhrwerke = this.anzahl_Fuhrwerke + mengeKaufen;
		return this.anzahl_Fuhrwerke;
	}
	
	public void FuhrwerkVerkaufen(int mengeVerkaufen) {
		if (mengeVerkaufen < getFuhrwerke()) {
			this.anzahl_Fuhrwerke = getFuhrwerke() - mengeVerkaufen;			
		}
		else {
			this.anzahl_Fuhrwerke = 0;
		}
	}
	
	
}