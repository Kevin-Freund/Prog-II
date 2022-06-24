package demo001.simgame;

public class Fuhrpark {
	
	private int Anzahl_Fuhrwerke;
	
	private int kaufpreis_Fuhrwerk;
	
	
	
	public Fuhrpark(String Fuhrpark, int anzahl_Fuhrwerke) {
		this.Anzahl_Fuhrwerke = anzahl_Fuhrwerke;
		this.kaufpreis_Fuhrwerk = 200;
	}
	
	
	
	public int getFuhrwerke() {
		return this.Anzahl_Fuhrwerke;
	}
	
	public void FuhrwerkEntsenden(int entsendenAnzahl) {
		if (entsendenAnzahl <= getFuhrwerke()) {
			this.Anzahl_Fuhrwerke = getFuhrwerke() - entsendenAnzahl;			
		}
		else {
			this.Anzahl_Fuhrwerke = 0;
		}
	}
	
	public int getkaufpreis() {
		return this.kaufpreis_Fuhrwerk;
	}
	
	
	public int FuhrwerkKaufen(int mengeKaufen) {
		this.Anzahl_Fuhrwerke = this.Anzahl_Fuhrwerke + mengeKaufen;
		return this.Anzahl_Fuhrwerke;
	}
	
	public void FuhrwerkVerkaufen(int mengeVerkaufen) {
		if (mengeVerkaufen < getFuhrwerke()) {
			this.Anzahl_Fuhrwerke = getFuhrwerke() - mengeVerkaufen;			
		}
		else {
			this.Anzahl_Fuhrwerke = 0;
		}
	}
	
	
}
