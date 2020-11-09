import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        RecentRequestCounter recentCounter = new RecentRequestCounter();
        System.out.println(recentCounter.ping(1)); // requests = [1], range is [-2999,1], return 1
        System.out.println(recentCounter.ping(100)); // requests = [1, 100], range is [-2900,100], return 2
        System.out.println(recentCounter.ping(3001));// requests = [1, 100, 3001], range is [1,3001], return 3
        System.out.println(recentCounter.ping(3002)); // requests = [1, 100, 3001, 3002], range is [2,3002],
        System.out.println(recentCounter.requests.toString());
    }
}
class RecentRequestCounter{
    public CircularDeque requests = new CircularDeque();
    public void ResetCounter(){
        requests.clear();
    }
    public int ping(int time) throws Exception {
        int counter = 0;
          requests.insertLast(time);
        CircularDeque circularDeque = new CircularDeque();
        while (!requests.isEmpty()&&time-3000<=requests.getLast()){
            int i = requests.deleteLast();
            circularDeque.insertFront(i);
            counter++;
        }


        while (!circularDeque.isEmpty()){
            requests.insertLast(circularDeque.deleteFront());
        }
        return counter;
    }

}
class CircularDeque{
    private LinkedList<Integer> linkedList;

    public CircularDeque() {
        linkedList = new LinkedList<>();
    }
    public boolean isEmpty(){
        return linkedList.isEmpty();
    }
    public void insertLast(int key){
        linkedList.add(key);
    }
    public void insertFront(int key){linkedList.add(0,key);}
    public int deleteFront() throws Exception {
        if(!isEmpty()){
            int a = linkedList.get(0);
            linkedList.remove(0);
            return a;
        }
        throw new Exception("Queue is Empty");
    }
    public int deleteLast() throws Exception {
        if(!isEmpty()){
            int a = linkedList.get(linkedList.size()-1);
            linkedList.remove(linkedList.size()-1);
            return a;
        }
        throw new Exception("Queue is Empty");
    }
    public int getLast(){
        return linkedList.get(linkedList.size()-1);
    }
    public void clear(){
        linkedList.clear();
    }
    @Override
    public String toString() {
        return "CircularDeque{" +
                "linkedList=" + linkedList +
                '}';
    }
}
