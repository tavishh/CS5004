/**
 * 1. The python file can use math directly. In Java we have to use the Math.pow module.
 * 2. We need to define the correct type in Java whereas in python we do not need to.
 * 3. In Java, we need a class and main method structure whereas in python we can run directly.
 */

public class Power {
    public static void main(String[] args) {
        long result = (long) Math.pow(2, 31);
        System.out.println("2^31 = " + result);
    }
}