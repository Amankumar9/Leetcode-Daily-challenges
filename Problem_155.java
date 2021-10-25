import java.util.*;

class MinStack {
    Stack<Integer> stack1, stack2;
    public MinStack() {
        stack1=new Stack<Integer>();
        stack2=new Stack<Integer>();
    }

    public void push(int val) {
        stack1.push(val);
        if(stack2.isEmpty()){
            stack2.push(val);
        }else{
            stack2.push(Math.min(stack2.peek(), stack1.peek()));
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
