package cryptography;

import java.util.Scanner;

/*
    XOR cipher is a simple encryption technique that uses the XOR (exclusive OR) operation to encrypt and decrypt messages.

 */
public class XOR_cipher {
    // XOR encryption/decryption method
    public static String xorCipher(String text, char key) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // XOR each character with key
            char encryptedChar = (char) (ch ^ key);

            result.append(encryptedChar);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter message: ");
        String message = scanner.nextLine();

        System.out.print("Enter a single character key: ");
        char key = scanner.next().charAt(0);

        // Encrypt
        String encrypted = xorCipher(message, key);
        System.out.println("Encrypted text: " + encrypted);

        // Decrypt (XOR again with same key)
        String decrypted = xorCipher(encrypted, key);
        System.out.println("Decrypted text: " + decrypted);

        scanner.close();
    }
}
