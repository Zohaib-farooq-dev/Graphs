package Graph;

public class Main {
    public static void main(String[] args) {
//        Graphs graph = new Graphs();
//
//        graph.insertVertex("a");
//        graph.insertVertex("b");
//        graph.insertVertex("c");
//        graph.insertVertex("d");
//
//
//
//        graph.insertWeightedEdge("b","b",70);
//        graph.insertWeightedEdge("a","c",60);
//        graph.insertWeightedEdge("a","b",50);
//        graph.insertWeightedEdge("c","d",40);
//       graph.insertWeightedEdge("a","d",30);
//       graph.insertWeightedEdge("b","d",20);
//        graph.insertWeightedEdge("c","b",10);
//        graph.insertWeightedEdge("d","a",80);
//        graph.insertWeightedEdge("b","c",5);
//
//        graph.dijkstrasAlgorithm(graph, "a");
//
//        System.out.println();
//        for(int i=0; i<graph.distance.length;i++){
//            System.out.print(graph.distance[i] + "  ");
//        }
//        System.out.println();
//        for(int i=0; i<graph.parent.length;i++){
//            System.out.print(graph.parent[i] + "  ");
//        }
//        System.out.println();
        //for(int i=0;i<graph.n; i++){
//            System.out.print(graph.vertices[i].label + "   ");
//        }

//        graph.BFS(graph,"c");
//        System.out.println();
//        graph.DFS(graph,"c");
//
//        if(graph.isPath("c","d")){
//            System.out.println("Path exists ");
//        }
//        if(graph.isConnected("a")){
//            System.out.println("Graph is Connected");
//        }
//        if(graph.isAdjacent("a","c")){
//            System.out.println("Vertices are adjacent");
//        }


//        System.out.println();
//        for(int i=0;i<graph.adjMatrix.length; i++){
//            for(int j=0; j<graph.adjMatrix[i].length; j++){
//                System.out.print(graph.adjMatrix[i][j] + "   ");
//            }
//            System.out.println();
//        }

        Graph2 graph = new Graph2();
        graph.insertVertex("a");
        graph.insertVertex("b");
        graph.insertVertex("c");
        graph.insertVertex("d");

        for(int i=0;i<graph.n; i++){
            System.out.print(graph.vertices[i].label + "   ");
        }
        System.out.println();

        graph.insertEdge("a","b",60);
        graph.insertEdge("a","c",50);
        graph.insertEdge("b","b",70);

        for(int i=0; i<graph.adjlist.length-1; i++){
            Edge ptr = graph.adjlist[i].next;
            System.out.print(graph.adjlist[i].label + ":"+"    ");
            while(ptr!=null){
                System.out.print(ptr.value + "   ");
                ptr = ptr.next;
            }
            System.out.println();
        }
        graph.deleteEdge("b","b");
        //printing after deleting the edge
        for(int i=0; i<graph.adjlist.length-1; i++){
            Edge ptr = graph.adjlist[i].next;
            System.out.print(graph.adjlist[i].label + ":"+"    ");
            while(ptr!=null){
                System.out.print(ptr.value + "   ");
                ptr = ptr.next;
            }
            System.out.println();
        }

        if(graph.isEdge("a","b")){
            System.out.println("Edge exists  between the two vertices");
        }
        System.out.println(graph.outEdges("a"));
        graph.insertEdge("c","a", 50);
        System.out.println(graph.inEdge("a"));

        graph.deleteVertex("a");
        //print adjlist after deleting vertex to check whether in and out edges of that vetex is deleted or not
        for(int i=0; i<graph.adjlist.length-1; i++){
            Edge ptr = graph.adjlist[i].next;
            System.out.print(graph.adjlist[i].label + ":"+"    ");
            do {
                if(ptr!=null) {
                    System.out.print(ptr.value + "   ");
                    ptr = ptr.next;
                }

            }while(ptr!=null);
            System.out.println();
        }
        //print vertices list after deleting vertex a
        for(int i =0;i<graph.vertices.length-1;i++){
            if(graph.vertices[i] !=null){
                System.out.println(graph.vertices[i].label);
            }else{
                System.out.println("null");
            }

        }



    }
}
