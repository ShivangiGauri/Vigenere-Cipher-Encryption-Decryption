import java.util.Scanner;

public class VigenereCipher {

    // Method to encrypt the text
    public static String encrypt(String text, String keyword) {
        StringBuilder result = new StringBuilder();
        keyword = keyword.toUpperCase();
        int keywordIndex = 0;

        for (int i = 0; i < text.length(); i++) {
            char charToEncrypt = text.charAt(i);
            if (Character.isUpperCase(charToEncrypt)) {
                char encryptedChar = (char) (((charToEncrypt - 'A' + keyword.charAt(keywordIndex) - 'A') % 26) + 'A');
                result.append(encryptedChar);
                keywordIndex = (keywordIndex + 1) % keyword.length();
            } else if (Character.isLowerCase(charToEncrypt)) {
                char encryptedChar = (char) (((charToEncrypt - 'a' + keyword.charAt(keywordIndex) - 'A') % 26) + 'a');
                result.append(encryptedChar);
                keywordIndex = (keywordIndex + 1) % keyword.length();
            } else {
                result.append(charToEncrypt); // Keep non-alphabetic characters unchanged
            }
        }

        return result.toString();
    }

    // Method to decrypt the text
    public static String decrypt(String text, String keyword) {
        StringBuilder result = new StringBuilder();
        keyword = keyword.toUpperCase();
        int keywordIndex = 0;

        for (int i = 0; i < text.length(); i++) {
            char charToDecrypt = text.charAt(i);
            if (Character.isUpperCase(charToDecrypt)) {
                char decryptedChar = (char) (((charToDecrypt - 'A' - (keyword.charAt(keywordIndex) - 'A') + 26) % 26) + 'A');
                result.append(decryptedChar);
                keywordIndex = (keywordIndex + 1) % keyword.length();
            } else if (Character.isLowerCase(charToDecrypt)) {
                char decryptedChar = (char) (((charToDecrypt - 'a' - (keyword.charAt(keywordIndex) - 'A') + 26) % 26) + 'a');
                result.append(decryptedChar);
                keywordIndex = (keywordIndex + 1) % keyword.length();
            } else {
                result.append(charToDecrypt); // Keep non-alphabetic characters unchanged
            }
        }

        return result.toString();
    }

    // Example usage
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            System.out.println("Enter the text to encrypt:");
            String plaintext = scanner.nextLine();
            System.out.println("Enter the keyword:");
            String keyword = scanner.nextLine();
            String ciphertext = encrypt(plaintext, keyword);
            System.out.println("Encrypted: " + ciphertext);
        } else if (choice == 2) {
            System.out.println("Enter the text to decrypt:");
            String ciphertext = scanner.nextLine();
            System.out.println("Enter the keyword:");
            String keyword = scanner.nextLine();
            String decryptedText = decrypt(ciphertext, keyword);
            System.out.println("Decrypted: " + decryptedText);
        } else {
            System.out.println("Invalid choice. Please choose 1 or 2.");
        }

        scanner.close();
    }
}
