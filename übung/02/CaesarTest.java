public class CaesarTest {

    @org.junit.Test
    public void caesar() {
        String[][] tests = {
            { "Hello World!", "Khoor Zruog!"},
            { "Bla, Bla, Bla.", "Eod, Eod, Eod."},
        };

        for (var test : tests) {
            assert test[1].equals(Caesar.caesar(3, test[0]));
        }

    }
}