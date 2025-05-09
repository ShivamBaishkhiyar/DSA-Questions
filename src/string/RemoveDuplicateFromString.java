package string;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateFromString {
    public static void main(String[] args) {
        System.out.println(removeDuplicateFromString("aabbbcccdddeeeffffgghhi"));
        System.out.println(removeDuplicateFromStringWithoutCollection("aabbbcccdddeeeffffgghhi"));
    }

    private static String removeDuplicateFromStringWithoutCollection(String word) {
        StringBuilder sb = new StringBuilder();
        boolean[] seen = new boolean[256];
        for(char ch : word.toCharArray()){
            if(!seen[ch]){
                sb.append(ch);
                seen[ch] = true;
            }
        }
        return sb.toString();
    }

    private static String removeDuplicateFromString(String word) {
        Set<Character> set = new LinkedHashSet<>();
        for(char ch : word.toCharArray()){
            set.add(ch);
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : set){
            sb.append(ch);
        }
        return sb.toString();
    }
}
