public abstract class Getraenk extends Lebensmittel{

    public Getraenk(String name, int menge){
        super(name, menge);
    }

    public boolean essen(int Menge) {
        return false;
    }
    public abstract boolean trinken(int Menge);
}
