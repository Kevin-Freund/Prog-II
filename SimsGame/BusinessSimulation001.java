package demo001.simgame;

import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;

public class BusinessSimulation001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Wirtschaftssimulation Programmierung II");

		Lager lagerAugsburg = new Lager("Augsburg", 5, 1);
		
		Fuhrpark FuhrparkBetrieb = new Fuhrpark("Betriebsfahrzeuge", 1);
		int Fuhrwerke = FuhrparkBetrieb.getFuhrwerke();

		Scanner myScanner = new Scanner(System.in);

		int gesamterloes = 0;
		
		//4.2 Niederlassungsliste erstellen
		ArrayList<Niederlassung> listeNiederlassung = new ArrayList<Niederlassung>();
		listeNiederlassung.add(new Niederlassung("Einbeck", Warenart.BIER, 10, 2));
	    listeNiederlassung.add(new Niederlassung("Wien", Warenart.WEIN, 10, 2));
	    listeNiederlassung.add(new Niederlassung("Nordhausen", Warenart.KORN,7,2));
	    
		while (true) {

			System.out.println("Soll produziert werden? [j/n]");
			String userInput = myScanner.nextLine();

			if (userInput.equals("j")) {
				
				for(int i = 0; i < listeNiederlassung.size();i++) {
					listeNiederlassung.get(i).anfordern();
					listeNiederlassung.get(i).produzieren();
				}
			}

			for(int j = 0; j < listeNiederlassung.size(); j++) {
				int produzierteMenge = listeNiederlassung.get(j).abholen();
				
				Warenart produzierteWarenart = listeNiederlassung.get(j).getWarenart();
				
				System.out.println("Ort: " + listeNiederlassung.get(j).getOrt() + "\tWare: "
						+ listeNiederlassung.get(j).getWarenartString() + "\tMenge: " + produzierteMenge);
				
				lagerAugsburg.einlagern(produzierteWarenart, produzierteMenge);
			}
			
			
			
			System.out.println("Aktueller Bestand im Lager:");
			for (Iterator<Warenart> warenartIterator = lagerAugsburg.getEingelagerteWaren().iterator(); warenartIterator
					.hasNext();) {
				Warenart warenart = (Warenart) warenartIterator.next();
				System.out.println(Util.convertWarenartToString(warenart) + ": " + lagerAugsburg.getBestand(warenart));
			}
			
			System.out.println("Aktuelle Anzahl an Fuhrwerken: " + FuhrparkBetrieb.getFuhrwerke());
			

			int preis = 10;
			int GesErl = 0;
			
			for (Iterator<Warenart> warenartIterator = lagerAugsburg.getEingelagerteWaren().iterator(); warenartIterator
					.hasNext();) {
				Warenart warenart = (Warenart) warenartIterator.next();
				
				System.out.println(
						"Wie viel "+Util.convertWarenartToString(warenart) +" soll verkauft werden? [0.." + lagerAugsburg.getBestand(warenart) + "]");
				
				int mengeZuVerkaufend = Integer.parseInt(myScanner.nextLine());
			
				int erloes = lagerAugsburg.verkaufen(warenart, mengeZuVerkaufend, preis);
				
				GesErl = GesErl + erloes;
				
				System.out.println("Erloes durch Verkauf von " +Util.convertWarenartToString(warenart) + ": " + erloes);
				}
			
			
			int MitarbeiterKosten = 0;
			
			for(int l = 0; l < listeNiederlassung.size(); l++) {
				
				MitarbeiterKosten = MitarbeiterKosten + listeNiederlassung.get(l).getGesamtlohn();
				}
			
			int MAKAugsburg = lagerAugsburg.getGesamtlohn();

			gesamterloes += GesErl - (MitarbeiterKosten + MAKAugsburg);

	
			System.out.println("Kosten durch Loehne: " + (MitarbeiterKosten + MAKAugsburg));
			System.out.println("Gesamterloes: " + gesamterloes);

			System.out.println("Aktueller Bestand im Lager:");
			for (Iterator<Warenart> warenartIterator = lagerAugsburg.getEingelagerteWaren().iterator(); warenartIterator
					.hasNext();) {
				Warenart warenart = (Warenart) warenartIterator.next();
				System.out.println(Util.convertWarenartToString(warenart) + ": " + lagerAugsburg.getBestand(warenart));
			}
			
			
			for (int n = 0; n < listeNiederlassung.size(); n++) {
				
				//4.1.1 Mitarbeiterzahl anpassen
				System.out.println("aktuelle Mitarbeiter in "+ listeNiederlassung.get(n).getOrt() +  ":" + listeNiederlassung.get(n).getAnzahlArbeiter());
				System.out.println("Soll die Mitarbeiteranzahl angepasst werden?");
				String userInput2 = myScanner.nextLine();

					if (userInput2.equals("j")) {		
					System.out.println("Einstellen oder Entlassen");
					String userInput3 = myScanner.nextLine();
					
					if (userInput3.equals("Einstellen")) {
					System.out.println("neue Mitarbeiter: ");
					int neueMitarbeiter = Integer.parseInt(myScanner.nextLine());
					listeNiederlassung.get(n).ArbeiterEinstellen(neueMitarbeiter);
					}
					
					else {
						System.out.println("zu entlassende Mitarbeiter : [0..." + listeNiederlassung.get(n).getAnzahlArbeiter() + "]");
						int freigesetzteMitarbeiter = Integer.parseInt(myScanner.nextLine());
						listeNiederlassung.get(n).arbeiterEntlassen(freigesetzteMitarbeiter);
						}
					}
					
					//4.1.2 Löhne anpassen
					System.out.println("Sollen die Löhne angepasst werden?");
					
					String userInput4 = myScanner.nextLine();
						
						if (userInput4.equals("j")) {
							
							System.out.println("Erhöhen oder Kürzen");
							String userInput5 = myScanner.nextLine();
							
							if (userInput5.equals("Erhöhen")) {
							System.out.println("erhöhte Summe: ");
							int neueLohn = Integer.parseInt(myScanner.nextLine());
							listeNiederlassung.get(n).setLohnerhoehung(neueLohn);
							
							}
							
							else {
								
								System.out.println("abzuziehende Summe: [0..." + listeNiederlassung.get(n).getLohn() + "]");
								int abziehenderLohn = Integer.parseInt(myScanner.nextLine());
								
								listeNiederlassung.get(n).setLohnsenkung(abziehenderLohn);
							
					
								}
							}	
				}		
			
			System.out.println("Möchten Sie die Fuhrwerke bearbeiten?");
			
			String userInput6 = myScanner.nextLine();
				
				if (userInput6.equals("j")) {
					
					System.out.println("Kaufen oder Verkaufen");
					String userInput7 = myScanner.nextLine();
					
					if (userInput7.equals("Kaufen")) {
					System.out.println("erhöhte Summe: ");
					int neueFuhrwerke = Integer.parseInt(myScanner.nextLine());
					FuhrparkBetrieb.FuhrwerkKaufen(neueFuhrwerke);
					}
					
					else {
						
						System.out.println("abzuziehende Summe: [0..." + FuhrparkBetrieb.getFuhrwerke() + "]");
						int abziehendeFuhrwerke = Integer.parseInt(myScanner.nextLine());
						
						FuhrparkBetrieb.FuhrwerkVerkaufen(abziehendeFuhrwerke);
					
			
						}
					}	
			
			}
		}
}
