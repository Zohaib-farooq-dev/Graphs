package Graph;

public class Edge {
    int index;
    int value;
    Edge next;
    public Edge(){};

    public Edge(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
