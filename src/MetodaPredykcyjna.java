abstract class MetodaPredykcyjna {

    protected Pixels oldMap, newMap;
    protected int width, height;
    protected String name;

    public MetodaPredykcyjna(Pixels map) {
        this.oldMap = map;
        this.width = map.getMapWidth();
        this.height = map.getMapHeight();
        this.newMap = new Pixels(width, height);
        generateMap();
        wyswietlEntropie();
    }

    abstract void generateMap();

    public void wyswietlEntropie() {
        Entropia e = new Entropia(newMap);
        System.out.println(this.getClass().getSimpleName());
        System.out.println("Color entropy	" + e.getColorsEntropy());
        System.out.println("Red entropy		" + e.getRedEntropy());
        System.out.println("Green entropy	" + e.getGreenEntropy());
        System.out.println("Blue entropy	" + e.getBlueEntropy() + "\n");

    }

    ;

    public Pixels getNewMap() {
        return newMap;
    }

    public String getName() {
        return name;
    }

}
