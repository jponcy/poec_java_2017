import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

/** Reads value from file then change it with complex algo.  */
public class P3_42 {
    private static final String filePath = "/tmp/store_poec_java.txt";

    public static void main(String[] args) {
        System.out.println("Run 42");
        int number = 42;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            number = Integer.parseInt(br.readLine()); // Only first line has data.
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-5);
        }

        number = (number == 42) ? 4242 : 42;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("" + number);
            // bw.write(String.format("%d", number));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
