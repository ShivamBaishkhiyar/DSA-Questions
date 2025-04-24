package string;

public class CountWordsInSentence {
    public static void main(String[] args) {
        System.out.println(countWordsInASentence("  Hello How are You today!!        "));
        System.out.println(countWordsInASentenceWithSplit("  Hello How     are You today!!        "));
    }

    //Handles space in between also
    //TC - O(N) || SC - O(N)
    private static int countWordsInASentenceWithSplit(String s) {
        if(s == null || s.trim().isEmpty()){
            return 0;
        }
        String[] words = s.trim().split("\\s+");
        return words.length;
    }

    //TC - O(N) || SC - O(1)
    private static int countWordsInASentence(String s) {
        s = s.trim();
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                count++;
            }
        }
        return count+1;
    }
}
