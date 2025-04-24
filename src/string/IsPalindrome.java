package string;

public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(palindromeWithReverseMethod("Hello"));
        System.out.println(palindromeTraditional("A man, a plan, a canal: Panama"));
    }

    //TC - O(N) || SC - O(1)
    private static boolean palindromeTraditional(String s) {
        int left = 0, right = s.length()-1;
        while(left<right){
            while(left<right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while(left<right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //TC - O(N) || SC - O(N)
    private static boolean palindromeWithReverseMethod(String word) {
        return word.equalsIgnoreCase(new StringBuffer(word).reverse().toString());
    }
}
