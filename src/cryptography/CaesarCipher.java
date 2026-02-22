package cryptography;

import java.util.Scanner;

/*
    Caesar Cipher is a simple substitution cipher where each letter in the plaintext is shifted a certain number of places down the alphabet.
    For example, with a shift of 3, 'A' would be replaced by 'D', 'B' would become 'E', and so on.
    The cipher wraps around the alphabet, so 'Z' would become 'C'.
    The Caesar Cipher is named after Julius Caesar, who reportedly used it to communicate with his officials.
    It is one of the earliest and simplest forms of encryption, but it is not secure by modern standards and can be easily broken with frequency analysis or brute-force attacks.

 */

public class CaesarCipher {
    // Encrypt method
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isUpperCase(ch)) {
                char encrypted = (char) ((ch - 'A' + shift) % 26 + 'A');
                result.append(encrypted);
            }
            else if (Character.isLowerCase(ch)) {
                char encrypted = (char) ((ch - 'a' + shift) % 26 + 'a');
                result.append(encrypted);
            }
            else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    // Decrypt method
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26));
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter message: ");
        String message = scanner.nextLine();

        System.out.print("Enter shift value: ");
        int shift = scanner.nextInt();

        String encrypted = encrypt(message, shift);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = decrypt(encrypted, shift);
        System.out.println("Decrypted: " + decrypted);

        scanner.close();
    }
}
