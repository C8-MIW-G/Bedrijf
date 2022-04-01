package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Beschrijft een persoon in loondienst bij het bedrijf
 */
public class Werknemer extends Persoon {
    private static final double DEFAULT_MAAND_SALARIS = 0;
    private static final int MAANDEN_PER_JAAR = 12;
    private static final double GRENSWAARDE_BONUS = 4500.00;

    private double maandSalaris;

    public Werknemer(String naam, String woonplaats, Afdeling afdeling, double maandSalaris) {
        super(naam, woonplaats, afdeling);
        setMaandSalaris(maandSalaris);
    }

    public Werknemer(String naam) {
        this(naam, DEFAULT_WOONPLAATS, new Afdeling(), DEFAULT_MAAND_SALARIS);
    }

    public Werknemer() {
        this(DEFAULT_NAAM);
    }

    public boolean heeftRechtOpBonus() {
        return maandSalaris >= GRENSWAARDE_BONUS;
    }

    private String vertelRechtOpBonus() {
        if (heeftRechtOpBonus()) {
            return "met";
        } else {
            return "zonder";
        }
    }

    @Override
    public double berekenJaarInkomen() {
        double jaarInkomen = maandSalaris * MAANDEN_PER_JAAR;

        if (heeftRechtOpBonus()) {
            jaarInkomen += maandSalaris;
        }

        return jaarInkomen;
    }

    @Override
    public String toString() {
        return String.format("%s en is een werknemer %s recht op een bonus", super.toString(), vertelRechtOpBonus());
    }

    public void setMaandSalaris(double maandSalaris) {
        if (maandSalaris < 0) {
            throw new IllegalArgumentException("Het maandsalaris mag niet negatief zijn.");
        }
        this.maandSalaris = maandSalaris;
    }
}
