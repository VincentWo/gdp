public abstract class Lebensmittel 
{
    private final String name;
    protected int menge; // in Milliliter bzw. Gramm

    public Lebensmittel(String name, int menge) {
        this.name = name;
        this.menge = menge;
    }

    public abstract boolean essen(int Menge);

    public abstract boolean trinken(int Menge);

    public String toString() {
        return "Lebensmittel";
    }
}