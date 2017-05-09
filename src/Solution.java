import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();

        HashSet<Character> charsSet = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            charsSet.add(str.charAt(i));
        }
        List<Character> charsList = new ArrayList<>(charsSet);

        int maxLength = 0;
        for (int i = 0; i < charsList.size(); i++) {
            for (int j = 0; j < i; j++) {
                String twoCharactersString = createString(str, charsList.get(i), charsList.get(j));
                if (isSymbolsAlternate(twoCharactersString) && twoCharactersString.length() > maxLength) {
                    maxLength = twoCharactersString.length();
                }
            }
        }

        System.out.println(maxLength);
    }

    private static boolean isSymbolsAlternate(String str) {
        char firstSymbol = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            if ((i % 2) == 0 && str.charAt(i) != firstSymbol || (i % 2) != 0 && str.charAt(i) == firstSymbol) {
                return false;
            }
        }

        return true;
    }

    private static String createString(String str, char first, char second) {
        String resultString = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == first) {
                resultString += first;
            } else if (str.charAt(i) == second) {
                resultString += second;
            }
        }

        return resultString;
    }
}
