package string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(firstNonRepeatingCharacterInString("abcbcadabfcfa"));
    }

    private static Character firstNonRepeatingCharacterInString(String word) {
        Map<Character,Integer> m = new HashMap<>();
        for(char ch : word.toCharArray()){
                m.put(ch,m.getOrDefault(ch,0)+1);
        }
//        for(char ch : word.toCharArray()){
//            if(m.get(ch)==1){
//                return ch;
//            }
//        }
        for(Map.Entry<Character,Integer> entry : m.entrySet()){
            if(entry.getValue()==1)
                return entry.getKey();
        }
        return null;
    }
}
