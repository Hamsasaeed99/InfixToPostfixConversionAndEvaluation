class Node{
    double data;
    Node next;

    public Node(double data) {
        this.data = data;
        next=null;
    }
}

public class Stack {
    Node Top;
    public Stack(){
        this.Top=null;
    }

    public void push(double x){
        Node n=new Node(x);
        n.next=Top;
        Top=n;
    }

    public double pop(){
        if (isEmpty()) {
            System.out.println("the Stack is empty");
            return -1;
        }else {
            double x = Top.data;
            Top = Top.next;
            return x;
        }
    }

    public boolean isEmpty(){
        return Top==null;
    }

    public void print(){
        Node temp = Top;
        System.out.print("the stack (top to bottom): ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
