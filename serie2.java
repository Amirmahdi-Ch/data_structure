import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String answer = new Main().inToPost("5+4");
        String answer2 = new Main().inToPre("5+4");
        
        System.out.println(answer);
        System.out.println(answer2);
        System.out.println(new Main().answer(answer));


        System.out.println("*****************");
        Stack<Integer> integers = new Stack<>();
        for (int i = 1;i<=11;i++){
            integers.push(i);
        }
        new Main().print(integers);
    }
    public int preced(char ch){
        if(ch == '*' || ch == '/'){
            return 2;
        }
        else if(ch == '+' || ch == '-'){
            return 1;
        }
        else if (ch == '^'){
            return 3;
        }
        else{
            return 0;
        }
    }
    public boolean isOprand(char ch){
        if(ch == '(' || ch == ')'
           || ch == '*' || ch == '/'
                || ch == '^'||
            ch == '+' || ch == '-'){
            return true;
        }
        return false;
    }
    // question 1
    public String inToPost(String infix){
        String result = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i<infix.length();i++){
            char ch = infix.charAt(i);
            if(! isOprand(ch)){
                result+= ch;
            }
            else{
                if(ch == '('){
                    stack.push(ch);
                }
                else if(ch == ')'){
                    while (!stack.isEmpty() && stack.peek() != '('){
                        char top = stack.pop();
                        result+= top;
                    }
                  //  if (!stack.isEmpty()){

                    stack.pop();
                    //}
                }
                else{
                    if(stack.isEmpty()||preced(ch) >preced(stack.peek())){
                        stack.push(ch);
                    }
                    else{
                        while (!stack.isEmpty() && preced(ch) <= preced(stack.peek())){
                            result+= stack.pop();
                        }
                        stack.push(ch);
                    }
                }
            }
        }
            while (!stack.isEmpty()){
                result+=stack.pop();
            }
            return result;
    }
    public int answer(String postfix){
        Stack<String> stack = new Stack<>();
        for (int i = 0;i<postfix.length();i++){
            char ch = postfix.charAt(i);
            if(!isOprand(ch)){
                stack.push(ch+"");
            }
            else {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                int c = 0;
                switch (ch){
                    case '+':
                        c = a+b;
                        break;
                    case '-':
                        c = a - b;
                        break;
                    case '*':
                        c = a * b;
                        break;
                    case '/':
                        c = a/b;
                        break;
                    case '^':
                        c = (int) Math.pow(a,b);
                }
                stack.push(c+"");
            }

        }
        return Integer.parseInt(stack.pop());
    }
    // question 2
    public String inToPre(String infix){
        StringBuilder stringBuilder = new StringBuilder(infix);
        infix = stringBuilder.reverse().toString();

        for (int i = 0;i<infix.length();i++){
            if (infix.charAt(i) == '('){
                StringBuilder builder = new StringBuilder(infix);
                builder.setCharAt(i, ')');
                infix = builder.toString();

            }
            else if (infix.charAt(i) == ')'){
                StringBuilder builder = new StringBuilder(infix);
                builder.setCharAt(i, '(');
                infix = builder.toString();

            }
        }
        String prefix = inToPost(infix);
        StringBuilder stringBuilder2 = new StringBuilder(prefix);
        prefix = stringBuilder2.reverse().toString();
        return prefix;
    }

    // question 5
    public void print(Stack objects){
        Stack objects2 = new Stack();

            int n = objects.size();
            int size = n;
            int count = 0;
       outer: for (int i = 1;i<=Math.floor(n/2)+1;i++){
                size = objects.size();
            for (int j = 1;j<=size;j++){
                objects2.push(objects.pop());
            }
            for (int k = 1;k<=i;k++){
                System.out.print(objects2.pop()+ " ");
                count++;
                if (count==n)break outer;
                //objects.push(objects2.pop());
            }
            for (int k = i+1;k<=size;k++){
                objects.push(objects2.pop());
            }
           size = objects2.size();
            for (int j = 1;j<=size;j++){
                objects2.push(objects.pop());
            }
            i++;
            System.out.println();
            objects2.size();
            for (int j = 1;j<=size;j++){
                objects.push(objects2.pop());
            }
            for (int k = 1;k<=i;k++){
                System.out.print(objects.pop()+ " ");
                count++;
                if (count==n)break outer;
                //objects2.push(objects.pop());
            }
            for (int k = i+1;k<=size;k++){
                objects2.push(objects.pop());
            }
           size = objects2.size();
            for (int j = 1;j<=size;j++){
                objects.push(objects2.pop());
            }

            System.out.println();
        }

    }
}
