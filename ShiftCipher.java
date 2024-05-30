import java.util.Scanner;

public class ShiftCipher {
    private static final int SHIFT_KEY = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter 1 for Encryption or 2 for Decryption:");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        if (choice == 1) {
            System.out.println("Enter plaintext to encrypt:");
            String plaintext = scanner.nextLine();
            String encryptedText = encrypt(plaintext, SHIFT_KEY);
            System.out.println("Encrypted Text: " + encryptedText);
        } else if (choice == 2) {
            System.out.println("Enter ciphertext to decrypt:");
            String ciphertext = scanner.nextLine();
            String decryptedText = decrypt(ciphertext, SHIFT_KEY);
            System.out.println("Decrypted Text: " + decryptedText);
        } else {
            System.out.println("Invalid choice. Please enter 1 for Encryption or 2 for Decryption.");
        }

        scanner.close();
    }

    private static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char charAtPosition = text.charAt(i);
            if (Character.isUpperCase(charAtPosition)) {
                char ch = (char) (((charAtPosition + shift - 'A') % 26) + 'A');
                result.append(ch);
            } else if (Character.isLowerCase(charAtPosition)) {
                char ch = (char) (((charAtPosition + shift - 'a') % 26) + 'a');
                result.append(ch);
            } else {
                result.append(charAtPosition); // Non-alphabetic characters are appended as-is
            }
        }
        return result.toString();
    }

    private static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift);
    }
}