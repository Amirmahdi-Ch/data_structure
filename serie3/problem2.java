import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {
    public  int findIndex(char chars[], char t)
    {
        for(int i = chars.length-1;i>=0;i--){
            if (chars[i]==t){
                return i;
            }
        }
        return -1;

    }
    public int findFreeSpace(char chars[]){
        for(int i = 0;i<chars.length;i++){
            if (!(chars[i]>='A'&&chars[i]<='z')){
                return i;
            }
        }
        return -1;
    }
    public int findLastElement(char chars[]){
        for (int i = chars.length-1;i>=0;i--){
            if (chars[i]>='A'&&chars[i]<='z'){
                return i;
            }
        }
        return -1;
    }

    public int getTime(char[] arr,int t) throws Exception {
        Queue queue1 = new Queue();
        ArrayList<Character> characters = new ArrayList<>();
        for (char a : arr){
            characters.add(a);
        }
        characters.sort(Comparator.comparingInt(i-> Collections.frequency(characters, i)).reversed());
        char[] array = new char[t*arr.length + arr.length];
        for (char a : characters){
            queue1.insert(a);
        }
        while (!queue1.isEmpty()){
            char c = queue1.delete();
            int index = findIndex(array,c);

            if(index!=-1){
                index+=t+1;
            }
            else{
             index = findFreeSpace(array);
            }
            array[index] = c;
        }
        return findLastElement(array)+1;
    }

    public static void main(String[] args) throws Exception {
        char[] chars = new char[]{'A', 'A', 'B', 'C', 'D'};
        System.out.println( new Main().getTime(chars,5));;
    }
}
class Queue{
    private LinkedList<Character> linkedList;

    public Queue() {
        linkedList = new LinkedList<>();
    }
    public boolean isEmpty(){
        return linkedList.isEmpty();
    }
    public void insert(char key){
        linkedList.add(key);
    }
    public char delete() throws Exception {
        if(!isEmpty()){
                char a = linkedList.get(0);
                linkedList.remove(0);
                return a;
        }
        throw new Exception("Queue is Empty");
    }


    @Override
    public String toString() {
        return "Queue{" +
                "linkedList=" + linkedList +
                '}';
    }
}
