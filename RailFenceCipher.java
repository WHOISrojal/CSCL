import java.util.Scanner;

public class RailFenceCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1 for Encryption or 2 for Decryption:");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        System.out.println("Enter the number of rails:");
        int rails = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        if (choice == 1) {
            System.out.println("Enter plaintext to encrypt:");
            String plaintext = scanner.nextLine();
            String encryptedText = encrypt(plaintext, rails);
            System.out.println("Encrypted Text: " + encryptedText);
        } else if (choice == 2) {
            System.out.println("Enter ciphertext to decrypt:");
            String ciphertext = scanner.nextLine();
            String decryptedText = decrypt(ciphertext, rails);
            System.out.println("Decrypted Text: " + decryptedText);
        } else {
            System.out.println("Invalid choice. Please enter 1 for Encryption or 2 for Decryption.");
        }

        scanner.close();
    }

    private static String encrypt(String text, int rails) {
        if (rails == 1) return text;

        StringBuilder[] rail = new StringBuilder[rails];
        for (int i = 0; i < rails; i++) {
            rail[i] = new StringBuilder();
        }

        int currentRail = 0;
        boolean goingDown = true;

        for (char c : text.toCharArray()) {
            rail[currentRail].append(c);
            if (currentRail == 0) {
                goingDown = true;
            } else if (currentRail == rails - 1) {
                goingDown = false;
            }
            currentRail += goingDown ? 1 : -1;
        }

        StringBuilder encryptedText = new StringBuilder();
        for (StringBuilder row : rail) {
            encryptedText.append(row);
        }

        return encryptedText.toString();
    }

    private static String decrypt(String text, int rails) {
        if (rails == 1) return text;

        int length = text.length();
        char[] decryptedText = new char[length];

        int cycleLength = 2 * (rails - 1);
        int currentIndex = 0;

        for (int currentRail = 0; currentRail < rails; currentRail++) {
            int step1 = cycleLength - 2 * currentRail;
            int step2 = cycleLength - step1;

            int position = currentRail;
            boolean toggle = true;

            while (position < length) {
                decryptedText[position] = text.charAt(currentIndex++);
                position += (currentRail == 0 || currentRail == rails - 1) ? cycleLength : (toggle ? step1 : step2);
                toggle = !toggle;
            }
        }

        return new String(decryptedText);
    }
}
