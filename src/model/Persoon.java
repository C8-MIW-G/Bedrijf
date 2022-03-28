package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Beschrijft de eigenschappen van een persoon betrokken bij ons bedrijf
 */
public class Persoon {
    public static final String DEFAULT_WOONPLAATS = "Onbekend";
    public static final int DEFAULT_MAAND_SALARIS = 0;
    public static final String DEFAULT_NAAM = "Onbekend";
    public static final int MAANDEN_PER_JAAR = 12;

    public static int aantalPersonen = 0;

    public int personeelsNummer;
    public String naam;
    public String woonplaats;
    public double maandSalaris;

    public Persoon(String naam, String woonplaats, double maandSalaris) {
        this.personeelsNummer = ++aantalPersonen;
        this.naam = naam;
        this.woonplaats = woonplaats;
        this.maandSalaris = maandSalaris;
    }

    public Persoon(String naam) {
        this.personeelsNummer = ++aantalPersonen;
        this.naam = naam;
        this.woonplaats = DEFAULT_WOONPLAATS;
        this.maandSalaris = DEFAULT_MAAND_SALARIS;
    }

    public Persoon() {
        this.personeelsNummer = ++aantalPersonen;
        this.naam = DEFAULT_NAAM;
        this.woonplaats = DEFAULT_WOONPLAATS;
        this.maandSalaris = DEFAULT_MAAND_SALARIS;
    }

    public double berekenJaarInkomen() {
        return MAANDEN_PER_JAAR * maandSalaris;
    }
}
