public abstract class Speise extends Lebensmittel{

    public Speise(String name, int menge){
        super(name, menge);
    }

    public abstract boolean essen(int Menge);

    public boolean trinken(int Menge) {
        return false;
    }
}
