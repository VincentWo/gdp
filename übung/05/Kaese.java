public class Kaese extends Speise{

    public Kaese(String name, int menge){
        super(name, menge);
    }

    public boolean essen(){
        return this.essen(20);
    }

    public boolean essen(int menge) {
        if(this.menge < menge){
            this.menge = 0;
            return false;
        }
        this.menge -= menge;
        return true;
    }

    @Override
    public String toString(){
        return "Kaese (" + this.name + ", " + this.menge + "g)";
    }
}
