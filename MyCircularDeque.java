
public class MyCircularDeque {
    private int rear;
    private int front;
    private int count;// the number of element in the queue
    private int arr[];

    public MyCircularDeque(int k) {
        arr = new int[k];
        count = 0;
        rear = 0;
        front = -1;
    }

    public boolean isFull(){
        if (count == arr.length) return true;
        return false;
    }
    public boolean isEmpty(){
        if (count == 0) return true;
        return false;
    }
    public boolean insertFront(int key){
        if (!isFull()){
            if(front==-1){
                front =0;
            }
            else if(front ==0 ){
                front = arr.length - 1;
            }
            else {
                front--;
            }
            arr[front] = key;
            count++;
            return true;
        }
        return false;
    }
    public boolean insertLast(int key){
        if (!isFull())
        {
        if (front == -1)
        {
            front = 0;
            rear = 0;
        }
        else {
            rear++;
            rear%=arr.length;
        }

        arr[rear] = key ;
        count++;
        return true;
        }
        return false;
    }
    public boolean deleteFront(){
        if (!isEmpty()){
            if (front == rear)
            {
                front = -1;
                rear = -1;
            }
            else {
                front++;
                front %= arr.length;
            }
            count--;
            return true;
        }
        return false;
    }
    public boolean deleteLast(){
        if (!isEmpty()){
            if (front == rear)
            {
                front = -1;
                rear = -1;
            }
            else if (rear == 0)
                rear = arr.length-1;
            else
                rear = rear-1;
            count--;
            return true;
        }
        return false;
    }
    public int getFront(){
        if(!isEmpty()){
          return arr[front];
        }
        return -1;
    }
    public int getRear(){
        if(!isEmpty()){
            return arr[rear];
        }
        return -1;
    }
    

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(5);
        myCircularDeque.insertLast(1);
        myCircularDeque.insertLast(2);
        myCircularDeque.insertLast(3);
        myCircularDeque.insertLast(4);
        myCircularDeque.insertLast(5);
        myCircularDeque.deleteLast();
        myCircularDeque.insertLast(6);
        myCircularDeque.deleteLast();
        myCircularDeque.insertFront(7);
        myCircularDeque.deleteFront();
        //myCircularDeque.print();
        System.out.println(myCircularDeque.getFront());
        System.out.println(myCircularDeque.getRear());

        //myCircularDeque.print();

    }
}
