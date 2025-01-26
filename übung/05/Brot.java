public class Brot extends Speise{

    //Workaround, da keine Manipulationen in Konstruktor vor Konstruktion geschehen duerfen,
    //aber name in Lebensmittel final ist
    private static String typename(int type){
        if(type == 0){
            return "Weißbrot";
        }
        if(type == 1){
            return "Schwarzbrot";
        }
        if(type == 2){
            return "Mischbrot";
        }
        return "Spezialbrot";
    }

    public Brot(int type, int menge){
        super(typename(type), menge);
    }

    public boolean essen(){
        return this.essen(50);
    }

    public boolean essen(int menge){
        if(this.menge < menge){
            this.menge = 0;
            return false;
        }
        this.menge -= menge;
        return true;
    }

    @Override
    public String toString(){
        return "Brot (" + this.name + ", " + this.menge + "g)";
    }
}
