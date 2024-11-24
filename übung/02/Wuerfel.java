import java.util.concurrent.ThreadLocalRandom;

public class Wuerfel {
    public static void main(String[] args) {
        // Die Anzahl der Würfelseiten
        var sides = Integer.parseInt(args[0]);
        // Zum Gewinn notwendige Anzahl
        var k = Integer.parseInt(args[1]);
        // Zahl der Spiele
        var s = Integer.parseInt(args[2]);

        var random = ThreadLocalRandom.current();
        // How often the highest number was returned in a row
        var streak = 0;
        var average = 0.0;
        for (var i = 0; i < s; ++i) {
            for (var n = 0; ; ++n) {
                var side = random.nextInt(0, sides);
                if (side == sides - 1) {
                    streak++;
                    if (streak == k) {
                        average += ((float) n + 1.0)/s;
                        break;
                    }
                } else {
                    streak = 0;
                }
            }
        }
        System.out.println(average);
    }
}
