class MinStack {

    class Node {
        int val;
        int min=Integer.MAX_VALUE;
        Node(int val) {
            this.val = val;
            this.min = Math.min(min,val);
        }
        Node(int val, int prevMin) {
            this.val = val;
            this.min = Math.min(val, prevMin);
        }
    }
    Stack<Node> stack;


    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Node(val));
        }
        else {
            stack.push(new Node(val, stack.peek().min));
        }        
    }
    
    public void pop() {
        stack.pop();
        
    }
    
    public int top() {
        return stack.peek().val;
        
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}
