import java.util.Scanner;

public class SubstringOccurrences {

    public static int countSubstringOccurrences(String text, String sub) {
        int count = 0, index = 0;
        while (index + sub.length() <= text.length()) {
            if (text.charAt(index) == sub.charAt(0)) {
                int i = 0;
                while (i < sub.length() && text.charAt(index + i) == sub.charAt(i)) {
                    i++;
                }
                if (i == sub.length()) {
                    count++;
                }
            }
            index++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = scanner.nextLine();
        System.out.println("Enter the substring to count:");
        String sub = scanner.next();
        System.out.println("Occurrences: " + countSubstringOccurrences(text, sub));
    }
}
