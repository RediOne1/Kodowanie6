/* Schemat 8*/
public class Schemat8 extends MetodaPredykcyjna {

    public Schemat8(Pixels map) {
        super(map);
        name = "schemat8.tga";
    }

    void generateMap() {
        for (int i = 0; i < width; i++) {
            newMap.aktualizujPixel(i, 0, 0, 0, 0);
        }
        for (int i = 0; i < height; i++) {
            newMap.aktualizujPixel(0, i, 0, 0, 0);
        }
        int blue, red, green;
        for (int i = 1; i < width; i++) {
            for (int j = 1; j < height; j++) {
                if (oldMap.getBlue(i - 1, j - 1) >= max(oldMap.getBlue(i, j - 1), oldMap.getBlue(i - 1, j)))
                    blue = min(oldMap.getBlue(i, j - 1), oldMap.getBlue(i - 1, j));
                else if (oldMap.getBlue(i - 1, j - 1) <= min(oldMap.getBlue(i, j - 1), oldMap.getBlue(i - 1, j)))
                    blue = max(oldMap.getBlue(i, j - 1), oldMap.getBlue(i - 1, j));
                else
                    blue = (oldMap.getBlue(i - 1, j) + oldMap.getBlue(i, j - 1) - oldMap.getBlue(i - 1, j - 1));

                if (oldMap.getGreen(i - 1, j - 1) >= max(oldMap.getGreen(i, j - 1), oldMap.getGreen(i - 1, j)))
                    green = min(oldMap.getGreen(i, j - 1), oldMap.getGreen(i - 1, j));
                else if (oldMap.getGreen(i - 1, j - 1) <= min(oldMap.getGreen(i, j - 1), oldMap.getGreen(i - 1, j)))
                    green = max(oldMap.getGreen(i, j - 1), oldMap.getGreen(i - 1, j));
                else
                    green = (oldMap.getGreen(i - 1, j) + oldMap.getGreen(i, j - 1) - oldMap.getGreen(i - 1, j - 1));

                if (oldMap.getRed(i - 1, j - 1) >= max(oldMap.getRed(i, j - 1), oldMap.getRed(i - 1, j)))
                    red = min(oldMap.getRed(i, j - 1), oldMap.getRed(i - 1, j));
                else if (oldMap.getRed(i - 1, j - 1) <= min(oldMap.getRed(i, j - 1), oldMap.getRed(i - 1, j)))
                    red = max(oldMap.getRed(i, j - 1), oldMap.getRed(i - 1, j));
                else
                    red = (oldMap.getRed(i - 1, j) + oldMap.getRed(i, j - 1) - oldMap.getRed(i - 1, j - 1));
                newMap.aktualizujPixel(i, j,
                        oldMap.getBlue(i, j) - blue,
                        oldMap.getGreen(i, j) - green,
                        oldMap.getRed(i, j) - red);
            }
        }
        //newMap.wyswietlY();
    }

    private int max(int a, int b) {
        if (a > b)
            return a;
        return b;
    }

    private int min(int a, int b) {
        if (a < b)
            return a;
        return b;
    }
}