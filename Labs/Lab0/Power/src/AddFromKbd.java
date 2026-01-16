import java.util.Scanner;

public class AddFromKbd {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter num 1: ");
        int num1 = in.nextInt();
        System.out.print("Enter num 2: ");
        int num2 = in.nextInt();
        int sum = num1 + num2;
        System.out.println(num1 + " + " + num2 + " = " + sum);
    }
}
