package Graph;

public class pqObject {

    String label;
    int value;

    public pqObject(String label, int value) {
        this.label = label;
        this.value = value;
    }

    @Override
    public String toString() {
        return "pqObject{" +
                "label='" + label + '\'' +
                ", value=" + value +
                '}';
    }
}
