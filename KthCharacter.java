public class KthCharacter {
    public char kthCharacter(int k) {
        StringBuilder word = new StringBuilder("a");

        while (word.length() < k) {
            StringBuilder next = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                char nextChar = (char)((ch - 'a' + 1) % 26 + 'a');
                next.append(nextChar);
            }
            word.append(next);
        }

        return word.charAt(k - 1);
    }

    public static void main(String[] args) {
        KthCharacter sol = new KthCharacter();
        int k = 5;
        char result = sol.kthCharacter(k);
        System.out.println("The " + k + "th character is: " + result);
    }
}
