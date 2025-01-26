public class Wasser extends Getraenk{ //final class?

    public Wasser(String name, int menge){
        super(name, menge);
    }

    public boolean trinken(){
        return this.trinken(200);
    }

    public boolean trinken(int menge) {
        if(this.menge < menge){
            this.menge = 0;
            return false;
        }
        this.menge -= menge;
        return true;
    }


    @Override
    public String toString(){
        return "Wasser (" + this.name + ", " + this.menge + "ml)";
    }
}
