public class Wasser extends Getraenk{ //final class?

    public Wasser(int menge){
        super("Wasser", menge);
    }

    public boolean trinken(int menge) {
        if(this.menge < menge){
            this.menge = 0;
            return false;
        }
        this.menge -= menge;
        return true;
    }
    
}
