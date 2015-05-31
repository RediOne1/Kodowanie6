import java.util.ArrayList;
import java.util.Collections;

public class Entropia {

    private Pixels pixels;
    private int width, height;

    public Entropia(Pixels pixels) {
        this.pixels = pixels;
        this.width = pixels.getMapWidth();
        this.height = pixels.getMapHeight();
        //getColorsEntropy();
    }


    @SuppressWarnings("unchecked")
    public double getColorsEntropy() {
        ArrayList<Counter> counter = new ArrayList<Counter>();
        Color temp[][] = pixels.getMapColor();
        int k = 0;
        //System.out.print(new Counter(new Color(0,0,0)).equals(new Counter(new Color(0,0,0))));
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                counter.add(new Counter(temp[i][j]));
            }
        }
        Collections.sort(counter, new Counter(new Color(0, 0, 0)));
        ArrayList<Counter> counter2 = new ArrayList<Counter>();
        counter2.add(counter.get(0));
        double entropia = 0.0;
        for (int i = 1; i < counter.size(); i++) {
            //System.out.print( "\n" + counter.get(i).getColor().toString());
            if (counter.get(i - 1).equals(counter.get(i))) {
                //System.out.println(" inkrementacja " + counter2.get(counter2.size()-1).getColor().toString() + " " +counter2.get(counter2.size()-1).getCounter());
                counter2.get(counter2.size() - 1).incremet();
            } else {
                //System.out.println(" Stat: " + counter2.get(counter2.size()-1).getColor().toString() + " " +counter2.get(counter2.size()-1).getCounter());
                //System.out.println(" dodano nowy");
                counter2.add(counter.get(i));
            }
        }
        for (int i = 0; i < counter2.size(); i++) {
            //System.out.println(counter2.get(i).getColor().toString() + " " + counter2.get(i).getCounter());
            counter2.get(i).setProbability((double) counter2.get(i).getCounter() / (width * height));
            //	System.out.println(counter2.get(i).getColor() + " " +counter2.get(i).getProbability() + " " + counter2.get(i).getProbability() * log2(counter2.get(i).getProbability()));
            entropia = entropia + counter2.get(i).getProbability() * log2(counter2.get(i).getProbability());
        }
        //System.out.println("Entropia " + -entropia);
        return -entropia;

    }

    public double getRedEntropy() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                //System.out.println(pixels.getRed(i,j));
                list.add(pixels.getRed(i, j));
            }
        }
        int counter[] = new int[1024];
        for (int i = 0; i < counter.length; i++)
            counter[i] = 0;
        for (int i = 0; i < list.size(); i++) {
            //System.out.println(list.get(i));
            counter[list.get(i)] += 1;

        }
        //return 0.0;
        return -liczEntropie(policzPrawdopodobienstwo(counter));
    }

    public double getGreenEntropy() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                list.add(pixels.getGreen(i, j));
            }
        }
        int counter[] = new int[1024];
        for (int i = 0; i < counter.length; i++)
            counter[i] = 0;
        for (int i = 0; i < list.size(); i++)
            counter[list.get(i)] += 1;
        return -liczEntropie(policzPrawdopodobienstwo(counter));
    }

    public double getBlueEntropy() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                list.add(pixels.getBlue(i, j));
            }
        }
        int counter[] = new int[1024];
        for (int i = 0; i < counter.length; i++)
            counter[i] = 0;
        for (int i = 0; i < list.size(); i++)
            counter[list.get(i)] += 1;
        return -liczEntropie(policzPrawdopodobienstwo(counter));
    }

    public double liczEntropie(double[] prawd) {
        double result = 0.0;
        for (int i = 0; i < prawd.length; i++)
            if (prawd[i] != 0.0)
                result += prawd[i] * log2(prawd[i]);

        return result;
    }

    public double log2(double x) {
        return Math.log(x) / Math.log(2);
    }


    public double[] policzPrawdopodobienstwo(int[] counter) {
        double result[] = new double[1024];
        for (int i = 0; i < counter.length; i++) {
            result[i] = (double) counter[i] / (double) (width * height);
        }
        return result;
    }
}
