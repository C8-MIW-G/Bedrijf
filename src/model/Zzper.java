package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Een persoon die niet in loondienst is maar incidenteel wordt ingehuurd.
 */
public class Zzper extends Persoon implements Oproepbaar {
    private double uurtarief;
    private int urenGewerkt;

    public Zzper(String naam, String woonplaats, Afdeling afdeling, double uurtarief) {
        super(naam, woonplaats, afdeling);
        this.uurtarief = uurtarief;
        this.urenGewerkt = 0;
    }

    @Override
    public void huurIn(int uren) {
        this.urenGewerkt += uren;
    }

    @Override
    public double berekenJaarInkomen() {
        return uurtarief * urenGewerkt;
    }

    @Override
    public String toString() {
        return String.format("%s en is een zzp-er met een uurtarief van %.2f", super.toString(), this.uurtarief);
    }

    public double getUurtarief() {
        return uurtarief;
    }

    public void setUurtarief(double uurtarief) {
        this.uurtarief = uurtarief;
    }

    public int getUrenGewerkt() {
        return urenGewerkt;
    }

    public void setUrenGewerkt(int urenGewerkt) {
        this.urenGewerkt = urenGewerkt;
    }
}
