import java.util.HashSet;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        System.err.println("\n");
        System.err.println("\n");
        System.err.println("\n");
        loadLyrics("Oh I loved you, miss.", 2000);
        pause(1800);
        loadLyrics("And you will be grieved, I swear", 3300);
        pause(550);
        loadLyrics("But I won't be blamed", 2900);
        pause(1500);
        loadLyrics("'Cause I loved you, miss", 2000);
        pause(2300);

        loadLyrics("She moans and she falls and you rarely ever see", 3300);
        loadLyrics("Just where she goes when she's not here standing next to me",
                3700);
        loadLyrics("From what I understand, it's somewhat so outlandish", 4200);
        loadLyrics("That she don't wanna be", 2500);
        loadLyrics("seeeen", 1500);

    }

    public static void pause(int millisecods) {
        try {
            Thread.sleep(millisecods);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void loadLyrics(String text, int duration) {
        long start = System.currentTimeMillis(); // Starting stopwatch for debugging.
        int chars = text.length(); // Chars for duration calculation + debugging

        int delay = duration / chars;

        for (int i = 0; i < chars; i++) {
            System.out.print(text.charAt(i));
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long end = System.currentTimeMillis();
        long result = end - start;

        // DEBUG Section

        String endStringCharsDelay = "DelayPerChar: " + delay;
        String endStringTime = "Time: " + result;
        String endStringChars = " Chars: " + chars;
        Set<String> resultString = new HashSet<>();
        resultString.add(endStringChars);
        resultString.add(endStringTime);
        resultString.add(endStringCharsDelay);

        System.out.println(" ");
        // System.out.println(resultString.toString());

    }
}
