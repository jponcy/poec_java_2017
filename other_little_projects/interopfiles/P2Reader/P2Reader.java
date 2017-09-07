import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/** Reads then prints value from file. */
public class P2Reader {
    private static final String filePath = "/tmp/store_poec_java.txt";

    public static void main(String[] args) {
        System.out.println("Run reader");

        /*
        // Old version.
        Reader r;
        BufferedReader br;

        try {
            r = new FileReader(filePath);
            br = new BufferedReader(r);

            // process
        } catch (IOException e) {
        } finally {
            if (r != null && r.open()) {
                if (br != null && br.open()) {
                    br.close();
                }

                r.close();
            }
        }
        */

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int number = Integer.parseInt(br.readLine()); // Only first line has data.
            System.out.println(number);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
