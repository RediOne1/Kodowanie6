import java.io.*;

public class SaveToFile {

    int[] naglowek, stopka;

    public SaveToFile(int naglowek[], int stopka[]) {
        this.naglowek = naglowek;
        this.stopka = stopka;
    }

    public void save(MetodaPredykcyjna metoda) {
        Pixels pixels = metoda.getNewMap();
        try {
            File file = new File(metoda.getName());
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(file));
            for (int i = 0; i < naglowek.length; i++)
                output.write(naglowek[i]);

            for (int i = 0; i < pixels.getMapWidth(); i++) {
                for (int j = 0; j < pixels.getMapHeight(); j++) {
                    // System.out.println(pixels.getColor(i,j).toString());
                    //output.write(0);output.write(255);output.write(0);//blue green red
                    if (pixels.getBlue(i, j) < 0)
                        output.write(256 + pixels.getBlue(i, j));
                    else
                        output.write(pixels.getBlue(i, j));

                    if (pixels.getGreen(i, j) < 0)
                        output.write(256 + pixels.getGreen(i, j));
                    else
                        output.write(pixels.getGreen(i, j));
                    if (pixels.getRed(i, j) < 0)
                        output.write(256 + pixels.getRed(i, j));
                    else
                        output.write(pixels.getRed(i, j));
                }
            }
            for (int i = 0; i < stopka.length; i++)
                output.write(stopka[i]);
            System.out.println("Zapisano " + metoda.getName());
            output.close();

        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku ");
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
