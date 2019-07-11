package vapasi.share;

public class Investment {

    private String name;
    private int value;
    private int noOfShares;

    public Investment(String name, int value, int noOfShares) {
        this.name = name;
        this.value = value;
        this.noOfShares = noOfShares;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public int getNoOfShares() {
        return noOfShares;
    }

    @Override
    public String toString() {
        return "Investment{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", noOfShares=" + noOfShares +
                '}';
    }
}
