package controller;

import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Maakt personen in het bedrijf aan en laat hun eigenschappen zien.
 */
public class BedrijfLauncher {

    public static void main(String[] args) {
        ArrayList<Afdeling> afdelingen = new ArrayList<>();
        File afdelingenBestand = new File("resources/Afdelingen.txt");
        try {
            Scanner afdelingenScanner = new Scanner(afdelingenBestand);
            while (afdelingenScanner.hasNextLine()) {
                String afdelingsNaam = afdelingenScanner.nextLine();
                String afdelingsPlaats = afdelingenScanner.nextLine();
                afdelingen.add(new Afdeling(afdelingsNaam, afdelingsPlaats));
            }
            afdelingenScanner.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Het afdelingen bestand kon niet geopend worden.");
        }

        ArrayList<Persoon> personen = new ArrayList<>();
        File personenBestand = new File("resources/Personen.csv");
        try {
            Scanner personenScanner = new Scanner(personenBestand);

            while (personenScanner.hasNextLine()) {
                String[] regelArray = personenScanner.nextLine().split(",");
                String typePersoon = regelArray[0];
                String naam = regelArray[1];
                String woonplaats = regelArray[2];
                int afdelingsIndex = Integer.parseInt(regelArray[3]);
//                double geldIets = Double.parseDouble(regelArray[4]);

                switch (typePersoon) {
                    case "Werknemer":
                        double maandSalaris = Double.parseDouble(regelArray[4]);
                        personen.add(new Werknemer(naam, woonplaats, afdelingen.get(afdelingsIndex), maandSalaris));
                        break;
                    case "Zzper":
                        double uurTarief = Double.parseDouble(regelArray[4]);
                        personen.add(new Zzper(naam, woonplaats, afdelingen.get(afdelingsIndex), uurTarief));
                        break;
                    case "Vrijwilliger":
                        personen.add(new Vrijwilliger(naam, woonplaats, afdelingen.get(afdelingsIndex)));
                        break;
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Het personen bestand kon niet geopend worden.");
        }

        Collections.sort(personen);

        File personenUitvoerBestand = new File("resources/PersonenPerAfdeling.txt");
        try (PrintWriter personenSchrijver = new PrintWriter(personenUitvoerBestand)) {
            for (Afdeling afdeling : afdelingen) {
                personenSchrijver.printf("Afdeling: %s\n", afdeling.getAfdelingsNaam());
                for (Persoon persoon : personen) {
                    if (persoon.getAfdeling().equals(afdeling)) {
                        personenSchrijver.println("-- " + persoon);
                    }
                }

                personenSchrijver.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public static void toonJaarInkomen(Persoon persoon) {
        System.out.printf("%s verdient %.2f per jaar\n", persoon.getNaam(), persoon.berekenJaarInkomen());
    }
}
