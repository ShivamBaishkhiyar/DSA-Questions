package string;

public class RemoveSpecialCharacter {
    public static void main(String[] args) {
        System.out.println(removeSpecialCharacter("Hello       @#$(*&W*&^%$or(*&^l(*&^d"));
    }

    //TC - O(N) || SC - O(N)
    private static String removeSpecialCharacter(String s) {
        StringBuilder str = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i)))
                str.append(s.charAt(i));
        }
        return str.toString();
    }
}
