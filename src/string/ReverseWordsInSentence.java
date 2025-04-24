package string;

public class ReverseWordsInSentence {
    public static void main(String[] args) {
        System.out.println(reverseWordsInSentence("Reverse words in Sentence"));
    }

    //TC - O(N) || SC - O(N)
    private static String reverseWordsInSentence(String s) {
        if(s == null || s.trim().isEmpty())
            return s;
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i= words.length-1; i>=0; i--){
            sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
