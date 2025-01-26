public abstract class Getraenk extends Lebensmittel{

    public Getraenk(String name, int menge){
        super(name, menge);
    }

    public boolean essen(int Menge) {
        return false;
    }

    public boolean essen() {
        return false;
    }

    public abstract boolean trinken(int Menge);

    public abstract boolean trinken();
}
