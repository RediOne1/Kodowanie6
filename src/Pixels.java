public class Pixels {
    private Color mapaKolorow[][];
    private int red[][];
    private int blue[][];
    private int green[][];
    private int width, height;

    public Pixels(int x, int y) {
        this.mapaKolorow = new Color[x][y];
        this.blue = new int[x][y];
        this.green = new int[x][y];
        this.red = new int[x][y];
        this.width = x;
        this.height = y;
    }

    public void aktualizujPixel(int x, int y, int b, int g, int r) {
        int k, l, m;
        k = b;
        l = g;
        m = r;
        if (k < 0)
            k = k + 1024;
        if (l < 0)
            l = l + 1024;
        if (m < 0)
            m = m + 1024;
        if (k < 0 || l < 0 || m < 0)
            System.out.println("BŁĄÐ" + k + " " + b + " " + l + " " + m);
        mapaKolorow[x][y] = new Color(k, l, m);
        blue[x][y] = k;
        green[x][y] = l;
        red[x][y] = m;

    }


    public int getMapHeight() {
        return height;
    }

    public int getMapWidth() {
        return width;
    }

    public Color[][] getMapColor() {
        return mapaKolorow;
    }

    public Color getColor(int x, int y) {
        return mapaKolorow[x][y];
    }

    public int getRed(int x, int y) {
        return red[x][y];
    }

    public int getGreen(int x, int y) {
        return green[x][y];
    }

    public int getBlue(int x, int y) {
        return blue[x][y];
    }


    public void wyswietlX() {
        //System.out.println(width + " " + height);
        //System.out.println(mapaKolorow[159][199].toString());
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.println(i + " " + j + " " + mapaKolorow[i][j].toString());
            }
        }
    }

    public void wyswietlY() {
        //System.out.println(width + " " + height);
        //System.out.println(mapaKolorow[159][199].toString());
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.println(j + " " + i + " " + mapaKolorow[j][i]);
            }
        }
    }
}
