package string;

public class StringToInt {
    public static void main(String[] args) {
        System.out.println(convertStringToInt("-11234"));
        System.out.println(customConvertStringToInt("+11234324"));
    }

    //Inbuilt function
    private static int convertStringToInt(String num) {
        return Integer.parseInt(num);
    }

    // Custom
    //T.C - O(N)   S.C - O(1)
    private static int customConvertStringToInt(String num) {
        int sign = 1;
        int result = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '+') {
                sign = 1;
                continue;
            }
            if (num.charAt(i) == '-') {
                sign = -1;
                continue;
            }
            char c = num.charAt(i);
            result = result * 10 + (c - '0');
        }
        return result * sign;
    }
}
