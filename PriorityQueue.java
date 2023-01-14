package Graph;

public class PriorityQueue {

    int n =0; ;
    pqObject[] arr;
    int rear=-1;
    int front;

    public PriorityQueue() {
        arr = new pqObject[10];
        for(int i =0; i<arr.length;i++){
            arr[i] = null;
        }
    }

    public void add(String str, int value){
        if(n != arr.length-1){
            pqObject pq = new pqObject(str, value);
            arr[n] = pq;
            front =0;
            rear = rear+1;
            n++;
        }
    }

    public pqObject remove(){
        int min =arr[0].value;
        int k=0;
        pqObject temp = null;
        if(n!=0){
            for(int i =0;i<n;i++){
                if(arr[i].value<min){
                    min = arr[i].value;
                    k = i;
                }
            }
            temp  = arr[k];
            for(int j =n-1; j>k;j++){
                arr[j-1] = arr[j];
            }
            n--;
            rear = rear-1;

        }
        return temp;
    }
    public boolean isEmpty(){
        if(n==0){
            return true;
        }
        return false;
    }


}
