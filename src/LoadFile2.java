import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadFile2 {
    public LoadFile2(String filename) {
        int i = 0;
        try (BufferedInputStream is = new BufferedInputStream(new FileInputStream(filename))) {
            for (int b; (b = is.read()) != -1; ) {
                System.out.println(i + " " + b);
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
