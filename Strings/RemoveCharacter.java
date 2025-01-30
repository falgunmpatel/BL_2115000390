import java.util.Scanner;
public class RemoveCharacter {

    public static String removeCharacter(String input, char characterToRemove) {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch != characterToRemove) {
                result += ch;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        System.out.println("Enter the character to remove:");
        char characterToRemove = scanner.next().charAt(0);
        System.out.println("Modified String: " + removeCharacter(input, characterToRemove));
    }
}
