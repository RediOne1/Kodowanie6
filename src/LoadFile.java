import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadFile {
    private int height, width, numOfPixels, numOfBytes;
    private Pixels pixels;
    private int naglowek[] = new int[18];
    private int stopka[] = new int[26];

    public LoadFile(String filename) {
        int i = 0;
        int R, G, B = 0;

        try (BufferedInputStream is = new BufferedInputStream(new FileInputStream(filename))) {
            for (int b; (b = is.read()) != -1; ) {
                if (i < 18)
                    naglowek[i] = b;
                if (i == 12) {
                    int temp = b;
                    b = is.read();
                    i++;
                    naglowek[i] = b;
                    width = 256 * b + temp;
                }
                if (i == 14) {
                    int temp = b;
                    b = is.read();
                    i++;
                    naglowek[i] = b;
                    height = 256 * b + temp;
                    numOfPixels = width * height;
                    numOfBytes = 3 * numOfPixels;
                    //System.out.println("Stworzono mape sz. x wys. " + width + " x "+ height);
                    pixels = new Pixels(width, height);
                    //System.out.println("Liczba pixeli: "+ numOfPixels + "*3 " + numOfBytes);
                }
                if (i >= 17 && i < numOfPixels) {
                    int k = 0;
                    for (k = 0; k < numOfPixels; k++) {
                        B = is.read();
                        G = is.read();
                        R = is.read();
                        pixels.aktualizujPixel(k % width, k / width, B, G, R);
                        //System.out.println(pixels.getColor(k%width, k/width).toString());
                        //System.out.println("Dodano pixel " + k + " " + k%width + " x " + k/width + " " + width + " " + height);
                        //System.out.println(i + " " + (i+2)+" "+ R + " "  + G + " " + B);
                        i = i + 3;
                        //System.out.println(k + " " + R + " " + G + " " + B);
                    }
                    //System.out.println("NAG��WEK");
                    //for (k = 0; k < 18; k++) {
                    //	System.out.println(k + " " + naglowek[k]);
                    //}
                    //System.out.println("KONIEC STOPKI");
                    //System.out.println("STOPKA");
                    for (k = 0; k < 26; k++) {
                        stopka[k] = is.read();
                        //	System.out.println(k + " " + stopka[k]);
                    }
                    //System.out.println("KONIEC STOPKI");
                    //
                    //pixele.add(new Color(R, G, B));

                }
               /* String s = Integer.toBinaryString(b);
                while (s.length() != 8) {
                    s = '0' + s;
                }*/

                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Wysokosc:" + height + " Szerokosc:" + width);
        //pixels.wyswielt();
        //System.out.println(pixele.size());
    }

    public Pixels getPixelsMap() {
        return pixels;
    }

    public int getMapHeight() {
        return height;
    }

    public int getMapWidth() {
        return width;
    }

    public int[] getNaglowek() {
        return naglowek;
    }

    public int[] getStopka() {
        return stopka;
    }

}
