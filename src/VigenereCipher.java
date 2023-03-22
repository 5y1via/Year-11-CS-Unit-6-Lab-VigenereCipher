public class VigenereCipher {
    private String key;
    private String alphabet;
    private char shiftOneLetter(char letter, int shift) {
        char result;
        int change;
        if ((letter <= 90 && letter >= 65)) {
            change = (char) (((int) letter - 65 + shift + (26 * 10)) % 26);
            result = (char) (change + 'a');
        } else if ((letter <= 122 && letter >= 97)) {
            change = (((int) letter - 97 + shift + (26 * 10)) % 26);
            result = (char) (change + 'a');
        } else {
            result = letter;
        }
        return result;
    }
    public VigenereCipher(String key) {
        alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.key = key.toLowerCase();
    }
    public String getKey() {
        return key;
    }
    public String getAlphabet() {
        return alphabet;
    }
    public String encode(String input) {
        String encoded = "";
        for (int i = 0; i < input.length(); ++i) {
            encoded = encoded + shiftOneLetter(input.charAt(i), key.charAt(i % key.length()) - 97);
        }
        return encoded.toLowerCase();
    }
    public String decode(String input) {
        String decoded = "";
        for (int i = 0; i < input.length(); ++i) {
            decoded = decoded + shiftOneLetter(input.charAt(i), -1 * (key.charAt(i % key.length()) - 97));
        }
        return decoded.toLowerCase();
    }
}