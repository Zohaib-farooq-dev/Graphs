package Graph;

public class Graph2 {

    // Graph using adjacency list

    int n =0;
    Vertex1[] vertices = new Vertex1[5];
    Vertex1[] adjlist= new Vertex1[5];
    public Graph2() {
        for(int i =0; i<adjlist.length; i++){
            adjlist[i] = new Vertex1();
        }
    }

    public boolean  insertVertex(String str){
        Vertex1 vrt = new Vertex1(str);

        if(n!= vertices.length){
            for(int i=0;i<vertices.length;i++){
                if(vertices[i] == null){
                    vertices[i] = vrt;
                    adjlist[i] =vrt;
                    n++;
                    return true;
                }
            }
        }

        return false;
    }

    public int search( String str){

        for(int i=0; i<vertices.length;i++){
            if(vertices[i].label.equals(str)){
                return i;
            }
        }
        return -1;
    }
    public boolean insertEdge(String start,String end, int value){
        int i = search(start);
        int j = search(end);
        Edge edge = new Edge(j,value);
        if(i>=0&& j>=0){
            Edge temp = adjlist[i].next;
            edge.next = temp;
            adjlist[i].next = edge;
            return true;
        }
        return false;
    }
    public boolean  deleteEdge(String start,String end){
        int i = search(start);
        int j = search(end);
        Edge ptr = adjlist[i].next;
        Edge curr = null;
        if(ptr == null){
            return false;
        } else if(ptr.next == null){
            adjlist[i].next = null;
            return true;
        } else{
           while(ptr.next!=null){
               curr = ptr;
               if(ptr.index == j){
                   curr.next = ptr.next;
               }
               ptr = ptr.next;
            }
            return true;
        }
    }
    public boolean isEdge(String start, String end){

        int i =search(start);
        int j = search(end);
        Edge ptr = adjlist[i].next;
       while(ptr!= null){
           if(ptr.index == j){
               return true;
           }
           ptr = ptr.next;
       }
        return false;
    }
    public int outEdges(String str){
        int count = 0;
        int i = search(str);
        Edge ptr = adjlist[i].next;
        while(ptr!=null){
            count++;
            ptr = ptr.next;
        }
        return count;
    }

    public int inEdge(String str){
        int count =0;
        int i = search(str);
       for(int j =0;j< adjlist.length; j++){
           Edge ptr = adjlist[j].next;
           while(ptr!=null){
               if(ptr.index == i){
                   count++;
               }
               ptr = ptr.next;
           }
       }
       return count;
    }
    public void deleteVertex(String str) {
        int i = search(str);
        Edge curr = null;
        adjlist[i].next = null;
        for (int j = 0; j < adjlist.length; j++) {
            Edge ptr = adjlist[j].next;
            while (ptr != null) {
                if (ptr.next == null) {
                    adjlist[j].next = null;
                } else if (ptr.next != null) {
                    curr = ptr;
                    if (ptr.index == i) {
                        curr.next = ptr.next;
                    }
                }
                ptr = ptr.next;
            }
        }
        vertices[i] = null;
    }
}
