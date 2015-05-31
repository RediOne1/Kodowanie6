/* Schemat 2 - |X| = N*/
public class Schemat2 extends MetodaPredykcyjna {

    public Schemat2(Pixels map) {
        super(map);
        name = "schemat2.tga";
        //oldMap.wyswietlX();
    }

    void generateMap() {
        for (int i = 0; i < width; i++) {
            newMap.aktualizujPixel(i, 0, 0, 0, 0);
        }
        for (int i = 0; i < width; i++) {
            for (int j = 1; j < height; j++) {
                newMap.aktualizujPixel(i, j,
                        oldMap.getBlue(i, j) - oldMap.getBlue(i, j - 1),
                        oldMap.getGreen(i, j) - oldMap.getGreen(i, j - 1),
                        oldMap.getRed(i, j) - oldMap.getRed(i, j - 1));
            }
        }
        //newMap.wyswietlX();

    }

}

