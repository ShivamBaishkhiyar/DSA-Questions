package string;

public class StringReverse {
    public static void main(String[] args) {
        String word = "Hello World";
        System.out.println(reverseString(word));
        System.out.println(reverseUsingStringBuilder(word));
    }

    // This problem can be solved in O(n) time and O(n) space in Java due to string immutability.
    // We convert the string to a char array or use a StringBuilder, then reverse it.
    private static String reverseUsingStringBuilder(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    private static String reverseString(String word) {
        int i=0, j=word.length()-1;
        char[] wordArray = word.toCharArray();
        while(i<j){
            char temp = wordArray[i];
            wordArray[i] = wordArray[j];
            wordArray[j] = temp;
            i++;
            j--;
        }
        //return new String(wordArray);
        return String.valueOf(wordArray);
    }
}
