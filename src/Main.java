import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Postfix p = new Postfix();
        System.out.println("Enter the equation you want to solve:");
        String S=sc.nextLine();
        String s=(p.infixToPost(S));
        System.out.println("the postfix of the equation:");
        System.out.println(s);
        System.out.println("the result is :");
        System.out.println(p.evaluationPostfix(s));
    }
}

