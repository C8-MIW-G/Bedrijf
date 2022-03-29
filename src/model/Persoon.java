package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Beschrijft de eigenschappen van een persoon betrokken bij ons bedrijf
 */
public class Persoon {
    public static final String DEFAULT_WOONPLAATS = "Onbekend";
    public static final double DEFAULT_MAAND_SALARIS = 0;
    public static final String DEFAULT_NAAM = "Onbekend";
    public static final int MAANDEN_PER_JAAR = 12;
    private static final double GRENSWAARDE_BONUS = 4500.00;

    public static int aantalPersonen = 0;

    private int personeelsNummer;
    private String naam;
    private String woonplaats;
    private double maandSalaris;

    public Persoon(String naam, String woonplaats, double maandSalaris) {
        this.personeelsNummer = ++aantalPersonen;
        this.naam = naam;
        this.woonplaats = woonplaats;
        setMaandSalaris(maandSalaris);
    }

    public Persoon(String naam) {
        this(naam, DEFAULT_WOONPLAATS, DEFAULT_MAAND_SALARIS);
    }

    public Persoon() {
        this(DEFAULT_NAAM);
    }

    public double berekenJaarInkomen() {
        return MAANDEN_PER_JAAR * maandSalaris;
    }

    public boolean heeftRechtOpBonus() {
        return maandSalaris >= GRENSWAARDE_BONUS;
    }

    public int getPersoneelsNummer() {
        return personeelsNummer;
    }

    public String getNaam() {
        return naam;
    }

    public double getMaandSalaris() {
        return maandSalaris;
    }

    public void setMaandSalaris(double maandSalaris) {
        if (maandSalaris >= 0) {
            this.maandSalaris = maandSalaris;
        } else {
            System.out.printf("%.2f is geen geldig maandsalaris, het maandsalaris wordt op %.2f gezet.\n",
                    maandSalaris, DEFAULT_MAAND_SALARIS);
            this.maandSalaris = DEFAULT_MAAND_SALARIS;
        }
    }
}
