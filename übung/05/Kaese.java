public class Kaese extends Speise{

    public Kaese(String name, int menge){
        super(name, menge);
    }

    public boolean essen(int menge) {
        if(this.menge < menge){
            this.menge = 0;
            return false;
        }
        this.menge -= menge;
        return true;
    }
}
