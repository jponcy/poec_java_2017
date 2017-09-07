import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/** Generates a random value then store it to file. */
public class P1Writer {
    private static final String filePath = "/tmp/store_poec_java.txt";

    public static void main(String[] args) {
        System.out.println("Run writer");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            int number = (new Random()).nextInt(10000000);
            // number = 42;
            System.out.println("Write: " + number);
            bw.write("" + number);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
