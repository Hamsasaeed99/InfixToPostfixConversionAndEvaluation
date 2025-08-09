public class Postfix {
    String postfix ="";
    StackOp operator=new StackOp();
    Stack result=new Stack();



    public int pro(char C) {
        if (C == '-' || C == '+')
            return 1;
        else if (C == '*' || C == '/')
            return 2;
        else if (C == '^')
            return 3;
        return 0;
    }


    public String infixToPost(String n) {
        for (int i = 0; i < n.length(); i++) {
            char c=n.charAt(i);
            if (c==' ' || c=='\t'|| c=='\n') {
                continue;
            } else if (c>='0'&&c<='9') {
                String no="";
                while (i<n.length()&&n.charAt(i)>='0'&&n.charAt(i)<='9'){
                    no+=n.charAt(i);
                    i++;
                }
                i--;
                postfix+=no+" ";
            } else if (c=='(') {
                operator.push(c);
            } else if (c==')') {
                while (!operator.isEmpty()&&operator.top()!='('){
                    postfix+=operator.pop()+" ";
                }
                operator.pop();
            } else {
                while (!operator.isEmpty() && pro(c) <= pro(operator.top())) {
                    postfix +=(operator.pop())+" ";
                }
                operator.push(c);
            }
        }
        while (!operator.isEmpty()) {
            postfix +=(operator.pop())+" ";
        }
        return postfix;
    }

    public double evaluationPostfix(String postfix){
        int i=0;
        while (i<postfix.length()){
            if (postfix.charAt(i)==' ') {
                i++;
                continue;
            } else if(postfix.charAt(i)>='0'&& postfix.charAt(i)<='9'){
                int j=i;
                while (postfix.charAt(i)>='0'&&postfix.charAt(i)<='9'){
                    i++;
                }
                double x=no(postfix,j,i);
                result.push(x);
            }else{
                double re2=result.pop();
                double re1=result.pop();
                if (postfix.charAt(i)=='+')
                    result.push(re2+re1);
                else if (postfix.charAt(i)=='-')
                    result.push(re1-re2);
                else if (postfix.charAt(i)=='*')
                    result.push(re1*re2);
                else if (postfix.charAt(i)=='/'){
                    if(re2==0){
                        System.out.println("Can't divided by 0");
                        return -1;
                    }
                    result.push(re1/re2);
                }
                else if (postfix.charAt(i)=='^')
                    result.push(Math.pow(re1,re2));
                i++;
                System.exit(2);
            }
        }
        return result.pop();
    }

    public double no(String postfix, int i, int j) {
        double nom = Double.parseDouble(postfix.substring(i,j));
        return nom;
    }

}