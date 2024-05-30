import java.util.Scanner;

public class CoPrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number:");
        int num1 = scanner.nextInt();

        System.out.println("Enter the second number:");
        int num2 = scanner.nextInt();

        if (areCoprime(num1, num2)) {
            System.out.println(num1 + " and " + num2 + " are coprime.");
        } else {
            System.out.println(num1 + " and " + num2 + " are not coprime.");
        }

        scanner.close();
    }

    private static boolean areCoprime(int a, int b) {
        return gcd(a, b) == 1;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
