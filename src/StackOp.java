
    class Noded{
        char data;
        Noded next;

        public Noded(char data) {
            this.data = data;
            next=null;
        }
    }
    public class StackOp {

        Noded Top;
        public StackOp(){
            this.Top=null;
        }

        public void push(char x){
            Noded n=new Noded(x);
            n.next=Top;
            Top=n;
        }

        public char pop(){
            if (isEmpty()) {
                System.out.println("the Stack is empty");
                return '\0';
            }else {
                char x = Top.data;
                Top = Top.next;
                return x;
            }
        }

        public char top(){
            return Top.data;
        }

        public boolean isEmpty(){
            return Top==null;
        }

        public void print(){
            Noded temp = Top;
            System.out.print("the stack (top to bottom): ");
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }


