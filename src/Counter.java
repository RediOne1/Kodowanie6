import java.util.Comparator;

public class Counter implements Comparator {
    private Color colors;
    private int color;
    private int counter;
    private double probability;

    public Counter(Color colors) {
        this.colors = colors;
        this.counter = 1;
    }

    public Counter(int color) {
        this.color = color;
        this.counter = 1;
    }

    public Counter() {
    }

    public void incremet() {
        counter = counter + 1;
    }

    public int getCounter() {
        return counter;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double p) {
        probability = p;
    }

    public Color getColor() {
        return colors;
    }

    @Override
    public boolean equals(Object t) {
        Counter temp = (Counter) t;
        //System.out.print(temp.getColor().compareTo(this.getColor()));
        if (temp.getColor().compareTo(this.getColor()) == 0)
            return true;
        return false;
    }

    @Override
    public int compare(Object arg0, Object arg1) {
        Counter p1 = (Counter) arg0;
        Counter p2 = (Counter) arg1;
        if (p1.getColor().compareTo(p2.getColor()) == 1)
            return 1;
        else if (p1.getColor().compareTo(p2.getColor()) == -1)
            return -1;
        else
            return 0;
    }
}