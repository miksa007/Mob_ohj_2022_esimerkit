package fi.tut.saari5.akutfirebasessa2022;

public class Aku {
    private final String TAG = "softa-Aku";
    //TODO tietueen datasisältö: konstruktorit ja get- set -metodit

    private String kirjanNumero;
    private String kirjanNimi;

    public Aku(String kirjanNumero, String kirjanNimi) {
        this.kirjanNumero = kirjanNumero;
        this.kirjanNimi = kirjanNimi;
    }

    public Aku() {

    }

    public String getKirjanNumero() {
        return kirjanNumero;
    }

    public void setKirjanNumero(String kirjanNumero) {
        this.kirjanNumero = kirjanNumero;
    }

    public String getKirjanNimi() {
        return kirjanNimi;
    }

    public void setKirjanNimi(String kirjanNimi) {
        this.kirjanNimi = kirjanNimi;
    }

    @Override
    public String toString() {
        return kirjanNumero + ". " + kirjanNimi;
    }
}
