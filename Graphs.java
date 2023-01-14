package Graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Graphs {
    int n =0;
    Vertex[] vertices = new Vertex[5];
    int[][] adjMatrix = new int[5][];
    boolean[] visited;
    int[] distance;
    String[] parent;
    Graph.PriorityQueue q;


    public Graphs() {
        for(int i=0; i<adjMatrix.length; i++) {
            adjMatrix[i] = new int[5];
        }

    }

    public boolean  insertVertex(String str){
        Vertex vrt = new Vertex(str);

        if(n!= vertices.length){
            for(int i=0;i<vertices.length;i++){
                if(vertices[i] == null){
                    vertices[n] = vrt;
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

    public boolean insertUnweightedEdge( String start, String end ){


        int i = search(start);
        int j = search(end);

        if(i>0 && j>0){

            adjMatrix[i][j] =1;
        }
        return false;
    }

    public boolean insertWeightedEdge( String start, String end, int value ){
        int i = search(start);
        int j = search(end);

        if(i>=0 && j>=0){
            adjMatrix[i][j]=value;
            return true;
        }
        return false;
    }

    public void deleteEdges(String start , String end ){
        int i = search(start);
        int j = search(end);
        if(i>0 && j>0){
            adjMatrix[i][j] =0;
        }

    }

    public int outEdges(String str){
        int count =0;
        int i = search(str);
        for(int j =0;j<adjMatrix[i].length; j++){
            if(adjMatrix[i][j] !=0){
                count++;
            }
        }
        return count;
    }

    public int inEdges(String str){
        int count =0;
        int j= search(str);
        for(int i =0 ;i<adjMatrix[j].length; i++){
            if(adjMatrix[i][j] !=0){
                count++;
            }

        }
        return count;
    }

    public void deleteVertex(String v){
        int i = search(v);
        for(int j =0;j<adjMatrix[i].length; j++){
            if(adjMatrix[i][j] !=0){
                adjMatrix[i][j] =0;
            }
        }
        for(int k =0 ;k<adjMatrix[i].length; k++){
            if(adjMatrix[k][i] !=0){
                adjMatrix[k][i] =0;
            }
        }
        vertices[i] = null;
    }

    public boolean isEdge(String start, String end){
        int i = search(start);
        int j = search(end);

        if(adjMatrix[i][j] !=0){
            return true;
        }
        return false;

    }
    public void print(String str){
        System.out.print(str + "  ");
    }
    public void BFS( Graphs g,String start ){
        visited = new boolean[n];
        Queue<String> queue = new LinkedList<>();
        for(int i=0; i<n;i++){
            visited[i] = false;
        }
        visited[search(start)] = true;
        queue.add(start);
        while(!queue.isEmpty()){
            String u = queue.remove();
            print(u);
            int k= search(u);
            for(int j = 0; j< adjMatrix[k].length;j++){
                if(adjMatrix[k][j]!=0){
                    if(!visited[j]){
                        visited[j] = true;
                        queue.add(vertices[j].label);
                    }
                }
            }
        }
    }

    public void DFS(Graphs g, String start){
         visited = new boolean[n];
        Stack<String> s = new Stack<>();
        for(int i=0; i<n;i++){
            visited[i] = false;
        }
        visited[search(start)] = true;
        s.push(start);
        while(!s.isEmpty()){
            String u = s.pop();
            print(u);
            int k= search(u);
            for(int j = 0; j< adjMatrix[k].length;j++){
                if(adjMatrix[k][j]!=0){
                    if(!visited[j]){
                        visited[j] = true;
                        s.push(vertices[j].label);
                    }
                }
            }
        }
    }
    public boolean isAdjacent(String start, String end){
        int i = search(start);
        int j = search(end);

        if(adjMatrix[i][j] !=0){
            return true;
        }
        return false;
    }
    public boolean isVisited(String str){
        if(visited[search(str)]){
            return true;
        }
        return false;
    }
    public boolean isPath(String start, String end){
        visited = new boolean[n];
        Queue<String> queue = new LinkedList<>();
        for(int i=0; i<n;i++){
            visited[i] = false;
        }
        visited[search(start)] = true;
        queue.add(start);
        while(!queue.isEmpty()){
            String u = queue.remove();
            int k= search(u);
            for(int j = 0; j< adjMatrix[k].length;j++){
                if(adjMatrix[k][j]!=0){
                    if(!visited[j]){
                        visited[j] = true;
                        queue.add(vertices[j].label);
                    }
                }
            }
        }
        if(!visited[search(end)]){
            return false;
        }
        return true;
    }
    public boolean isConnected(String start){
        visited= new boolean[n];
        Queue<String> queue = new LinkedList<>();
        for(int i=0; i<n;i++){
            visited[i] = false;
        }
        visited[search(start)] = true;
        queue.add(start);
        while(!queue.isEmpty()){
            String u = queue.remove();
            int k= search(u);
            for(int j = 0; j< adjMatrix[k].length;j++){
                if(adjMatrix[k][j]!=0){
                    if(!visited[j]){
                        visited[j] = true;
                        queue.add(vertices[j].label);
                    }
                }
            }
        }
        for(int i =0; i<visited.length; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
    public void dijkstrasAlgorithm(Graphs g, String start){

        distance = new int[n];
        parent = new String[n];
        q = new Graph.PriorityQueue();
        for(int i =0; i<n ; i++){
            distance[i] = Integer.MAX_VALUE;
            parent[i] = null;
        }
        int k = search(start);
        distance[k] = 0;
        parent[k] = null;
        q.add(start,distance[k]);
        while(!q.isEmpty()){
            pqObject pq = q.remove();
            int t = search(pq.label);
            for(int j =0; j<adjMatrix[t].length;j++){
                if(adjMatrix[t][j]!=0){
                    if(distance[search(vertices[j].label)] > distance[t] + adjMatrix[t][j] ){
                        distance[j] = distance[t] + adjMatrix[t][j];
                        parent[j] = vertices[t].label;
                        q.add(vertices[j].label,distance[j]);
                    }
                }
            }
        }

    }
}
