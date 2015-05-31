public class Color implements Comparable<Color> {
    private int r, g, b;

    public Color(int b, int g, int r) {
        this.b = b;
        this.g = g;
        this.r = r;
    }

    public String toString() {
        return b + ":" + g + ":" + r;
    }

    public int getBlue() {
        return b;
    }

    public int getGreen() {
        return g;
    }

    public int getRed() {
        return r;
    }

    @Override
    public int compareTo(Color o) {
        final int lower = -1;
        final int upper = 1;
        final int equal = 0;
        int a = this.b * 1024 * 1024 + this.g * 1024 + this.r;
        int b = o.getBlue() * 1024 * 1024 + o.getGreen() * 1024 + o.getRed();
        if (a > b)
            return upper;
        else if (a < b)
            return lower;
        else
            return equal;
    }


}
