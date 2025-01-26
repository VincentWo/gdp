public class Mate extends Getraenk{

    public Mate(String name) {
        super(name, 500);
    }

    public boolean trinken(){
        return this.trinken(100);
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
        return "Mate (" + this.name + ", " + this.menge + "ml)";
    }
}
