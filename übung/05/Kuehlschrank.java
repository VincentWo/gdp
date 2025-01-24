public class Kuehlschrank
{
    private Lebensmittel[] kuehlschrank;
    private int artikel;

    public Kuehlschrank(int size)
    {
        kuehlschrank = new Lebensmittel[size];
        artikel = 0;
    }

    public void einkaufen()
    {
        kuehlschrank[artikel++] = new Mate("Club Mate");
        kuehlschrank[artikel++] = new Brot(1, 750);
        kuehlschrank[artikel++] = new Wasser("Sprudel", 250);
        kuehlschrank[artikel++] = new Mate("Flora Power");
        kuehlschrank[artikel++] = new Brot(3, 1000);
        kuehlschrank[artikel++] = new Kaese("Parmesan", 200);
        kuehlschrank[artikel++] = new Wasser("Still", 1500);
    }

    public void auflisten()
    {
        for (int i = 0; i < artikel; i++)
        {
            System.out.println(kuehlschrank[i]);
        }
    }

    public void verbrauchen()
    {
        for (int i = 0; i < artikel; i++)
        {
            if (kuehlschrank[i].essen())
            {
                System.out.println("Essen: " + kuehlschrank[i]);
            }
            if (kuehlschrank[i].trinken())
            {
                System.out.println("Trinken: " + kuehlschrank[i]);
            }
        }
    }

    public static void main(String argv[])
    {
        Kuehlschrank kschrank = new Kuehlschrank(10);
        kschrank.einkaufen();
        kschrank.auflisten();
        kschrank.verbrauchen();
    }
}