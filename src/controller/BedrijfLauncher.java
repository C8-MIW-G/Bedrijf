package controller;

import model.*;

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
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Geef de naam: ");
        String naam = keyboard.nextLine();
        System.out.print("Geef de woonplaats: ");
        String woonplaats = keyboard.nextLine();
        System.out.print("Geef de naam van de afdeling: ");
        String afdelingsNaam = keyboard.nextLine();
        System.out.print("Geef de plaats van de afdeling: ");
        String afdelingsPlaats = keyboard.nextLine();

        boolean onjuisteInvoer = true;
        while (onjuisteInvoer) {
            System.out.print("Geef het maandsalaris: ");
            double maandsalaris = keyboard.nextDouble();
            try {
                Werknemer werknemer = new Werknemer(naam, woonplaats,
                        new Afdeling(afdelingsNaam, afdelingsPlaats), maandsalaris);
                System.out.println(werknemer);
                onjuisteInvoer = false;
            } catch (IllegalArgumentException foutArgument) {
                System.out.println(foutArgument.getMessage());
            } finally {
                System.out.println("Je invoer is op de juiste wijze afgehandeld.");
            }
        }
    }

    public static void toonJaarInkomen(Persoon persoon) {
        System.out.printf("%s verdient %.2f per jaar\n", persoon.getNaam(), persoon.berekenJaarInkomen());
    }
}
