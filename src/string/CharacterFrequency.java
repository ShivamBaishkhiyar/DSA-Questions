package string;

import java.util.HashMap;
import java.util.Map;

public class CharacterFrequency {
    public static void main(String[] args) {
        characterFrequencyInString("abcbcadabfcfa");
    }

    private static void characterFrequencyInString(String word) {
        Map<Character, Integer> m = new HashMap<>();
        for (char ch : word.toCharArray()) {
            m.put(ch, m.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : m.entrySet()) {
            System.out.println(entry.getKey() + " : "+ entry.getValue());
        }
    }
}
