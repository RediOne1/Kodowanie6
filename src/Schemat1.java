/* Schemat 1 - |X| = W*/
public class Schemat1 extends MetodaPredykcyjna {

    public Schemat1(Pixels map) {
        super(map);
        name = "schemat1.tga";
        //oldMap.wyswietlX();
    }

    void generateMap() {
        for (int i = 0; i < height; i++) {
            newMap.aktualizujPixel(0, i, 0, 0, 0);
        }
        for (int i = 0; i < height; i++) {
            for (int j = 1; j < width; j++) {
                newMap.aktualizujPixel(j, i,
                        oldMap.getBlue(j, i) - oldMap.getBlue(j - 1, i),
                        oldMap.getGreen(j, i) - oldMap.getGreen(j - 1, i),
                        oldMap.getRed(j, i) - oldMap.getRed(j - 1, i));
            }
        }
        //newMap.wyswietlY();
    }

}
