package stack;

public class StackImplementation {
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    private Node top;
    private int height;
    public StackImplementation(int data){
        Node node = new Node(data);
        top = node;
        height = 1;
    }
    public StackImplementation() {
        top = null;
        height = 0;
    }
    public void getTop(){
        System.out.println(top.data);
    }
    public void getHeight(){
        System.out.println(height);
    }
    public void printStack(){
        Node node = top;
        while(node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }
    public void push(int data){
        Node node = new Node(data);
        if(top == null){
            top = node;
        }else{
            node.next = top;
            top = node;
        }
        height++;



    }
    public boolean isEmpty(){
        return top == null;
    }
    public Node pop(){
        if(isEmpty()) return null;
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }
    /**
     * Loops through each character in the string.
     * '(' → push it onto the stack.
     * ')' → if stack is not empty, pop (a match is found),
     *        if stack is empty, return false (no matching '(').
     * After the loop, return true only if the stack is empty
     * (all opening brackets were matched).
     */
    public static boolean isBalancedParentheses(String parentheses) {
        StackImplementation stack = new StackImplementation();

        for (char bracket : parentheses.toCharArray()) {
            if (bracket == '(') {
                stack.push(bracket);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
    /**
     * Takes a stack, pops each element and inserts it into a second stack
     * in sorted order. Elements larger than the top of secondStack go straight on.
     * Smaller elements cause secondStack to move items back to firstStack
     * until the right position is found. Finally, transfers everything back.
     */
    public static StackImplementation sortStack(StackImplementation firstStack) {
        if (firstStack.isEmpty()) return firstStack;
        StackImplementation secondStack = new StackImplementation();

        while (!firstStack.isEmpty()) {
            int temp = firstStack.pop().data;

            while (!secondStack.isEmpty() && temp < secondStack.top.data) {
                firstStack.push(secondStack.pop().data);
            }

            secondStack.push(temp);
        }

        while (!secondStack.isEmpty()) {
            firstStack.push(secondStack.pop().data);
        }

        return firstStack;
    }

}
