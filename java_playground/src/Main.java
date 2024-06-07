import java.text.Normalizer;

public class Main {
    public static void main(String[] args) {
        String slovoprikazu = "Ahojda, já jsem jiří král a dneska jsem společně se svým bratrem stvořil Žetko.";
        String normalizer = Normalizer.normalize(slovoprikazu, Normalizer.Form.NFD);
        String ascii = normalizer.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        System.out.println(ascii);
        String checker = "Ahojda, ja jsem jiri kral a dneska jsem spolecne se svym bratrem stvoril Zetko";
        String test1 = "Ahojda, ja jsem jiri kral a dneska jsem spolecne se svym bratrem stvoril Zetko";
        if (ascii.contains(checker)) {
            System.out.println("Dobre to jede");
        } else {
            System.out.println("Nejde to");
        }
    };
}
