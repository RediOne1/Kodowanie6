/* Schemat 6 - |X| = W+(N-NW)/2*/
public class Schemat6 extends MetodaPredykcyjna {

    public Schemat6(Pixels map) {
        super(map);
        name = "schemat6.tga";
    }

    void generateMap() {
        for (int i = 0; i < width; i++) {
            newMap.aktualizujPixel(i, 0, 0, 0, 0);
        }
        for (int i = 0; i < height; i++) {
            newMap.aktualizujPixel(0, i, 0, 0, 0);
        }
        for (int i = 1; i < width; i++) {
            for (int j = 1; j < height; j++) {
                newMap.aktualizujPixel(i, j,
                        oldMap.getBlue(i, j) - (oldMap.getBlue(i - 1, j) + (oldMap.getBlue(i, j - 1) - oldMap.getBlue(i - 1, j - 1)) / 2),
                        oldMap.getGreen(i, j) - (oldMap.getGreen(i - 1, j) + (oldMap.getGreen(i, j - 1) - oldMap.getGreen(i - 1, j - 1)) / 2),
                        oldMap.getRed(i, j) - (oldMap.getRed(i - 1, j) + (oldMap.getRed(i, j - 1) - oldMap.getRed(i - 1, j - 1)) / 2));
            }
        }
        //newMap.wyswietlY();

    }

}