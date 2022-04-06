package controller;

import database.AfdelingDAO;
import database.DBaccess;
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
        DBaccess dBaccess = new DBaccess("Bedrijf", "userBedrijf", "userBedrijfPW");
        dBaccess.openConnection();
        AfdelingDAO afdelingDAO = new AfdelingDAO(dBaccess);
        ArrayList<Afdeling> afdelingenUitDeDatabase = afdelingDAO.geefAfdelingenMetPlaats("Hilversum");


        for (Afdeling afdeling : afdelingenUitDeDatabase) {
            System.out.println(afdeling);
        }
        dBaccess.closeConnection();
    }

    public static void toonJaarInkomen(Persoon persoon) {
        System.out.printf("%s verdient %.2f per jaar\n", persoon.getNaam(), persoon.berekenJaarInkomen());
    }
}
